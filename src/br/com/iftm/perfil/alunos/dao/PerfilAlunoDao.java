package br.com.iftm.perfil.alunos.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.iftm.perfil.alunos.domain.PerfilAluno;

public class PerfilAlunoDao extends GenericDao {
	
	public PerfilAluno getPerfilAlunoById(int codigo) {
		return getEntityManager().find(PerfilAluno.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public List<PerfilAluno> getPerfilAlunosAll() {
		Query query = getEntityManager().createQuery("from PerfilAluno a");
		return query.getResultList();
	}
	
	@Transactional
	public void insertPerfilAluno(PerfilAluno perfilAluno) {
		getEntityManager().persist(perfilAluno);
	}
	
	@Transactional
	public void updatePerfilAluno(PerfilAluno perfilAluno) {
		perfilAluno = getEntityManager().merge(perfilAluno);
		getEntityManager().persist(perfilAluno);
	}
	
	@Transactional
	public void deletePerfilAluno(int codigo) {
		PerfilAluno perfilAluno = getPerfilAlunoById(codigo);
		getEntityManager().remove(perfilAluno);
	}
	
}
