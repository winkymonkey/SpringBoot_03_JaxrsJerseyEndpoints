package org.example.spring.boot.models;


public class CustomError {
	
	private String message;
	private String moreDetails;
	
	public CustomError(String message, String moreDetails) {
		this.message = message;
		this.moreDetails = moreDetails;
	}
	
	public String getMessage() {
		return message;
	}
	public String getMoreDetails() {
		return moreDetails;
	}
	
}
