package br.com.augusto.PortProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.augusto.PortProject.model.entity.Empresa;
import br.com.augusto.PortProject.repositories.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	private EmpresaRepository empresaRepository;

	public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}	
	
	@Override
	public List<Empresa> buscarTodos() {
		return empresaRepository.findAll();
	}
	
}