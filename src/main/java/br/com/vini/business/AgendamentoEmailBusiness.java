package br.com.vini.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.vini.dao.AgendamentoEmailDao;
import br.com.vini.entity.AgendamentoEmail;
import br.com.vini.exception.BusinessException;
import br.com.vini.interception.Logger;

@Stateless
@Logger
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AgendamentoEmailBusiness {
	
	@Inject
	private AgendamentoEmailDao agendamentoEmailDao;
	
	@Inject
	private EnvioDeEmailBusiness envioDeEmailBusiness;
	
	public List<AgendamentoEmail> listarAgemndamentosEmail(){
	
		return agendamentoEmailDao.listarAgendamentosEmail();
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvarAgendamentoEmail( @Valid AgendamentoEmail agendamentoEmail) throws BusinessException {
		
		if(!agendamentoEmailDao.listarAgendamentoEmailPorEmail(agendamentoEmail.getEmail()).isEmpty()) {
			
			throw new BusinessException("Email já está agendado.");
		}
		
		agendamentoEmail.setEnviado(false);
		agendamentoEmailDao.salvarAgendamentoEmail(agendamentoEmail);
		
		throw new RuntimeException();
	}
	
	public List<AgendamentoEmail> listarAgendamentoEmailNaoEnviados(){
		return agendamentoEmailDao.listarAgendamentoEmailNaoEnviados();
	}
	
	public void enviarEmail(AgendamentoEmail agendamentoEmail) {
		envioDeEmailBusiness.enviarEmail(agendamentoEmail);
	}
	
	public void marcarEnviadas(AgendamentoEmail agendamentoEmail) {
		agendamentoEmail.setEnviado(true);
		agendamentoEmailDao.atualizaAgendamentoEmail(agendamentoEmail);
	}

}
