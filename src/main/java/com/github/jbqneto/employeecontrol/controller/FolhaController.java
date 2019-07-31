package com.github.jbqneto.employeecontrol.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.jbqneto.employeecontrol.model.Funcionario;

/**
 * Implemented to test some Polymorfism
 * @author Neto
 *
 */
@RestController
@RequestMapping("folha")
public class FolhaController {

	private static ArrayList<Funcionario> folhaFuncionarios = new ArrayList<Funcionario>();
	
	public static void registraFuncionario(Funcionario funcionario) {
		folhaFuncionarios.add(funcionario);
	}
	
	public static List<Funcionario> getFuncionarios() {
		return folhaFuncionarios;
	}
	
	@RequestMapping(value="/bonificacoes", method = RequestMethod.GET)
	public double getSomaBonificacoes() {
		double soma = 0.0;
		for (Funcionario func: folhaFuncionarios) {
			soma += func.getBonificacao();
		}
		
		return soma;
	}
	
	@RequestMapping(value="/salarios", method = RequestMethod.GET)
	public double getSomaSalarios() {
		double soma = 0.0;
		for (Funcionario func: folhaFuncionarios) {
			soma += func.getSalario();
		}
		return soma;
	}
	
	@RequestMapping(value="/total", method = RequestMethod.GET)
	public double getValorFolha() {
		return getSomaBonificacoes() + getSomaSalarios();
	}
	
}
