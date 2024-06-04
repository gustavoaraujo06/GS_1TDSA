package br.com.blueplan.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Tarefa {
	private int id;
	private String nome;
	private String descricao;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private int status;
	
	public Tarefa() {
		super();
	}

	public Tarefa(int id, String nome, String descricao, LocalDate data_inicio, int status) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicio = data_inicio;
		this.status = status;
	}

	public Tarefa(int id, String nome, String descricao, LocalDate data_inicio, LocalDate data_fim, int status) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicio = data_inicio;
		this.dataFim = data_fim;
		this.status = status;
	}
	private static int contadorTarefa = 0;

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

	public LocalDate getData_inicio() {
		return dataInicio;
	}

	public void setData_inicio(LocalDate data_inicio) {
		this.dataInicio = data_inicio;
	}

	public LocalDate getData_fim() {
		return dataFim;
	}

	public void setData_fim(LocalDate data_fim) {
		this.dataFim = data_fim;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public static Tarefa criarTarefa() {
		int id = contadorTarefa;
		contadorTarefa++;
		String nome = JOptionPane.showInputDialog("Digite o nome da tarefa");
		String descricao = JOptionPane.showInputDialog("Digite a descrição da tarefa");
		LocalDate dataInicio = LocalDate.now();
		if(JOptionPane.showOptionDialog(null, "Deseja adicionar uma data final para a tarefa?", "Data Final", 0, 3, null, null, null) == 0) {
			LocalDate dataFim = LocalDate.parse(JOptionPane.showInputDialog("Digite a data fim (dd/mm/yyyy)"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			return new Tarefa(id, nome, descricao, dataInicio, dataFim, 0);
		}
		return new Tarefa(id, nome, descricao, dataInicio, 0);
	}
	
	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder();
		retorno.append("\nNome: " + this.nome);
		retorno.append("\nDescrição: " + this.descricao);
		retorno.append("\nData Inicio: " + this.dataInicio);
		if(dataFim != null) {
			retorno.append("\nData Fim: " + this.dataFim);
		}
		retorno.append("\nStatus: " + this.status);
		
		return retorno.toString();
		
	}
	
}
