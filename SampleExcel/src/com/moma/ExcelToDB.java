package com.moma;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.moma.db.DBInsert;
import com.moma.excel.ActualSheetInfo;
import com.moma.excel.ColumnInfo;
import com.moma.excel.SheetInfo;

public class ExcelToDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String url = "jdbc:mysql://localhost:3306/adsk";        // 사용하려는 데이터베이스명을 포함한 URL 기술
		String id = "bgcho98";                                                    // 사용자 계정
		String pw = "2417bgbg";                                                // 사용자 계정의 패스워드
		String driver = "com.mysql.jdbc.Driver"; 

		String excelFilePath = "e:\\test\\FY16_Q4_LC Billings Korea_Template_daon.xlsx";
		
		ExcelToDB etb = new ExcelToDB();
		etb.setExcelFilePath(excelFilePath);
		etb.setDB(url, id, pw, driver);
		
		etb.execute(new ActualSheetInfo());
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

	private void execute(ActualSheetInfo actualSheetInfo) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DBInsert db = new DBInsert(url, id, pw, driver);
		db.beginTransaction();
		
		walk(excelFilePath, actualSheetInfo, db);
		
		db.commit();
		
	}

	private void walk(String excelFilePath, SheetInfo sheetInfo, DBInsert db) throws FileNotFoundException, IOException {
		File file = new File(excelFilePath);
		
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
		
		XSSFSheet sheet = wb.getSheet(sheetInfo.getSheetName());
		ColumnInfo[] columnInfo = sheetInfo.getColumns();
		
		for(Row row : sheet) {
			int i = 0;
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
			}
			
			
			if(isInsert) {
				System.out.println();
			}
		}
	}

	private String getValue(Cell cell) {
		String value = null;
		
		switch( cell.getCellType()) {
			case Cell.CELL_TYPE_STRING :
				value = cell.toString();
				break;
			case Cell.CELL_TYPE_NUMERIC :
                if(DateUtil.isCellDateFormatted(cell))
                	value = cell.getDateCellValue().toString();
                else
                    value = Integer.toString((int)cell.getNumericCellValue());
                break;
			case Cell.CELL_TYPE_BOOLEAN :
                value = "" + cell.getBooleanCellValue();
                break;
			case Cell.CELL_TYPE_FORMULA :
				value = cell.getCellFormula();
				break;
			default:
				value = cell.toString();
				break;
		}
		
		return value;
	}


}
