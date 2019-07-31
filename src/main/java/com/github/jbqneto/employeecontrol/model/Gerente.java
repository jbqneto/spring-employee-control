package com.github.jbqneto.employeecontrol.model;

public class Gerente extends Funcionario {

	private int senha;
	
	@Override
	public double getBonificacao() {
		return super.getBonificacao() + super.getSalario();
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	public boolean autentica(int senha) {
		if (senha == this.senha) {
			return true;
		}
		return false;
	}
}
