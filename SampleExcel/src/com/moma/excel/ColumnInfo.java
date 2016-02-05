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
	
	public ColumnInfo(String excelColumn, String dbColumn, int type) {
		this.type = type;
		this.excelColumn = 	CellReference.convertColStringToIndex(excelColumn);
;
		this.dbColumn = dbColumn;
	}
}
