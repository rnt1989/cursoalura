package org.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.casadocodigo.loja.modelos.Livro;

import br.com.casadocodigo.loja.dao.LivroDAO;

@Model
public class adminListaLivrosBean {
	
	@Inject
	private LivroDAO dao;
	
	private List<Livro> livros = new ArrayList<>();

	public List<Livro> getLivros() {
		this.livros = dao.listar();
		return livros;
	}
	
	

}
