package org.casadocodigo.loja.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.casadocodigo.loja.modelos.Livro;

import br.com.casadocodigo.loja.dao.LivroDAO;

@Named
@RequestScoped
public class AdminLivrosBean {

	private Livro livro = new Livro();

	@Inject
	private LivroDAO livroDAO;

	@Transactional
	public void salvar() {
		livroDAO.salvar(livro);
		System.out.println("Livro salvo com sucesso! Livro salvo: " + livro);
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
