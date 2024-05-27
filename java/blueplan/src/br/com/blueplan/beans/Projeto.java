package br.com.blueplan.beans;

import java.util.ArrayList;

public class Projeto {
	private String titulo;
	private String descricao;
	private Cliente criador;
	private String duracao;
	private float verba;
	private Endereco localizacao;
	private ArrayList<Cliente> participantes;
	
	public Projeto() {
		super();
	}

	public Projeto(String titulo, String descricao, Cliente criador, String duracao, float verba,
			Endereco localizacao, ArrayList<Cliente> participantes) {
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

	public Cliente getCriador() {
		return criador;
	}

	public void setCriador(Cliente criador) {
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
	public void addParticipante(Cliente novoParticipante) {
		this.participantes.add(novoParticipante);
	}
	public void removeParticipante(Cliente novoParticipante) {
		int index = this.participantes.indexOf(novoParticipante);
		this.participantes.remove(index);
	}
	public Cliente getParticipante(int clienteId) {

	}
}
