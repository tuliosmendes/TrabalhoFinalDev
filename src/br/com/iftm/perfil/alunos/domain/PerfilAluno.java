package br.com.iftm.perfil.alunos.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.iftm.perfil.alunos.enumerador.ObjetivoCurso;

@Entity
@Table(name="TB_PERFIL_ALUNO")
@XmlRootElement
public class PerfilAluno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8516325603958935006L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO")
	private int codigo;
	
	@Column(name="TRABALHA_NA_AREA",nullable=false)
	private boolean trabalhaNaArea;
	
	@ManyToOne
	private Area area;
	
	@ManyToOne
	private Aluno aluno;
	
	@Enumerated(EnumType.STRING)
	@Column(name="OBJETIVO_CURSO")
	private ObjetivoCurso objetivoCurso;

	public PerfilAluno() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean isTrabalhaNaArea() {
		return trabalhaNaArea;
	}

	public void setTrabalhaNaArea(boolean trabalhaNaArea) {
		this.trabalhaNaArea = trabalhaNaArea;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public ObjetivoCurso getObjetivoCurso() {
		return objetivoCurso;
	}

	public void setObjetivoCurso(ObjetivoCurso objetivoCurso) {
		this.objetivoCurso = objetivoCurso;
	}

}
