package com.moma.excel;

public class ClearDBSheetInfo extends SheetInfo {
	public ClearDBSheetInfo() {
		super("CH98_20160201_123112", "cleardb");		
		updateQuery = new String[]{
		};
	}

	@Override
	public void initColumns() {
		ColumnInfo[] myColumns = new ColumnInfo[] {
				new ColumnInfo("Q", "serialnumber", ColumnInfo.TYPE_STRING),
				new ColumnInfo("Y", "sapordernumber", ColumnInfo.TYPE_STRING),
				new ColumnInfo("E", "enduseraccountname", ColumnInfo.TYPE_STRING),
				new ColumnInfo("H", "noofseats", ColumnInfo.TYPE_NUMBER),
				new ColumnInfo("F", "street", ColumnInfo.TYPE_STRING),
				new ColumnInfo("G", "street2", ColumnInfo.TYPE_STRING),
				new ColumnInfo("I", "street3", ColumnInfo.TYPE_STRING),
				new ColumnInfo("J", "city", ColumnInfo.TYPE_STRING),
				new ColumnInfo("K", "postalcode", ColumnInfo.TYPE_STRING),
				new ColumnInfo("O", "productline", ColumnInfo.TYPE_STRING),
				new ColumnInfo("P", "releaseversion", ColumnInfo.TYPE_STRING),
				new ColumnInfo("R", "licensetype", ColumnInfo.TYPE_STRING),
				new ColumnInfo("T", "deploymenttype", ColumnInfo.TYPE_STRING),
				new ColumnInfo("U", "assetstatus", ColumnInfo.TYPE_STRING),
				new ColumnInfo("W", "assetregdate", ColumnInfo.TYPE_DATE),
				new ColumnInfo("X", "saptransdate", ColumnInfo.TYPE_DATE),
				new ColumnInfo("AB", "fullfillmentchannel", ColumnInfo.TYPE_STRING),
				new ColumnInfo("C", "accountuuid", ColumnInfo.TYPE_STRING),
				new ColumnInfo("D", "endusercsn", ColumnInfo.TYPE_STRING),
				new ColumnInfo("A", "corpaccountname", ColumnInfo.TYPE_STRING),
				new ColumnInfo("B", "nameaccountgroup", ColumnInfo.TYPE_STRING),
				new ColumnInfo("M", "productclass", ColumnInfo.TYPE_STRING),
				new ColumnInfo("L", "solutiondivision", ColumnInfo.TYPE_STRING),
				new ColumnInfo("N", "licensebehavior", ColumnInfo.TYPE_STRING),
				new ColumnInfo("S", "licensemodel", ColumnInfo.TYPE_STRING),
				new ColumnInfo("Z", "clear_program", ColumnInfo.TYPE_STRING),
				new ColumnInfo("AA", "clear_programtype", ColumnInfo.TYPE_STRING),
			};
		
		setColumns(myColumns);
	}


}
