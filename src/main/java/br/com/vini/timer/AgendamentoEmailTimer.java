package br.com.vini.timer;

import java.util.logging.Logger;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class AgendamentoEmailTimer {
	
	private static Logger logger = Logger.getLogger(AgendamentoEmailTimer.class.getName());
	
	@Schedule(hour = "*", minute = "*")
	public void enviarEmailsAgendados() {
		
		logger.info("RODOUUU");
	}

}
