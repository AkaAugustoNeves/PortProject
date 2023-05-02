package br.com.augusto.PortProject.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.augusto.PortProject.model.entity.Pessoa;
import br.com.augusto.PortProject.model.enuns.Cargo;
import br.com.augusto.PortProject.repositories.PessoaRepository;

public class PessoaServiceImplTest {
	
	@Mock
    private PessoaRepository pessoaRepository;
    
    @InjectMocks
    private PessoaServiceImpl pessoaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        pessoaService = new PessoaServiceImpl(pessoaRepository);
    }
    
    @Test
    void buscarPorCargo_deveRetornarUmaListaDePessoasDoMesmoCargo() {
        // given
        Cargo cargo = Cargo.FUNCIONARIO;
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa(1L, "João", Cargo.FUNCIONARIO));
        pessoas.add(new Pessoa(2L, "Maria", Cargo.FUNCIONARIO));

        // when
        when(pessoaRepository.findByCargo(cargo)).thenReturn(pessoas);

        // then
        List<Pessoa> pessoasRetornadas = pessoaService.buscarPorCargo(cargo);
        assertEquals(pessoas, pessoasRetornadas);
    }
    
    @Test
    public void deveRetornarPessoaPorId() {
        Long id = 1L;
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        when(pessoaRepository.findById(id)).thenReturn(Optional.of(pessoa));

        Optional<Pessoa> resultado = pessoaService.buscarPorId(id);

        Assertions.assertTrue(resultado.isPresent());
        Assertions.assertEquals(id, resultado.get().getId());
    }

    @Test
    public void deveRetornarVazioQuandoIdNaoExistir() {
        Long id = 1L;
        when(pessoaRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Pessoa> resultado = pessoaService.buscarPorId(id);

        Assertions.assertFalse(resultado.isPresent());
    }


}
