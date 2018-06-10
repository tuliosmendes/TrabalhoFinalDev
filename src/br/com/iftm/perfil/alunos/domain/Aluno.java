package br.com.iftm.perfil.alunos.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="TB_ALUNO")
@XmlRootElement
public class Aluno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8516325603958935006L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO_ALUNO")
	private int codigo;
	
	@Column(name="NOME_ALUNO",length=255,nullable=false)
	private String nome;
	
	@Column(name="SEXO", nullable=false)
	private char sexo;
	
	@ManyToOne
	private Curso curso;

	public Aluno() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
}
