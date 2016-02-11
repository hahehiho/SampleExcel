package com.moma.excel;

abstract public class SheetInfo {
	protected String tableName;
	protected String sheetName;
	protected ColumnInfo[] columns;
	protected String[] updateQuery;
	
	protected SheetInfo(String sheetName, String tableName) {
		this.tableName = tableName;
		this.sheetName = sheetName;
		initColumns();
	}
	
	public String getSheetName() {
		return sheetName;
	}
	
	public String getTableName() {
		return tableName;
	}

	public ColumnInfo[] getColumns() {
		return columns;
	}
	
	abstract public void initColumns();

	protected void setColumns(ColumnInfo[] myColumns) {
		columns = myColumns;
	}

	public String[] getUpdateQuery() {
		return updateQuery;
	}

}
