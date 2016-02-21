package com.moma.dbo;

public class FinalBillingRow {
	private String week;
	private String quarter;
	private String month;
	private String companyName;
	private String city;
	private String product;
	private String division;
	private String suite;
	private String licenseType;
	private String deployment;
	private int		quantity;
	private long productTotal;
	private String sub;
	private long subTotal;
	private long legalization;
	private String program;
	private String leadSource;
	private String partner;
	private String leadSourceName;
	private String fullfillmentChannel;
	private String serialNumber;
	private String po;
	private String programAPAC;
	private long totalBilling;
	
	
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public String getLicenseType() {
		return licenseType;
	}
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
	public String getDeployment() {
		return deployment;
	}
	public void setDeployment(String deployment) {
		this.deployment = deployment;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getProductTotal() {
		return productTotal;
	}
	public void setProductTotal(long productTotal) {
		this.productTotal = productTotal;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public long getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(long subTotal) {
		this.subTotal = subTotal;
	}
	public long getLegalization() {
		return legalization;
	}
	public void setLegalization(long legalization) {
		this.legalization = legalization;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getLeadSource() {
		return leadSource;
	}
	public void setLeadSource(String leadSource) {
		this.leadSource = leadSource;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getLeadSourceName() {
		return leadSourceName;
	}
	public void setLeadSourceName(String leadSourceName) {
		this.leadSourceName = leadSourceName;
	}
	public String getFullfillmentChannel() {
		return fullfillmentChannel;
	}
	public void setFullfillmentChannel(String fullfillmentChannel) {
		this.fullfillmentChannel = fullfillmentChannel;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getPo() {
		return po;
	}
	public void setPo(String po) {
		this.po = po;
	}
	public String getProgramAPAC() {
		return programAPAC;
	}
	public void setProgramAPAC(String programAPAC) {
		this.programAPAC = programAPAC;
	}
	public long getTotalBilling() {
		return totalBilling;
	}
	public void setTotalBilling(long totalBilling) {
		this.totalBilling = totalBilling;
	}
	public void copy(FinalBillingRow prevFirstRow) {
		/* except quantity, product total, subtotal, lega..., total billing */
		week = prevFirstRow.getWeek();
		quarter = prevFirstRow.getQuarter();
		month = prevFirstRow.getMonth();
		companyName = prevFirstRow.getCompanyName();
		city = prevFirstRow.getCity();
		product = prevFirstRow.getProduct();
		division = prevFirstRow.getDivision();
		suite = prevFirstRow.getSuite();
		licenseType = prevFirstRow.getLicenseType();
		deployment = prevFirstRow.getDeployment();
		quantity = prevFirstRow.getQuantity();
		sub = prevFirstRow.getSub();
		program = prevFirstRow.getProgram();
		leadSource = prevFirstRow.getLeadSource();
		partner = prevFirstRow.getPartner();
		leadSourceName = prevFirstRow.getLeadSource();
		fullfillmentChannel = prevFirstRow.getFullfillmentChannel();
		po = prevFirstRow.getPo();
		programAPAC = prevFirstRow.getProgramAPAC();
		
		quantity = 0;
		productTotal = 0;
		subTotal = 0;
		legalization = 0;
		totalBilling = 0;
	}

	public String toString() {
		String result = week;

		result += ", " + quarter;
		result += ", " + month;
		result += ", " + companyName;
		result += ", " + city;
		result += ", " + product;
		result += ", " + division;
		result += ", " + suite;
		result += ", " + licenseType;
		result += ", " + deployment;
		result += ", " + quantity;
		result += ", " + productTotal;
		result += ", " + sub;
		result += ", " + subTotal;
		result += ", " + legalization;
		result += ", " + program;
		result += ", " + leadSource;
		result += ", " + partner;
		result += ", " + leadSourceName;
		result += ", " + fullfillmentChannel;
		result += ", " + serialNumber;
		result += ", " + po;
		result += ", " + programAPAC;
		result += ", " + totalBilling;
		
		return result;
	}
}
