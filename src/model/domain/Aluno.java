package model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_ALUNO")
public class Aluno implements Serializable{
	
	@Id
	@Column(name="DS_RA",nullable=false)
	private String ra;
	
	@Column(name="DS_NOME",nullable=false)
	private String nome;
	
	@ManyToOne
	@JoinColumns({
	@JoinColumn(name="CD_CURSO",referencedColumnName="CD_CURSO"),
	@JoinColumn(name="NR_VERSAO",referencedColumnName="NR_VERSAO")}
	)
	private PPC ppc;

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PPC getPpc() {
		return ppc;
	}

	public void setPpc(PPC ppc) {
		this.ppc = ppc;
	}

}
