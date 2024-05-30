package br.com.blueplan.beans;

public class Cliente extends Usuario {
	public Cliente() {
		super();
	}

	public Cliente(int id, String nome, String cpf, String rg, Endereco endereco, String dataNascimento, String email,
			int role) {
		super(id, nome, cpf, rg, endereco, dataNascimento, email, role);
	}
	
	
}
