package com.moma.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Tester {

	public static void main(String[] args) {
		File file = new File("e:\\test\\FY16_Q4_LC Billings Korea_Template_daon.xlsx");
		XSSFWorkbook wb = null;
		
		try {//엑셀 파일 오픈
			wb = new XSSFWorkbook(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = wb.getSheet("Actual");
		
		for(Row row : sheet) {
			int i = 0;
			boolean isPrint = false;
			for(Cell cell : row) {
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

				
				if(i == 0 && value.isEmpty())
					break;
				
				if(i == 0)
					System.out.print("> ");
				
				System.out.print(cell.getCellType() + ":" + value);
				System.out.print(" | ");
				isPrint = true;
				i++;
			}
			if(isPrint)
				System.out.println();
		}
	}

}
