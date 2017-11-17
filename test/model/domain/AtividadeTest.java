package model.domain;

import java.util.Arrays;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

import org.junit.Assert;

public class AtividadeTest {
	
	@Test
	public void testaAtividadesExcedentes() {
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
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR,2017);
		c.set(Calendar.MONTH,5);
		c.set(Calendar.DAY_OF_MONTH,15);
		lancamento.setDataFim(c.getTime());
		
		LancamentoAtividade lancamento1 = new LancamentoAtividade();
		lancamento1.setAluno(aluno);
		lancamento1.setAtividade(atividade);
		lancamento1.setQuantidadeHoras(400);
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR,2017);
		c1.set(Calendar.MONTH,1);
		c1.set(Calendar.DAY_OF_MONTH,10);
		lancamento1.setDataFim(c1.getTime());
		
		LancamentoAtividade lancamento2 = new LancamentoAtividade();
		lancamento2.setAluno(aluno);
		lancamento2.setAtividade(atividade);
		lancamento2.setQuantidadeHoras(4);
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR,2017);
		c2.set(Calendar.MONTH,3);
		c2.set(Calendar.DAY_OF_MONTH,1);
		lancamento2.setDataFim(c2.getTime());
		
		atividade.setLancamentoAtividades(Arrays.asList(lancamento,lancamento1,lancamento2));
		
		Assert.assertEquals(atividade.getQuantidadeHoras(aluno),20);
	}
	
	@Test
	public void testaAtividadesLimite() {
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
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR,2017);
		c.set(Calendar.MONTH,5);
		c.set(Calendar.DAY_OF_MONTH,15);
		lancamento.setDataFim(c.getTime());
		
		LancamentoAtividade lancamento1 = new LancamentoAtividade();
		lancamento1.setAluno(aluno);
		lancamento1.setAtividade(atividade);
		lancamento1.setQuantidadeHoras(400);
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR,2017);
		c1.set(Calendar.MONTH,8);
		c1.set(Calendar.DAY_OF_MONTH,10);
		lancamento1.setDataFim(c1.getTime());
		
		LancamentoAtividade lancamento2 = new LancamentoAtividade();
		lancamento2.setAluno(aluno);
		lancamento2.setAtividade(atividade);
		lancamento2.setQuantidadeHoras(6);
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR,2017);
		c2.set(Calendar.MONTH,3);
		c2.set(Calendar.DAY_OF_MONTH,1);
		lancamento2.setDataFim(c2.getTime());
		
		atividade.setLancamentoAtividades(Arrays.asList(lancamento,lancamento1,lancamento2));
		
		Assert.assertEquals(atividade.getQuantidadeHoras(aluno),24);
	}


}
