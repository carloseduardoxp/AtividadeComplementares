package model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PPCPK implements Serializable{
	
	@Column(name="CD_CURSO",nullable=false)
	private Integer codigoCurso;
	
	@Column(name="NR_VERSAO",nullable=false)
	private Integer versao;

	public Integer getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(Integer codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
	}

}
