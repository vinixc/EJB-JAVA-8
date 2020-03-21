package br.com.vini.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.vini.dao.AgendamentoEmailDao;
import br.com.vini.entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailBusiness {
	
	@Inject
	private AgendamentoEmailDao agendamentoEmailDao;
	
	public List<AgendamentoEmail> listarAgemndamentosEmail(){
	
		return agendamentoEmailDao.listarAgendamentosEmail();
		
	}
	
	public void salvarAgendamentoEmail( @Valid AgendamentoEmail agendamentoEmail) {
		
		agendamentoEmail.setEnviado(false);
		agendamentoEmailDao.salvarAgendamentoEmail(agendamentoEmail);
		
	}

}
