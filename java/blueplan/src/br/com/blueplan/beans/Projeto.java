package br.com.blueplan.beans;

import java.util.ArrayList;

public class Projeto {
	private String nome;
	private String descricao;
	private Usuario criador;
	private Endereco localizacao;
	private int status;
	private ArrayList<Equipe> equipes = new ArrayList<Equipe>();
	
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
	


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Usuario getCriador() {
		return criador;
	}


	public void setCriador(Usuario criador) {
		this.criador = criador;
	}


	public Endereco getLocalizacao() {
		return localizacao;
	}


	public void setLocalizacao(Endereco localizacao) {
		this.localizacao = localizacao;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public ArrayList<Equipe> getEquipes() {
		return equipes;
	}


	public void setEquipes(ArrayList<Equipe> equipes) {
		this.equipes = equipes;
	}


	public void adicionarEquipe(Equipe equipe) {
		this.equipes.add(equipe);
	}
	public void adicionarTarefa(Equipe equipe, Tarefa tarefa) {
		int index = this.equipes.indexOf(equipe);
		this.equipes.get(index).addTarefa(tarefa);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder retorno = new StringBuilder();
		
		retorno.append("Projeto: ").append(this.nome)
        .append("\nDescrição: ").append(this.descricao)
        .append("\nCriador: ").append(this.criador.getNome())
        .append("\nEndereco: ").append(this.localizacao)
        .append("\nEquipes: ");
		
		equipes.forEach((equipe) -> {
			retorno.append("\n" + equipe.toString());
		});
		return retorno.toString();
	}
	
}
