package com.moma.excel;

import org.apache.poi.hssf.util.CellReference;

public class ColumnInfo {
	public static final int TYPE_SKIP 	= 99;
	public static final int TYPE_NUMBER	= 0;
	public static final int TYPE_DATE	= 1;
	public static final int TYPE_STRING	= 2;
		
	public int type;
	public int excelColumn;
	public String dbColumn;
	public String value;
	
	public ColumnInfo(String excelColumn, String dbColumn, int type) {
		this.type = type;
		this.excelColumn = 	CellReference.convertColStringToIndex(excelColumn);;
		this.dbColumn = dbColumn;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getQueryValue() {
		String queryValue = "";
		
		switch(type) {
		case TYPE_SKIP:
			break;
		case TYPE_NUMBER:
			if(value.isEmpty()) {
				queryValue = "0";
			}else { 
				queryValue = value;
			}
			break;
		case TYPE_DATE:
			if(value.isEmpty())
				queryValue = "NULL";
			else
				queryValue = "STR_TO_DATE('" + value + "', '%m/%d/%Y')";
			break;
		case TYPE_STRING:
			value = value.replace("\\", "\\\\");
			queryValue = "'" + value + "'"; 
			break;
		}
		return queryValue;
	}
	
	public String toString() {
		String str = "";
		str += "type="+type + ",excelColumn="+excelColumn + ",dbColumn="+dbColumn+",value="+value;
		
		return str;
	}
}
