package br.com.vini.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.vini.entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<AgendamentoEmail> listarAgendamentoEmail(){
		return entityManager
				.createQuery("select a from AgendamentoEmail", AgendamentoEmail.class)
				.getResultList();
	}
}
