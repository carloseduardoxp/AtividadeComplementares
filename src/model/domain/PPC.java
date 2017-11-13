package model.domain;

public class PPC {
	
	private Integer versao;
	
	private Integer quantidadeHorasComplementares;
	
	private Curso curso;

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
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
