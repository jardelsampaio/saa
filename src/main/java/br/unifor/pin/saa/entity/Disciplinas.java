package br.unifor.pin.saa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="disciplinas")
public class Disciplinas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="disciplinas_seq", sequenceName="disciplinas_seq", allocationSize=1)
	@GeneratedValue(generator="disciplinas_seq", strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="instituicao_id")
	private Instituicoes instituicao;
	
	@ManyToOne
	@JoinColumn(name="professor_id")
	private Professores professor;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Instituicoes getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicoes instituicao) {
		this.instituicao = instituicao;
	}

	public Professores getProfessor() {
		return professor;
	}

	public void setProfessor(Professores professor) {
		this.professor = professor;
	}

	

}
