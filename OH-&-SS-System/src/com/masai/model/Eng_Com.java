package com.masai.model;

public class Eng_Com {
	
	private int engId;
	private String name;
	private String category;
	private int EcomplainId;
	private String ComplainStatus;
	
	
	public Eng_Com() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Eng_Com(int engId, String name, String category, int ecomplainId, String complainStatus) {
		super();
		this.engId = engId;
		this.name = name;
		this.category = category;
		EcomplainId = ecomplainId;
		ComplainStatus = complainStatus;
	}


	public int getEngId() {
		return engId;
	}


	public void setEngId(int engId) {
		this.engId = engId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getEcomplainId() {
		return EcomplainId;
	}


	public void setEcomplainId(int ecomplainId) {
		EcomplainId = ecomplainId;
	}


	public String getComplainStatus() {
		return ComplainStatus;
	}


	public void setComplainStatus(String complainStatus) {
		ComplainStatus = complainStatus;
	}


	@Override
	public String toString() {
		return "Engineer_Complain [engId=" + engId + ", name=" + name + ", category=" + category + ", EcomplainId="
				+ EcomplainId + ", ComplainStatus=" + ComplainStatus + "]";
	}
	
	
	

}
