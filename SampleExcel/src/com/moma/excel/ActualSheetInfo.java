package com.moma.excel;

public class ActualSheetInfo extends SheetInfo {
	public ActualSheetInfo() {
		super("Actual", "actual");		
		updateQuery = new String[]{
			"update actual set periodgap = datediff(podate, sentdate);",
			"update actual set totalbilling = (producttotal + subscriptiontotal);"
		};
	}

	@Override
	public void initColumns() {
		ColumnInfo[] myColumns = new ColumnInfo[] {
				new ColumnInfo("A", "week", ColumnInfo.TYPE_STRING),
				new ColumnInfo("B", "quarter", ColumnInfo.TYPE_STRING),
				new ColumnInfo("C", "month", ColumnInfo.TYPE_STRING),
				new ColumnInfo("D", "companyname", ColumnInfo.TYPE_STRING),
				new ColumnInfo("E", "city", ColumnInfo.TYPE_STRING),
				new ColumnInfo("F", "product", ColumnInfo.TYPE_STRING),
				new ColumnInfo("G", "division", ColumnInfo.TYPE_STRING),
				new ColumnInfo("H", "suite", ColumnInfo.TYPE_STRING),
				new ColumnInfo("I", "licensetype", ColumnInfo.TYPE_STRING),
				new ColumnInfo("J", "deploymenttype", ColumnInfo.TYPE_STRING),
				new ColumnInfo("K", "quantity", ColumnInfo.TYPE_NUMBER),
				new ColumnInfo("L", "producttotal", ColumnInfo.TYPE_NUMBER),
				new ColumnInfo("M", "subscription", ColumnInfo.TYPE_STRING),
				new ColumnInfo("N", "subscriptiontotal", ColumnInfo.TYPE_NUMBER),
				new ColumnInfo("O", "totalbilling", ColumnInfo.TYPE_NUMBER),
				new ColumnInfo("P", "program", ColumnInfo.TYPE_STRING),
				new ColumnInfo("Q", "leadsource", ColumnInfo.TYPE_STRING),
				new ColumnInfo("R", "partner", ColumnInfo.TYPE_STRING),
				new ColumnInfo("S", "leadsourcename", ColumnInfo.TYPE_STRING),
				new ColumnInfo("T", "fullfillmentchannel", ColumnInfo.TYPE_STRING),
				new ColumnInfo("U", "sn", ColumnInfo.TYPE_STRING),
				new ColumnInfo("V", "po", ColumnInfo.TYPE_STRING),
				new ColumnInfo("W", "podate", ColumnInfo.TYPE_DATE),
				new ColumnInfo("X", "podate2", ColumnInfo.TYPE_SKIP),
				new ColumnInfo("Y", "sentdate", ColumnInfo.TYPE_DATE),
				new ColumnInfo("Z", "periodgap", ColumnInfo.TYPE_NUMBER)
			};
		
		setColumns(myColumns);
	}


}
