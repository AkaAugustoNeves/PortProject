package br.com.augusto.PortProject.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.augusto.PortProject.model.entity.Pessoa;
import br.com.augusto.PortProject.model.entity.Projeto;
import br.com.augusto.PortProject.model.enuns.Acao;
import br.com.augusto.PortProject.model.enuns.Risco;
import br.com.augusto.PortProject.model.enuns.Status;
import br.com.augusto.PortProject.model.form.ProjetoEditForm;
import br.com.augusto.PortProject.model.form.ProjetoForm;
import br.com.augusto.PortProject.repositories.PessoaRepository;
import br.com.augusto.PortProject.repositories.ProjetoRepository;

@Service
public class ProjetoServiceImpl implements ProjetoService{

    private ProjetoRepository projetoRepository;
    private PessoaRepository pessoaRepository;

    public ProjetoServiceImpl(ProjetoRepository projetoRepository, PessoaRepository pessoaRepository) {
		this.projetoRepository = projetoRepository;
		this.pessoaRepository = pessoaRepository;
	}
    
    @Override
    public List<Projeto> buscarTodos() {
        return projetoRepository.findAll();
    }

    @Override
    public Optional<Projeto> buscarPorId(Long id) {
    	return projetoRepository.findById(id); 
    }
    
    @Override
    public Projeto salvar(ProjetoForm projeto) throws ParseException {
        return projetoRepository.save(new Projeto(projeto));
    }

    @Override
    @Transactional
    public void excluir(Long id) {
    	Optional<Projeto> projeto = projetoRepository.findById(id);
    	if(projeto.isPresent()) {
    		if(Projeto.validDelete(projeto.get())) {
    			projetoRepository.deleteById(id);	
    		}
    	}    	
    }

	@Override
	public Projeto editar(Long id, ProjetoEditForm projeto) throws ParseException {
		Optional<Projeto> antigo = this.projetoRepository.findById(id);
		if(antigo.isPresent()) {
			return projetoRepository.save(new Projeto(antigo.get(), projeto));
		}
		return null;
	}

	@Override
	public List<Projeto> buscarPorRisco(Risco risco) {
		return projetoRepository.findByRisco(risco);
	}

	@Override
	public List<Pessoa> buscarNaoIntegrantes(Long id) {
		return pessoaRepository.findNaoIntegranteByProjeto(id);
	}

	@Override
	public Projeto acaoIntegrante(Long id, Acao acao, Long idPessoa) {
		Optional<Projeto> projeto = projetoRepository.findById(id);
		Optional<Pessoa> pessoa = pessoaRepository.findById(idPessoa);
		if(acao.equals(Acao.ALOCAR)) {
			if(projeto.isPresent()) {
				projeto.get().getIntegrantes().add(pessoa.get());
				return projetoRepository.save(projeto.get());
			}
			return null;
		}else {
			if(projeto.isPresent()) {
				if(projeto.get().getIntegrantes().contains(pessoa.get())) {
					projeto.get().getIntegrantes().remove(pessoa.get());
					return projetoRepository.save(projeto.get());
				}
			}
			return null;
		}
	}    
	
}