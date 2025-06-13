package com.example.demo.constants;

public enum RtnCode {
	
	SUCCESSFUL(200,"successful !"),//
	PARAM_ERROR(400,"param error !" ),//
	ACCOUNT_EXISTED(400,"account existed !"),//
	ACCOUNT_NOT_FOUND(404,"account not found !"),//	
	;
	
	private int code;
	
	private String message;

	private RtnCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	

}
