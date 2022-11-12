package com.masai.model;

public class Complain {
	
   private int complainID;
   private String complainName;
   private String category;
   
   public Complain() {
			super();
			// TODO Auto-generated constructor stub
   }
	
	
	public Complain(int complainID, String complainName, String category) {
		super();
		this.complainID = complainID;
		this.complainName = complainName;
		this.category = category;
	}
	
	
	public int getComplainID() {
		return complainID;
	}
	
	
	public void setComplainID(int complainID) {
		this.complainID = complainID;
	}
	
	
	public String getComplainName() {
		return complainName;
	}
	
	
	public void setComplainName(String complainName) {
		this.complainName = complainName;
	}
	
	
	public String getCategory() {
		return category;
	}
	
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	@Override
	public String toString() {
		return "Complain [complainID=" + complainID + ", complainName=" + complainName + ", category=" + category + "]";
		}
   
   
   

}
