package com.sathish.mobileapp.Exception;

import java.util.Date;

public class ExceptionMessage {
	
	
	private Date timeStamp;
	private String message;
	public ExceptionMessage() {
	}
	public ExceptionMessage(Date timeStamp, String message) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
