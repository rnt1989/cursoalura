package org.casadocodigo.loja.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

	@Inject
	private LivroDAO livroDAO;

	@Inject
	private AutorDAO autorDAO;

	@Inject
	private FacesContext context;

	@Transactional
	public String salvar() {
		livroDAO.salvar(livro);

		// O Message dura por mais de um request
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Livro salvo com sucesso!"));

		return "/livros/lista?faces-redirect=true";
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
}
