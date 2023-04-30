package br.com.augusto.PortProject.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import br.com.augusto.PortProject.model.entity.Projeto;
import br.com.augusto.PortProject.model.form.ProjetoEditForm;
import br.com.augusto.PortProject.model.form.ProjetoForm;

public interface ProjetoService {
	
	List<Projeto> buscarTodos();
	
	Optional<Projeto> buscarPorId(Long id);
	
    Projeto salvar(ProjetoForm projeto) throws ParseException;
    
    Projeto editar(Long id, ProjetoEditForm projeto) throws ParseException;

    void excluir(Long id);
	
}
