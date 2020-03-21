package br.com.vini.timer;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

import br.com.vini.business.AgendamentoEmailBusiness;
import br.com.vini.entity.AgendamentoEmail;

@Singleton
public class AgendamentoEmailTimer {
	
	private static Logger logger = Logger.getLogger(AgendamentoEmailTimer.class.getName());
	
	@Inject
	private AgendamentoEmailBusiness agendamentoEmailBusiness;
	
	@Inject
	@JMSConnectionFactory("java:jboss/DefaultJMSConnectionFactory")
	private JMSContext context;
	
	@Resource(mappedName = "java:/jms/queue/EmailQueue")
	private Queue queue;
	
	
	@Schedule(hour = "*", minute = "*")
	public void enviarEmailsAgendados() {
		logger.info("INICIANDO ENVIO DOS EMAILS!");
		List<AgendamentoEmail> emails = agendamentoEmailBusiness.listarAgendamentoEmailNaoEnviados();
		
		emails.stream().forEach(agendamento -> {
		System.out.println(String.format("ENVIANDO EMAIL PARA: [%s]", agendamento.getEmail()));
		context.createProducer().send(queue, agendamento);
		agendamentoEmailBusiness.marcarEnviadas(agendamento);
		
		});
		logger.info("FIM DO ENVIO DE EMAILS!");
	}

}
