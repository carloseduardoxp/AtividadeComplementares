package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import model.domain.Curso;

public class CursoDaoTest {
	
	@Test
	public void criarCurso() {
		Curso curso = new Curso();
		curso.setNome("Tecnologia em Sistemas para Internet");
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("AtividadePU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CursoDao cursoDao = new CursoDao(em);
		cursoDao.salvar(curso);
		em.getTransaction().commit();
	}

}
