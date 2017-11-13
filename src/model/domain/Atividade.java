package model.domain;

import java.util.Collections;
import java.util.List;

public class Atividade {
	
	private Integer codigo;
	
	private String nome;
	
	private Integer percentualCargaHoraria;
	
	private Integer maximoAtividadesSemestre;
	
	private Integer percentualPorAtividade;
	
	private List<LancamentoAtividade> lancamentoAtividades;
	
	public Double getQuantidadeHoras() {		
		Collections.sort(lancamentoAtividades,new LancamentoAtividadeComparator());
		
	}

	public Integer getCodigo() {
		return codigo;
	}

	public List<LancamentoAtividade> getLancamentoAtividades() {
		return lancamentoAtividades;
	}

	public void setLancamentoAtividades(List<LancamentoAtividade> lancamentoAtividades) {
		this.lancamentoAtividades = lancamentoAtividades;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPercentualCargaHoraria() {
		return percentualCargaHoraria;
	}

	public void setPercentualCargaHoraria(Integer percentualCargaHoraria) {
		this.percentualCargaHoraria = percentualCargaHoraria;
	}

	public Integer getMaximoAtividadesSemestre() {
		return maximoAtividadesSemestre;
	}

	public void setMaximoAtividadesSemestre(Integer maximoAtividadesSemestre) {
		this.maximoAtividadesSemestre = maximoAtividadesSemestre;
	}

	public Integer getPercentualPorAtividade() {
		return percentualPorAtividade;
	}

	public void setPercentualPorAtividade(Integer percentualPorAtividade) {
		this.percentualPorAtividade = percentualPorAtividade;
	}
	
	
	
	

}
