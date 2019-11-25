package com.dj.optional;

public class NoUserException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
	}
	@Override
	public String getMessage() {
		return "没有该用户";
	}
	public NoUserException(String message) {
		super(message);
	}
}
