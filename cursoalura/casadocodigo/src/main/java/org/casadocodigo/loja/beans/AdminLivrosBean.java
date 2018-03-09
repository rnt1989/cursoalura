package org.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.casadocodigo.loja.modelos.Autor;
import org.casadocodigo.loja.modelos.Livro;

import br.com.casadocodigo.loja.dao.AutorDAO;
import br.com.casadocodigo.loja.dao.LivroDAO;

@Named
@RequestScoped
public class AdminLivrosBean {

	private Livro livro = new Livro();
	private List<Integer> autoresId = new ArrayList<>();

	@Inject
	private LivroDAO livroDAO;

	@Inject
	private AutorDAO autorDAO;

	@Transactional
	public void salvar() {
		for (Integer autorId : autoresId) {
			livro.getAutores().add(new Autor(autorId));
		}
		livroDAO.salvar(livro);
		System.out.println("Livro salvo com sucesso! Livro salvo: " + livro);
		this.livro = new Livro();
		this.autoresId = new ArrayList<>();
	}

	public List<Autor> getAutores() {
		return autorDAO.listar();
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Integer> getAutoresId() {
		return autoresId;
	}

	public void setAutoresId(List<Integer> autoresId) {
		this.autoresId = autoresId;
	}
}
