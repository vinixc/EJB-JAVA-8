package br.com.vini;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import br.com.vini.dto.MensagemErroDto;
import br.com.vini.exception.BusinessException;

@Provider
public class BusinessExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<BusinessException>{

	@Override
	public Response toResponse(BusinessException e) {

		 return Response
	                .status(Response.Status.BAD_REQUEST)
	                .entity( MensagemErroDto.build(e.getMensagens()))
	                .build();
	}

}
