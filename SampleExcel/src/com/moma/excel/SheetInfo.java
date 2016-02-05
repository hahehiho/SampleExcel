package com.moma.excel;

public class SheetInfo {
	protected String tableName;
	protected String sheetName;
	protected ColumnInfo[] columns;
	
	public String getSheetName() {
		return sheetName;
	}
	
	public String getTableName() {
		return tableName;
	}

	public ColumnInfo[] getColumns() {
		return columns;
	}

}
