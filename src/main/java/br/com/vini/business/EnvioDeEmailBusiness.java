package br.com.vini.business;

import java.util.Optional;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import br.com.vini.entity.AgendamentoEmail;
import br.com.vini.interception.Logger;

@Stateless
@Logger
public class EnvioDeEmailBusiness {
	
	@Resource(lookup = "java:jboss/mail/AgendamentoMailSession")
	private Session sessaoEmail;
	
	private static String EMAIL_FROM = "mail.address";
	private static String EMAIL_USER = "mail.smtp.user";
	private static String EMAIL_PASSWORD = "mail.smtp.pass";
	
	public void enviarEmail(AgendamentoEmail agendamentoEmail) {
		try {
		MimeMessage mensagem = new MimeMessage(sessaoEmail);
		mensagem.setFrom(sessaoEmail.getProperty(EMAIL_FROM));
		mensagem.setRecipients(Message.RecipientType.TO, agendamentoEmail.getEmail());
		mensagem.setSubject(agendamentoEmail.getAssunto());
		
		mensagem.setText(Optional.ofNullable(agendamentoEmail.getMensagem()).orElse(""));
		
		Transport.send(mensagem,
				sessaoEmail.getProperty(EMAIL_USER),
				sessaoEmail.getProperty(EMAIL_PASSWORD));
		
		}catch(MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
