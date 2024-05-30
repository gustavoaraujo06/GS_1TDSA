package br.com.blueplan.beans;

import java.util.ArrayList;

public class Projeto {
	private String titulo;
	private String descricao;
	private Usuario criador;
	private String duracao;
	private float verba;
	private Endereco localizacao;
	private ArrayList<Usuario> participantes;
	
	public Projeto() {
		super();
	}

	public Projeto(String titulo, String descricao, Usuario criador, String duracao, float verba,
			Endereco localizacao, ArrayList<Usuario> participantes) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.criador = criador;
		this.duracao = duracao;
		this.verba = verba;
		this.localizacao = localizacao;
		this.participantes = participantes;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public float getVerba() {
		return verba;
	}

	public void setVerba(float verba) {
		this.verba = verba;
	}

	public Endereco getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Endereco localizacao) {
		this.localizacao = localizacao;
	}
	public void addParticipante(Usuario novoParticipante) {
		this.participantes.add(novoParticipante);
	}
	public void removeParticipante(Usuario novoParticipante) {
		int index = this.participantes.indexOf(novoParticipante);
		this.participantes.remove(index);
	}
	public Usuario getParticipante(int clienteId) {
		for(int i  = 0; i < this.participantes.size(); i++) {
			if (participantes.get(i).getId() == clienteId) {
				return participantes.get(i);
			}
		}
		throw new RuntimeException("Cliente com id " + clienteId + " nao encontrado");
	}
	
}
