package br.com.augusto.PortProject.service;

import java.util.List;
import java.util.Optional;

import br.com.augusto.PortProject.model.entity.Pessoa;
import br.com.augusto.PortProject.model.enuns.Cargo;
import br.com.augusto.PortProject.model.form.PessoaForm;

public interface PessoaService {

	List<Pessoa> buscarTodos();
	
	List<Pessoa> buscarPorCargo(Cargo cargo);
	
	Optional<Pessoa> buscarPorId(Long id);
	
	Pessoa salvar(PessoaForm pessoa);

}