package br.com.iftm.perfil.alunos.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.iftm.perfil.alunos.domain.Aluno;

public class AlunoDao extends GenericDao {
	
	public Aluno getAlunoById(int codigo) {
		return getEntityManager().find(Aluno.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> getAlunosAll() {
		Query query = getEntityManager().createQuery("from Aluno a");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> getAlunosByName(String nome) {
		Query query = getEntityManager().createQuery("from Aluno a where a.nome like '%" + nome + "%'");
		return query.getResultList();
	}
	
	@Transactional
	public void insertAluno(Aluno aluno) {
		getEntityManager().persist(aluno);
	}
	
	@Transactional
	public void updateAluno(Aluno aluno) {
		aluno = getEntityManager().merge(aluno);
		getEntityManager().persist(aluno);
	}
	
	@Transactional
	public void deleteAluno(int codigo) {
		Aluno aluno = getAlunoById(codigo);
		getEntityManager().remove(aluno);
	}
	
}
