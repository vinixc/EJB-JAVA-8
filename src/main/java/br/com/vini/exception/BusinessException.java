package br.com.vini.exception;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class BusinessException extends Exception{
	private static final long serialVersionUID = 8483627789357040028L;
	
	private List<String> mensagens;
	
	public BusinessException(String msg) {
		super(msg);
		mensagens = new ArrayList<String>();
		mensagens.add(msg);
	}

	public List<String> getMensagens() {
		return mensagens;
	}

	public void addMensagem(String mensagem) {
		this.mensagens.add(mensagem);
	}
	
}
