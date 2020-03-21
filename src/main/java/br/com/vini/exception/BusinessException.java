package br.com.vini.exception;

public class BusinessException extends Exception{
	private static final long serialVersionUID = 8483627789357040028L;
	
	public BusinessException(String msg) {
		super(msg);
	}

}
