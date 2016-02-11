package com.moma.excel;

public class EnforcementSheetInfo extends SheetInfo {
	public EnforcementSheetInfo() {
		super("Enforcement", "enforcement");		
		updateQuery = new String[]{
		};
	}

	@Override
	public void initColumns() {
		ColumnInfo[] myColumns = new ColumnInfo[] {
				new ColumnInfo("A", "quarter", ColumnInfo.TYPE_STRING),
				new ColumnInfo("B", "requesteddate", ColumnInfo.TYPE_DATE),
				new ColumnInfo("C", "fileddate", ColumnInfo.TYPE_DATE),
				new ColumnInfo("D", "enforcementdate", ColumnInfo.TYPE_DATE),
				new ColumnInfo("E", "agreementdate", ColumnInfo.TYPE_DATE),
				new ColumnInfo("F", "companyname", ColumnInfo.TYPE_STRING),
				new ColumnInfo("G", "companyname_en", ColumnInfo.TYPE_STRING),
				new ColumnInfo("H", "city", ColumnInfo.TYPE_STRING),
				new ColumnInfo("I", "address", ColumnInfo.TYPE_STRING),
				new ColumnInfo("J", "partner", ColumnInfo.TYPE_STRING),
				new ColumnInfo("K", "leadsourcename", ColumnInfo.TYPE_STRING),
				new ColumnInfo("L", "fullfillmentchannel", ColumnInfo.TYPE_STRING),
				new ColumnInfo("M", "enforcementstatus", ColumnInfo.TYPE_STRING),
				new ColumnInfo("N", "violated", ColumnInfo.TYPE_STRING),
				new ColumnInfo("O", "delayreason", ColumnInfo.TYPE_STRING),
				new ColumnInfo("P", "futurelawsuit", ColumnInfo.TYPE_STRING)
			};
		
		setColumns(myColumns);
	}


}
