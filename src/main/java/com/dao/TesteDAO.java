package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.entity.Teste;
import com.interfaces.ITesteDAO;
import com.util.AbastractDAO;

@Repository
@SuppressWarnings("unchecked")
public class TesteDAO extends AbastractDAO<Teste> implements ITesteDAO{

	@PersistenceContext EntityManager entityManager;

	@Override
	public List<Teste> listaTestes(Teste entidade) {
		List<Teste> lista = getEntityManager().createQuery("select p from Teste p ")
					.getResultList();	
			return lista;
	}
	
}
