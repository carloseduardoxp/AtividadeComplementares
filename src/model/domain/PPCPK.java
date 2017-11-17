package model.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class PPCPK {
	
	@Id
	@Column(name="CD_CURSO",nullable=false)
	private Integer codigoCurso;
	
	@Id
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
