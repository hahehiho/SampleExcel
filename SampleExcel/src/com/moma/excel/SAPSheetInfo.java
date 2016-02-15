package com.moma.excel;

public class SAPSheetInfo extends SheetInfo {
	public SAPSheetInfo() {
		super("FY14 to FY16Q4 SAP orders", "sapdb");		
		updateQuery = new String[]{
		};
	}

	@Override
	public void initColumns() {
		ColumnInfo[] myColumns = new ColumnInfo[] {
				new ColumnInfo("A", "sapordernumber", ColumnInfo.TYPE_STRING),
				new ColumnInfo("B", "saptransdate", ColumnInfo.TYPE_DATE),
				new ColumnInfo("C", "creditstatus", ColumnInfo.TYPE_STRING),
				new ColumnInfo("D", "materialgroup", ColumnInfo.TYPE_STRING),
				new ColumnInfo("E", "materialdescription", ColumnInfo.TYPE_STRING),
				new ColumnInfo("F", "currency", ColumnInfo.TYPE_STRING),
				new ColumnInfo("G", "itemnetvalue", ColumnInfo.TYPE_NUMBER),
				new ColumnInfo("H", "orderqty", ColumnInfo.TYPE_NUMBER),
				new ColumnInfo("I", "", ColumnInfo.TYPE_SKIP),
				new ColumnInfo("J", "", ColumnInfo.TYPE_SKIP),
				new ColumnInfo("K", "", ColumnInfo.TYPE_SKIP),
				new ColumnInfo("L", "", ColumnInfo.TYPE_SKIP),
				new ColumnInfo("M", "", ColumnInfo.TYPE_SKIP),
				new ColumnInfo("N", "endusername", ColumnInfo.TYPE_STRING),
				new ColumnInfo("O", "dealername", ColumnInfo.TYPE_STRING)
			};
		
		setColumns(myColumns);
	}


}
