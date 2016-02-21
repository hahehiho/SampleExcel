package com.moma.dbo;

public class ProductMapDO {
	private int pkey; 
	private String name; 
	private String division; 
	private String suite; 
	private String matrialdesc;
	
	public int getPkey() {
		return pkey;
	}
	public void setPkey(int pkey) {
		this.pkey = pkey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getMatrialdesc() {
		return matrialdesc;
	}
	public void setMatrialdesc(String matrialdesc) {
		this.matrialdesc = matrialdesc;
	}
}
