package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.casadocodigo.loja.modelos.Autor;

public class AutorDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<Autor> listar() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}
}
