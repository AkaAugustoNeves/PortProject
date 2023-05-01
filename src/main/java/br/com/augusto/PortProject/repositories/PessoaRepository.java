package br.com.augusto.PortProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.augusto.PortProject.model.entity.Pessoa;
import br.com.augusto.PortProject.model.enuns.Cargo;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	List<Pessoa> findByCargo(Cargo cargo);
	
	@Query(value = "select * from pessoa p where p.id not in ("
			+ "	select pp.pessoa_id from projeto pr"
			+ "	join projeto_pessoa pp ON pp.projeto_id = pr.id"
			+ "	where pr.id = ?1"
			+ ")", nativeQuery = true)
	List<Pessoa> findNaoIntegranteByProjeto(Long id);
	
}