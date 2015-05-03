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
@Table(name="questoes")
public class Questoes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="questoes_seq",sequenceName="questoes_seq",allocationSize=1)
    @GeneratedValue(generator="questoes_seq",strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable=false)
	private String enunciado;
	
	@ManyToOne
	@JoinColumn(name="disciplina_id")
	private Disciplinas disciplina;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Disciplinas getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplinas disciplina) {
		this.disciplina = disciplina;
	}

	

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	
}
