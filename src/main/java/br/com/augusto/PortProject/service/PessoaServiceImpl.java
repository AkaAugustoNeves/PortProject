package br.com.augusto.PortProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.augusto.PortProject.model.entity.Pessoa;
import br.com.augusto.PortProject.repositories.PessoaRepository;

@Service
public class PessoaServiceImpl implements PessoaService{

	private PessoaRepository pessoaRepository;

	public PessoaServiceImpl(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	@Override
	public List<Pessoa> buscarTodos() {
		return pessoaRepository.findAll();
	}
	
}