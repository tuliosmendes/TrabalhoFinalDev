package br.com.iftm.perfil.alunos.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.iftm.perfil.alunos.dao.CursoDao;
import br.com.iftm.perfil.alunos.domain.Curso;

@Path(value="/curso")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class CursoRest {

	@Inject
	private CursoDao cursoDao;
	
	@GET
	public List<Curso> getCursos() {
		return cursoDao.getCursosAll();
	}

}
