package br.com.iftm.perfil.alunos.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="TB_CURSO")
@XmlRootElement
public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8516325603958935006L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO_CURSO")
	private int codigo;
	
	@Column(name="NOME_CURSO",length=255,nullable=false)
	private String nome;

	public Curso() {
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
	
}
