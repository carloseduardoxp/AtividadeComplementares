package model.dao;

import javax.persistence.EntityManager;

import model.domain.Curso;

public class CursoDao {
	
	private EntityManager entityManager;
	
	public CursoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void salvar(Curso curso) {
		entityManager.persist(curso);
	}

}
