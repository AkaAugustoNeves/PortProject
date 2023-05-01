package br.com.augusto.PortProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.augusto.PortProject.model.entity.Projeto;
import br.com.augusto.PortProject.model.enuns.Risco;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

	List<Projeto> findByRisco(Risco risco);
	
}
