package com.moma.dbo;

public class SapDBDO {
	private int pkey; 
	private String sapordernumber; 
	private String saptransdate; 
	private String creditstatus; 
	private String materialgroup; 
	private String materialdescription; 
	private String currency; 
	private double itemnetvalue; 
	private int orderqty; 
	
	public SapDBDO() {
		
	}
	
	public int getPkey() {
		return pkey;
	}
	public void setPkey(int pkey) {
		this.pkey = pkey;
	}
	public String getSapordernumber() {
		return sapordernumber;
	}
	public void setSapordernumber(String sapordernumber) {
		this.sapordernumber = sapordernumber;
	}
	public String getSaptransdate() {
		return saptransdate;
	}
	public void setSaptransdate(String saptransdate) {
		this.saptransdate = saptransdate;
	}
	public String getCreditstatus() {
		return creditstatus;
	}
	public void setCreditstatus(String creditstatus) {
		this.creditstatus = creditstatus;
	}
	public String getMaterialgroup() {
		return materialgroup;
	}
	public void setMaterialgroup(String materialgroup) {
		this.materialgroup = materialgroup;
	}
	public String getMaterialdescription() {
		return materialdescription;
	}
	public void setMaterialdescription(String materialdescription) {
		this.materialdescription = materialdescription;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getItemnetvalue() {
		return itemnetvalue;
	}
	public void setItemnetvalue(double itemnetvalue) {
		this.itemnetvalue = itemnetvalue;
	}
	public int getOrderqty() {
		return orderqty;
	}
	public void setOrderqty(int orderqty) {
		this.orderqty = orderqty;
	}
	public String getEndusername() {
		return endusername;
	}
	public void setEndusername(String endusername) {
		this.endusername = endusername;
	}
	public String getDealername() {
		return dealername;
	}
	public void setDealername(String dealername) {
		this.dealername = dealername;
	}
	public int getUfh_key() {
		return ufh_key;
	}
	public void setUfh_key(int ufh_key) {
		this.ufh_key = ufh_key;
	}
	private String endusername; 
	private String dealername; 
	private int ufh_key;
}
