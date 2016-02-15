package com.moma.excel;

public class SAPSheetInfoLD extends SheetInfo {
	public SAPSheetInfoLD() {
		super("RD", "sapdb");		
		updateQuery = new String[]{
		};
	}

	@Override
	public void initColumns() {
		ColumnInfo[] myColumns = new ColumnInfo[] {
				new ColumnInfo("G", "sapordernumber", ColumnInfo.TYPE_STRING),
				new ColumnInfo("H", "saptransdate", ColumnInfo.TYPE_DATE),
				new ColumnInfo("AE", "creditstatus", ColumnInfo.TYPE_STRING),
				new ColumnInfo("AI", "materialgroup", ColumnInfo.TYPE_STRING),
				new ColumnInfo("AJ", "materialdescription", ColumnInfo.TYPE_STRING),
				new ColumnInfo("AK", "currency", ColumnInfo.TYPE_STRING),
				new ColumnInfo("AL", "itemnetvalue", ColumnInfo.TYPE_NUMBER),
				new ColumnInfo("AO", "orderqty", ColumnInfo.TYPE_NUMBER),
				new ColumnInfo("BA", "endusername", ColumnInfo.TYPE_STRING),
				new ColumnInfo("BC", "dealername", ColumnInfo.TYPE_STRING)
			};
		
		setColumns(myColumns);
	}


}
