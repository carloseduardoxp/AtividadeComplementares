package model.domain;

import org.junit.jupiter.api.Test;
import org.junit.Assert;

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

}
