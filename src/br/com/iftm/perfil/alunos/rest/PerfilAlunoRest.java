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

import br.com.iftm.perfil.alunos.dao.PerfilAlunoDao;
import br.com.iftm.perfil.alunos.domain.PerfilAluno;

@Path(value="/perfilAluno")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class PerfilAlunoRest {

	@Inject
	private PerfilAlunoDao perfilAlunoDao;
	
	@GET
	@Path("/{codigo}")
	public PerfilAluno getPerfilAlunoById(@PathParam(value="codigo") Integer id) {
		return perfilAlunoDao.getPerfilAlunoById(id);
	}
	
	@GET
	public List<PerfilAluno> getPerfilAlunos() {
		return perfilAlunoDao.getPerfilAlunosAll();
	}
	
	@DELETE
	@Path("/deletar/{codigo}")
	public void deletePerfilAluno(@PathParam(value="codigo") Integer id) {
		perfilAlunoDao.deletePerfilAluno(id);
	}
	
	@POST
	public void insertPerfilAluno(PerfilAluno perfilAluno) {
		perfilAlunoDao.insertPerfilAluno(perfilAluno);
	}
	
	@PUT
	public void updatePerfilAluno(PerfilAluno perfilAluno) {
		perfilAlunoDao.updatePerfilAluno(perfilAluno);
	}
	
}
