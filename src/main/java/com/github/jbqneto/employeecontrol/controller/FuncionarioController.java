package com.github.jbqneto.employeecontrol.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.jbqneto.employeecontrol.model.Funcionario;
import com.github.jbqneto.employeecontrol.model.Gerente;

/**
 * 
 * @author Neto
 * 
 * Employee class
 *
 */
@RestController
public class FuncionarioController {
	
	public FuncionarioController() {
		Funcionario func = new Funcionario();
		func.setNome("Neto");
		func.setCpf("12345678901");
		func.setSalario(2000.00);
		
		FolhaController.registraFuncionario(func);
		
		Gerente gerente = new Gerente();
		gerente.setNome("Judivam");
		gerente.setCpf("10987654321");
		gerente.setSenha(123456);
		gerente.setSalario(5000.00);
		
		FolhaController.registraFuncionario(gerente);
	}
	
	@RequestMapping(value="/funcionarios", method = RequestMethod.GET)
	public List<Funcionario> getFuncionarios() {
		return FolhaController.getFuncionarios();
	}
	
	@RequestMapping(value="/funcionario/{id}", method = RequestMethod.GET)
	public Funcionario getFuncionario(@PathVariable int id) {
		List<Funcionario> funcionarios = FolhaController.getFuncionarios();
		if (funcionarios.size() > id) {
			return funcionarios.get(id);
		} else {
			return null;
		}
	}
	
	@RequestMapping(value="/autentica/{id}/{senha}", method = RequestMethod.GET)
	public boolean autentica(@PathVariable int id, @PathVariable int senha) throws Exception {
		Funcionario func = getFuncionario(id);
		
		if (func == null)
			throw new Exception("Funcionário não encontrado: " + id);
		
		if (Gerente.class.isInstance(func)) {
			return ((Gerente) func).autentica(senha);
		} else {
			throw new Exception("Funcionário não é do tipo gerente: " + func.getNome());
		}
		
	}
	
}
