package br.com.blueplan.beans;

public abstract class Usuario {
	private int id;
	private String nome;
	private String email;
	private static int contadorUsuario = 0;
	
	public Usuario() {
		super();
	}
	
	
	
	public Usuario(String nome, String email) {
		super();
		this.id = contadorUsuario;
		
		contadorUsuario++;
		
		this.nome = nome;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj.getClass() != this.getClass()) {
			return false;
		}
		
		Usuario other = (Usuario) obj;
		
		if(other.getId() == this.getId()) {
			return true;
		}
		
		return false;
	}
	
	
}
