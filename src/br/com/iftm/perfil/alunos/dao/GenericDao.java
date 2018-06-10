package br.com.iftm.perfil.alunos.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDao {

	@PersistenceContext(name="PerfilAlunosPU")
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
}
