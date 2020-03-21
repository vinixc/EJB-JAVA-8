package br.com.vini.timer;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import br.com.vini.business.AgendamentoEmailBusiness;
import br.com.vini.entity.AgendamentoEmail;

@Singleton
public class AgendamentoEmailTimer {
	
	private static Logger logger = Logger.getLogger(AgendamentoEmailTimer.class.getName());
	
	@Inject
	private AgendamentoEmailBusiness agendamentoEmailBusiness;
	
	@Schedule(hour = "*", minute = "*")
	public void enviarEmailsAgendados() {
		logger.info("INICIANDO ENVIO DOS EMAILS!");
		List<AgendamentoEmail> emails = agendamentoEmailBusiness.listarAgendamentoEmailNaoEnviados();
		
		emails.stream().forEach(agendamento -> {
		System.out.println(String.format("ENVIANDO EMAIL PARA: [%s]", agendamento.getEmail()));
		agendamentoEmailBusiness.enviarEmail(agendamento);
		
		});
		logger.info("FIM DO ENVIO DE EMAILS!");
	}

}
