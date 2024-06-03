package br.com.blueplan.beans;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Equipe {
	private int id;
	private String nome;
	private String descricao;
	private LocalDate dataCriacao;
	private ArrayList<Cliente> membros = new ArrayList<Cliente>();
	private ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
	
	//so pra deixar bonitinho
	private static int idCounter = 0;
	
	public Equipe() {
		super();
	}

	public Equipe(int id, String nome, LocalDate dataCriacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
	}

	public Equipe(int id, String nome, String descricao, LocalDate dataCriacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	
	public ArrayList<Cliente> getMembros() {
		return membros;
	}

	public void setMembros(ArrayList<Cliente> membros) {
		this.membros = membros;
	}
	
	
	public ArrayList<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(ArrayList<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
	public void addTarefa(Tarefa tarefa) {
		tarefas.add(tarefa);
	}
	
	public void removeTarefa(Tarefa tarefa) {
		tarefas.remove(tarefa);
	}

	public void addMember(Cliente cliente) {
		membros.add(cliente);
	}
	public void removeMember(Cliente cliente) {
		membros.remove(cliente);
	}
	
	
	
	public static Equipe criarEquipe() {
		int newId = Equipe.idCounter;
		
		idCounter++;
		
		String nome = JOptionPane.showInputDialog("Digite o nome da equipe:");
		String descricao = JOptionPane.showInputDialog("Digite a descrição (se tiver):");
		LocalDate data_criacao = LocalDate.now();
		
		if(descricao.length() > 0) {
			return new Equipe(newId, nome, descricao, data_criacao);
		}else {
			return new Equipe(newId, nome, data_criacao);
		}
	}
	@Override
	public String toString() {
		String membrosString = "";
		for(int i = 0; i < membros.size(); i++) {
			membrosString += membros.get(i) + "\n";
		}
		String tarefaString = "";
		for(int i = 0; i < tarefas.size(); i++) {
			tarefaString += tarefas.get(i) + "\n";
		}
		return 
				"\nEquipe " + this.getNome() +
				"\nID: " + this.getId() +
				"\nDescrição: " + this.getDescricao() +
				"\nData de Criação: " + this.getDataCriacao() +
				"\nMembros: \n" + membrosString +
				"\nTarefas: \n" + tarefaString;
	}
}
