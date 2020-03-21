package br.com.vini.dto;

import java.util.Date;
import java.util.List;

public class MensagemErroDto {
	
	private List<String> messagens;
	
	private Date dataErro;

	public List<String> getMessagens() {
		return messagens;
	}

	public void setMessagens(List<String> messagens) {
		this.messagens = messagens;
	}

	public Date getDataErro() {
		return dataErro;
	}

	public void setDataErro(Date dataErro) {
		this.dataErro = dataErro;
	}
	
	public static MensagemErroDto build(List<String> mensagem) {
		MensagemErroDto mensagemErroDTO = new MensagemErroDto();
		mensagemErroDTO.setMessagens(mensagem);
		mensagemErroDTO.setDataErro(new Date());
		
		return mensagemErroDTO;
	}
	

}
