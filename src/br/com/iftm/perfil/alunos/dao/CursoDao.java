package br.com.iftm.perfil.alunos.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.iftm.perfil.alunos.domain.Curso;

public class CursoDao extends GenericDao {
	
	@SuppressWarnings("unchecked")
	public List<Curso> getCursosAll() {
		Query query = getEntityManager().createQuery("from Curso a");
		return query.getResultList();
	}
	
}
