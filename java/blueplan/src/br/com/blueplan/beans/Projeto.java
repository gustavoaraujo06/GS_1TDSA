package br.com.blueplan.beans;

import java.util.ArrayList;

public class Projeto {
	private String nome;
	private String descricao;
	private Usuario criador;
	private Endereco localizacao;
	private int status;
	private ArrayList<Equipe> equipes;
	
	public Projeto() {
		super();
	}
	
	
	public Projeto(String nome, String descricao, Usuario criador, Endereco localizacao, int status) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.criador = criador;
		this.localizacao = localizacao;
		this.status = status;
	}


	public void adicionarEquipe(Equipe equipe) {
		this.equipes.add(equipe);
	}
	public void adicionarTarefa(Equipe equipe, Tarefa tarefa) {
		int index = this.equipes.indexOf(equipe);
		this.equipes.get(index).addTarefa(tarefa);
	}
	
}
