package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_ALUNO")
public class Aluno {
	
	@Id
	@Column(name="DS_RA",nullable=false)
	private String ra;
	
	@Column(name="DS_NOME",nullable=false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="CD_PPC",referencedColumnName="CD_PPC")
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
