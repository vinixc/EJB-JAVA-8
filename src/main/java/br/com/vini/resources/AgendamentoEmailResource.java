package br.com.vini.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.vini.business.AgendamentoEmailBusiness;
import br.com.vini.entity.AgendamentoEmail;
import br.com.vini.exception.BusinessException;

@Path("/agendamentoemail")
public class AgendamentoEmailResource {
		
	@Inject
	private AgendamentoEmailBusiness agendamentoEmailBusiness;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarAgendamentosEmail() {
		
		List<AgendamentoEmail> emails = agendamentoEmailBusiness.listarAgemndamentosEmail();
		return Response.ok(emails).build();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvarAgendamentoEmail(AgendamentoEmail agendamentoEmail ) throws BusinessException {
		
		agendamentoEmailBusiness.salvarAgendamentoEmail(agendamentoEmail);
		
		return Response
				.status(Status.CREATED.getStatusCode())
				.build();
	}
}
