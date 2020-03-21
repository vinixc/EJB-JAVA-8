package br.com.vini.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.MessageListener;

import br.com.vini.business.AgendamentoEmailBusiness;
import br.com.vini.entity.AgendamentoEmail;
import br.com.vini.interception.Logger;

@Logger
@MessageDriven(activationConfig = {
	    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/EmailQueue"),
        @ActivationConfigProperty(propertyName = "destinationType",   propertyValue = "javax.jms.Queue")
})
public class EmailMDB implements MessageListener {
    
	@Inject
    private AgendamentoEmailBusiness agendamentoEmailBusiness;
   
    
    @Override
    public void onMessage(javax.jms.Message message) {
    	try {
    	
			AgendamentoEmail agendamentoEmail = message.getBody(AgendamentoEmail.class);
			agendamentoEmailBusiness.enviarEmail(agendamentoEmail);
    	
    	} catch (JMSException e) {
			throw new RuntimeException(e);
		}
    }
}
