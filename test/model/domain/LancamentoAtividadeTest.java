package model.domain;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class LancamentoAtividadeTest {
	
	@Test
	public void testaAtividadeMaior12Horas() {
		Atividade atividade = new Atividade();
		atividade.setMaximoAtividadesSemestre(2);
		atividade.setPercentualCargaHoraria(40);
		atividade.setPercentualPorAtividade(50);
		PPC ppc = new PPC();
		ppc.setQuantidadeHorasComplementares(60);
		Aluno aluno = new Aluno();
		aluno.setPpc(ppc);
		LancamentoAtividade lancamento = new LancamentoAtividade();
		lancamento.setAluno(aluno);
		lancamento.setAtividade(atividade);
		lancamento.setQuantidadeHoras(100);
		Assert.assertEquals(lancamento.horasAproveitadas(),12,0.0001);
	}
	
	@Test
	public void testaAtividade12Horas() {
		Atividade atividade = new Atividade();
		atividade.setMaximoAtividadesSemestre(2);
		atividade.setPercentualCargaHoraria(40);
		atividade.setPercentualPorAtividade(50);
		PPC ppc = new PPC();
		ppc.setQuantidadeHorasComplementares(60);
		Aluno aluno = new Aluno();
		aluno.setPpc(ppc);
		LancamentoAtividade lancamento = new LancamentoAtividade();
		lancamento.setAluno(aluno);
		lancamento.setAtividade(atividade);
		lancamento.setQuantidadeHoras(12);
		Assert.assertEquals(lancamento.horasAproveitadas(),12,0.0001);
	}
	
	@Test
	public void testaAtividadeMenor12Horas() {
		Atividade atividade = new Atividade();
		atividade.setMaximoAtividadesSemestre(2);
		atividade.setPercentualCargaHoraria(40);
		atividade.setPercentualPorAtividade(50);
		PPC ppc = new PPC();
		ppc.setQuantidadeHorasComplementares(60);
		Aluno aluno = new Aluno();
		aluno.setPpc(ppc);
		LancamentoAtividade lancamento = new LancamentoAtividade();
		lancamento.setAluno(aluno);
		lancamento.setAtividade(atividade);
		lancamento.setQuantidadeHoras(8);
		Assert.assertEquals(lancamento.horasAproveitadas(),8,0.0001);
	}
	
	@Test
	public void testaAnoMesPrimeiroSemestre() {
		LancamentoAtividade lancamento = new LancamentoAtividade();
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2017);
		c.set(Calendar.DAY_OF_MONTH,30);
		c.set(Calendar.MONTH,5);
		
		lancamento.setDataFim(c.getTime());
		
		Assert.assertEquals(lancamento.getSemestreAtividade(),"2017-1");
	}
	
	@Test
	public void testaAnoMesSegundoSemestre() {
		LancamentoAtividade lancamento = new LancamentoAtividade();
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2025);
		c.set(Calendar.DAY_OF_MONTH,01);
		c.set(Calendar.MONTH,6);
		
		lancamento.setDataFim(c.getTime());
		
		Assert.assertEquals(lancamento.getSemestreAtividade(),"2025-2");
	}

}
