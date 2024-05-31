package br.com.blueplan.beans;

public class Cliente extends Usuario {
	private String cpf;
	private String rg;
	
	
	public Cliente() {
		super();
	}


	public Cliente(String nome, String email, String cpf, String rg) {
		super(nome, email);
		this.cpf = cpf;
		this.rg = rg;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
	
	
	
	
}
