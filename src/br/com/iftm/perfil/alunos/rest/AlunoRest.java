package br.com.iftm.perfil.alunos.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.iftm.perfil.alunos.dao.AlunoDao;
import br.com.iftm.perfil.alunos.domain.Aluno;

@Path(value="/aluno")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class AlunoRest {

	@Inject
	private AlunoDao alunoDao;
	
	@GET
	public List<Aluno> getAlunos() {
		return alunoDao.getAlunosAll();
	}
	
	@GET
	@Path("/{codigo}")
	public Aluno getAlunoById(@PathParam(value="codigo") Integer id) {
		return alunoDao.getAlunoById(id);
	}
	
	@GET
	@Path("/getnome/{nome}")
	public List<Aluno> getAlunosByName(@PathParam(value="nome") String nome) {
		return alunoDao.getAlunosByName(nome);
	}
	
	@DELETE
	@Path("/deletar/{codigo}")
	public void deleteAluno(@PathParam(value="codigo") Integer id) {
		alunoDao.deleteAluno(id);
	}
	
	@POST
	public void insertAluno(Aluno aluno) {
		alunoDao.insertAluno(aluno);
	}
	
	@PUT
	public void updateAluno(Aluno aluno) {
		alunoDao.updateAluno(aluno);
	}
	
}
