package br.com.blueplan.main;

import javax.swing.JOptionPane;

import br.com.blueplan.beans.Admin;
import br.com.blueplan.beans.Cliente;
import br.com.blueplan.beans.Endereco;
import br.com.blueplan.beans.Equipe;
import br.com.blueplan.beans.Projeto;

public class Main {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente(
				JOptionPane.showInputDialog("Qual o nome do Cliente 1?"), 
				JOptionPane.showInputDialog("Qual o email do Cliente 1?"), 
				JOptionPane.showInputDialog("Qual o rg do Cliente 1?"), 
				JOptionPane.showInputDialog("Qual o cpf do Cliente 1?")
				);
		Cliente cliente2 = new Cliente(
				JOptionPane.showInputDialog("Qual o nome do Cliente 2?"), 
				JOptionPane.showInputDialog("Qual o email do Cliente 2?"), 
				JOptionPane.showInputDialog("Qual o rg do Cliente 2?"), 
				JOptionPane.showInputDialog("Qual o cpf do Cliente 2?")
				);
		Admin admin = new Admin(
				JOptionPane.showInputDialog("Qual o nome do Administrador?"), 
				JOptionPane.showInputDialog("Qual o email do Administrador?")
				);
		Projeto novoProjeto = admin.criarProjeto(
				JOptionPane.showInputDialog("Qual o nome do Projeto?"), 
				JOptionPane.showInputDialog("Qual a descrição do Projeto?"), 
				new Endereco(
						JOptionPane.showInputDialog("Qual a rua do Projeto?"),
						Integer.parseInt(JOptionPane.showInputDialog("Qual o numero da rua?")),
						JOptionPane.showInputDialog("Qual o cep do Projeto?"),
						JOptionPane.showInputDialog("Qual o complemento do Projeto?")
						));
		Equipe equipe1 = Equipe.criarEquipe();
		
		novoProjeto.adicionarEquipe(equipe1);
		
		
	}

}
