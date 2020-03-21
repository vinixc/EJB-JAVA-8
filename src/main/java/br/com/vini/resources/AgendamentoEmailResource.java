package br.com.vini.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.vini.business.AgendamentoEmailBusiness;
import br.com.vini.entity.AgendamentoEmail;

@Path("/agendamentoemail")
public class AgendamentoEmailResource {
	
	@Inject
	private AgendamentoEmailBusiness agendamentoEmailBusiness;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarAgendamentosEmail() {
		
		List<AgendamentoEmail> emails = agendamentoEmailBusiness.listarAgendamentosEmail();
		return Response.ok(emails).build();
	}
}
