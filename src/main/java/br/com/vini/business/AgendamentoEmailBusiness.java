package br.com.vini.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless //class gerenciado pelo conteiner do java EE.
public class AgendamentoEmailBusiness {

	public List<String> listarAgendamentosEmail(){
		
		List<String> emails = new ArrayList<>();
		emails.add("email1@test.com");
		emails.add("email2@test.com");
		
		return emails;
	}
	
	
}
