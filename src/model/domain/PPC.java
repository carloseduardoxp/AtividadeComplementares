package model.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_PPC")
public class PPC {
	
	@EmbeddedId
	private PPCPK ppcPk;
	
	@Column(name="QT_HORAS",nullable=false)
	private Integer quantidadeHorasComplementares;
	
	@ManyToOne
	@JoinColumn(name="CD_CURSO",referencedColumnName="CD_CURSO",
	insertable=false,updatable=false)
	private Curso curso;

	public PPCPK getPpcPk() {
		return ppcPk;
	}

	public void setPpcPk(PPCPK ppcPk) {
		this.ppcPk = ppcPk;
	}

	public Integer getQuantidadeHorasComplementares() {
		return quantidadeHorasComplementares;
	}

	public void setQuantidadeHorasComplementares(Integer quantidadeHorasComplementares) {
		this.quantidadeHorasComplementares = quantidadeHorasComplementares;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}	
	

}
