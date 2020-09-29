package com.example.spring.boot;


public class CustomError {
	private String message;
	private String moreDetails;
	
	CustomError(String message, String moreDetails) {
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
