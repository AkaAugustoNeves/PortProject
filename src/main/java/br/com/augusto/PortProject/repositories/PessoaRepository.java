package br.com.augusto.PortProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.augusto.PortProject.model.entity.Pessoa;
import br.com.augusto.PortProject.model.enuns.Cargo;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	List<Pessoa> findByCargo(Cargo cargo);
	
}