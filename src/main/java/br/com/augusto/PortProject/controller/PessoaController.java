package br.com.augusto.PortProject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.augusto.PortProject.model.entity.Pessoa;
import br.com.augusto.PortProject.model.form.PessoaForm;
import br.com.augusto.PortProject.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	private PessoaService pessoaService;
		
	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	@PostMapping
	public Pessoa criar(@RequestBody PessoaForm pessoa) {
		return pessoaService.salvar(pessoa);
	}

}