package com.moma;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.BatchUpdateException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.moma.db.DBInsert;
import com.moma.excel.ActualSheetInfo;
import com.moma.excel.ClearDBSheetInfo;
import com.moma.excel.ColumnInfo;
import com.moma.excel.EnforcementSheetInfo;
import com.moma.excel.LeadSheetInfo;
import com.moma.excel.SAPSheetInfo;
import com.moma.excel.SAPSheetInfoLD;
import com.moma.excel.SheetInfo;

public class ExcelToDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String url = "jdbc:mysql://localhost:3306/adsk?autoReconnect=true&useSSL=false";        // 사용하려는 데이터베이스명을 포함한 URL 기술
		String id = "bgcho98";                                                    // 사용자 계정
		String pw = "2417bgbg";                                                // 사용자 계정의 패스워드
		String driver = "com.mysql.jdbc.Driver"; 

//		String excelFilePath = "e:\\test\\FY16_Q4_LC Billings Korea_Template_daon.xlsx";
//		String excelFilePath = "e:\\test\\FY14 to FY16 SAP orders_0201_참고용.xlsx";
//		String excelFilePath = "e:\\test\\Q3FY16 SAP Orders_1023.xlsx";
		String excelFilePath = "e:\\test\\CLEAR 20160201.xlsx";
		
		ExcelToDB etb = new ExcelToDB();
		etb.setExcelFilePath(excelFilePath);
		etb.setDB(url, id, pw, driver);
		
//		etb.execute(new ActualSheetInfo());
//		etb.execute(new LeadSheetInfo());
//		etb.execute(new EnforcementSheetInfo());
//		etb.execute(new SAPSheetInfo());
//		etb.execute(new SAPSheetInfoLD());
		etb.execute(new ClearDBSheetInfo());
	}


	private String url;
	private String id;
	private String pw;
	private String driver;
	private String excelFilePath;

	private void setDB(String url, String id, String pw, String driver) {
		this.url = url;
		this.id = id;
		this.pw = pw;
		this.driver = driver;
	}

	private void setExcelFilePath(String excelFilePath) {
		this.excelFilePath = excelFilePath;
	}

	private void execute(SheetInfo sheetInfo) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DBInsert db = new DBInsert(url, id, pw, driver);
		db.beginTransaction();
		
		walk(excelFilePath, sheetInfo, db);
		db.executeBatch();
		
		String[] afterUpdateQuery = sheetInfo.getUpdateQuery();
		for (String query : afterUpdateQuery) {
			db.execute(query);
		}
		
		db.commit();
		db.close();
		
	}

	private void walk(String excelFilePath, SheetInfo sheetInfo, DBInsert db) throws FileNotFoundException, IOException, SQLException {
		File file = new File(excelFilePath);
		
		long startTime = System.currentTimeMillis();
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
		long endTime = System.currentTimeMillis();
		System.out.println("workbook open = " + (endTime - startTime));
		
		XSSFSheet sheet = wb.getSheet(sheetInfo.getSheetName());
		ColumnInfo[] columnInfo = sheetInfo.getColumns();
		
		startTime = System.currentTimeMillis();
		int i = 0;
		int count = 0;
		for(Row row : sheet) {
			if( i == 0) {
				i++;
				continue;
			}
			
			boolean isInsert = true;
			
			for(int j = 0; j < columnInfo.length; j++) {
				Cell cell = row.getCell(columnInfo[j].excelColumn);
				String value = getValue(cell);
				
				if(j == 0 && (value == null || value.isEmpty())) {
					isInsert = false;
					break;
				}
				
				columnInfo[j].setValue(value);
			}
			
			if(!isInsert)
				continue;

			db.executeBatchInsert(sheetInfo.getTableName(), columnInfo);
			count++;
			
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("all loop (" + count + ") = " + (endTime - startTime) + "mesc");

		wb.close();
	}

	private String getValue(Cell cell) {
		String value = null;
		if(cell == null)
			return "";
		
		switch( cell.getCellType()) {
			case Cell.CELL_TYPE_STRING :
				value = cell.toString();
				break;
			case Cell.CELL_TYPE_NUMERIC :
                if(DateUtil.isCellDateFormatted(cell) ||  cell.getCellStyle().getDataFormatString().equals("mm\"월\"\\ dd\"일\"")) {
                	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    value = sdf.format(cell.getDateCellValue());
                } else
                    value = Integer.toString((int)cell.getNumericCellValue());
                break;
			case Cell.CELL_TYPE_BOOLEAN :
                value = "" + cell.getBooleanCellValue();
                break;
			case Cell.CELL_TYPE_FORMULA :
				value = cell.getCellFormula();
				if(value.indexOf("VLOOKUP") >= 0 || value.indexOf("SUM") >= 0 || value.indexOf("IFERROR") >= 0)
					value = "";
				break;
			default:
				value = cell.toString();
				break;
		}
		
		return value;
	}


}
