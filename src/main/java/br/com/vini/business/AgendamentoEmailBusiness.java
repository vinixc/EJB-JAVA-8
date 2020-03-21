package br.com.vini.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.vini.dao.AgendamentoEmailDao;
import br.com.vini.entity.AgendamentoEmail;

@Stateless //class gerenciado pelo conteiner do java EE.
public class AgendamentoEmailBusiness {

	@Inject
	private AgendamentoEmailDao emailDao;
	
	public List<AgendamentoEmail> listarAgendamentosEmail(){	
		return emailDao.listarAgendamentoEmail();
	}
	
	
}
