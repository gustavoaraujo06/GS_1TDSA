package br.com.blueplan.beans;

public class Admin extends Usuario{

	public Admin() {
		super();
	}

	public Admin(String nome, String email) {
		super(nome, email);
	}
	
	public Projeto criarProjeto(String nome, String descricao, Endereco localizacao) {
		return new Projeto(nome, descricao, this, localizacao, 0);
	}
}
