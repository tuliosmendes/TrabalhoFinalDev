package br.com.iftm.perfil.alunos.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.iftm.perfil.alunos.domain.Area;

public class AreaDao extends GenericDao {
	
	@SuppressWarnings("unchecked")
	public List<Area> getAreaAll() {
		Query query = getEntityManager().createQuery("from Area a");
		return query.getResultList();
	}
	
}
