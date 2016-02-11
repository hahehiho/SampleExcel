package com.moma.excel;

public class LeadSheetInfo extends SheetInfo {
	public LeadSheetInfo() {
		super("Lead", "lead");		
		updateQuery = new String[]{
		};
	}

	@Override
	public void initColumns() {
		ColumnInfo[] myColumns = new ColumnInfo[] {
				new ColumnInfo("A", "quarter", ColumnInfo.TYPE_STRING),
				new ColumnInfo("B", "requesteddate", ColumnInfo.TYPE_DATE),
				new ColumnInfo("C", "sentdate", ColumnInfo.TYPE_DATE),
				new ColumnInfo("D", "companyname", ColumnInfo.TYPE_STRING),
				new ColumnInfo("E", "companyname_en", ColumnInfo.TYPE_STRING),
				new ColumnInfo("F", "city", ColumnInfo.TYPE_STRING),
				new ColumnInfo("G", "address", ColumnInfo.TYPE_STRING),
				new ColumnInfo("H", "partner", ColumnInfo.TYPE_STRING),
				new ColumnInfo("I", "leadsourcename", ColumnInfo.TYPE_STRING),
				new ColumnInfo("J", "fullfillmentchannel", ColumnInfo.TYPE_STRING),
				new ColumnInfo("K", "program", ColumnInfo.TYPE_STRING),
				new ColumnInfo("L", "leadstatus", ColumnInfo.TYPE_STRING),
				new ColumnInfo("M", "leadresponse", ColumnInfo.TYPE_STRING),
				new ColumnInfo("N", "leadcomment", ColumnInfo.TYPE_STRING),
				new ColumnInfo("O", "return_yn", ColumnInfo.TYPE_STRING),
				new ColumnInfo("P", "reject", ColumnInfo.TYPE_STRING),
				new ColumnInfo("Q", "futureplan", ColumnInfo.TYPE_STRING),
				new ColumnInfo("R", "lccontact", ColumnInfo.TYPE_STRING),
				new ColumnInfo("S", "contactname", ColumnInfo.TYPE_STRING),
				new ColumnInfo("T", "contactdepartment", ColumnInfo.TYPE_STRING),
				new ColumnInfo("U", "contacttitle", ColumnInfo.TYPE_STRING),
				new ColumnInfo("V", "contactemail", ColumnInfo.TYPE_STRING),
				new ColumnInfo("W", "contactphone", ColumnInfo.TYPE_STRING),
			};
		
		setColumns(myColumns);
	}


}
