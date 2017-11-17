package model.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_ATIVIDADE")
public class Atividade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_ATIVIDADE")
	private Integer codigo;
	
	@Column(name="DS_NOME",nullable=false)
	private String nome;
	
	@Column(name="PR_CARGA_HORARIA",nullable=false)
	private Integer percentualCargaHoraria;
	
	@Column(name="NR_MAX_ATIVIDADE",nullable=false)
	private Integer maximoAtividadesSemestre;
	
	@Column(name="PR_ATIVIDADE",nullable=false)
	private Integer percentualPorAtividade;
	
	@OneToMany(mappedBy="atividade")
	private List<LancamentoAtividade> lancamentoAtividades;
	
	public int getQuantidadeHoras(Aluno aluno) {		
		Collections.sort(lancamentoAtividades,new LancamentoAtividadeComparator());
		descarteAtividadesExcedentes();
		int maxHoras = aluno.getPpc().getQuantidadeHorasComplementares() * 
				percentualCargaHoraria / 100;
		int maxAtividade = maxHoras * percentualPorAtividade / 100;
		//2017-1 tenha 3 atividades 2017-2
		int totalHoras = 0;
		for (LancamentoAtividade lancamento: lancamentoAtividades) {
			int horasAproveitadas = lancamento.horasAproveitadas();
			if (horasAproveitadas + totalHoras > maxHoras) {
				return maxHoras;
			} else {
				totalHoras+= horasAproveitadas;
			}
		}
		
		return totalHoras;
	}

	private void descarteAtividadesExcedentes() {
		List<LancamentoAtividade> atividadesFiltradas = new ArrayList<>();
		String anoMesAtual = lancamentoAtividades.get(0).getSemestreAtividade();
		int totalAtividadesAnoMes = 0;
		for (LancamentoAtividade lancamento: lancamentoAtividades) {
			if (lancamento.getSemestreAtividade().equals(anoMesAtual)) {
				totalAtividadesAnoMes++;
				if (totalAtividadesAnoMes <= maximoAtividadesSemestre) {
					atividadesFiltradas.add(lancamento);
				}
			} else {
				anoMesAtual = lancamento.getSemestreAtividade();
				totalAtividadesAnoMes = 0;
				atividadesFiltradas.add(lancamento);
			}
		}
		this.lancamentoAtividades = atividadesFiltradas;
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
