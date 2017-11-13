package model.domain;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class LancamentoAtividade {
	
	private Aluno aluno;
	
	private Atividade atividade;
	
	private Integer quantidadeHoras;
	
	private Date dataInicio;
	
	private Date dataFim;
	
	public String getSemestreAtividade() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataFim);
		int semestre = 1;
		//mes come�a de 0, logo o mes 5 � junho
		if (calendar.get(Calendar.MONTH) > 5) {
			semestre = 2;
		}
		return calendar.get(Calendar.YEAR)+"-"+semestre;
	}
		
	
	public Integer horasAproveitadas( ) {
		Integer percentualAtividade = atividade.getPercentualCargaHoraria();
		Integer percentualSemestre = atividade.getPercentualPorAtividade();
		//60 horas complementares
		Integer totalHorasPPc = aluno.getPpc().getQuantidadeHorasComplementares();
		// 24 horas para curso e minicurso
		Double totalAtividade = totalHorasPPc.doubleValue() * (new Double(percentualAtividade) / 100d);
		// 12 horas para a atividade de curso e minicurso
		Double totalSemestre = totalAtividade.doubleValue() * (new Double(percentualSemestre) / 100d);
		if (this.quantidadeHoras > totalSemestre) {
			return totalSemestre.intValue();
		}
		return this.quantidadeHoras;		
	}

	
	
	
	public Aluno getAluno() {
		return aluno;
	}



	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}



	public Atividade getAtividade() {
		return atividade;
	}



	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}



	public Integer getQuantidadeHoras() {
		return quantidadeHoras;
	}



	public void setQuantidadeHoras(Integer quantidadeHoras) {
		this.quantidadeHoras = quantidadeHoras;
	}



	public Date getDataInicio() {
		return dataInicio;
	}



	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}



	public Date getDataFim() {
		return dataFim;
	}



	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}

class LancamentoAtividadeComparator implements Comparator<LancamentoAtividade> {

	@Override
	public int compare(LancamentoAtividade o1, LancamentoAtividade o2) {
		if (o1.getSemestreAtividade().equals(o2.getSemestreAtividade())) {
			return o2.getQuantidadeHoras().compareTo(o1.getQuantidadeHoras());	
		}
		return o1.getSemestreAtividade().compareTo(o2.getSemestreAtividade());		
	}
	
}







