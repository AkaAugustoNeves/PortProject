package br.com.augusto.PortProject.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.augusto.PortProject.model.entity.Empresa;
import br.com.augusto.PortProject.model.entity.Pessoa;
import br.com.augusto.PortProject.model.entity.Projeto;
import br.com.augusto.PortProject.model.enuns.Risco;
import br.com.augusto.PortProject.model.enuns.Status;
import br.com.augusto.PortProject.model.form.ProjetoForm;
import br.com.augusto.PortProject.repositories.PessoaRepository;
import br.com.augusto.PortProject.repositories.ProjetoRepository;

public class ProjetoServiceImplTest {
	
	private ProjetoServiceImpl projetoService;
    
    @Mock
    private ProjetoRepository projetoRepository;
    
    @Mock
    private PessoaRepository pessoaRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        projetoService = new ProjetoServiceImpl(projetoRepository, pessoaRepository);
    }
    
    @Test
    void testBuscarTodos() {
        List<Projeto> projetos = new ArrayList<>();
        projetos.add(new Projeto());
        projetos.add(new Projeto());
        when(projetoRepository.findAll()).thenReturn(projetos);
        List<Projeto> result = projetoService.buscarTodos();
        assertThat(result).hasSize(projetos.size());
    }
    
    @Test
    public void buscarPorId_deveRetornarProjetoExistente() {
        Long id = 1L;
        Projeto projeto = new Projeto();
        projeto.setId(id);
        when(projetoRepository.findById(id)).thenReturn(Optional.of(projeto));
        Optional<Projeto> projetoEncontrado = projetoService.buscarPorId(id);
        assertTrue(projetoEncontrado.isPresent());
        assertEquals(projeto, projetoEncontrado.get());
    }

    @Test
    public void buscarPorId_deveRetornarVazioSeProjetoNaoExiste() {
        Long id = 1L;
        when(projetoRepository.findById(id)).thenReturn(Optional.empty());
        Optional<Projeto> projetoEncontrado = projetoService.buscarPorId(id);
        assertFalse(projetoEncontrado.isPresent());
    }
    
    @Test
    public void testSalvar() throws ParseException {
        ProjetoRepository projetoRepository = mock(ProjetoRepository.class);
        PessoaRepository pessoaRepository = mock(PessoaRepository.class);
        ProjetoService projetoService = new ProjetoServiceImpl(projetoRepository, pessoaRepository);

        ProjetoForm projetoForm = new ProjetoForm();
        projetoForm.setNome("Projeto Teste");
        projetoForm.setDescricao("Descrição do Projeto Teste");
        projetoForm.setDataInicio("2022-01-01");
        projetoForm.setDataPrevisaoTermino("2022-06-30");
        projetoForm.setOrcamentoTotal(new BigDecimal("100000.00"));
        projetoForm.setGerenteResponsavel(new Pessoa());
        projetoForm.setEmpresa(new Empresa());
        projetoForm.setRisco(Risco.ALTO);

        Projeto projetoSalvo = new Projeto(projetoForm);

        when(projetoRepository.save(any(Projeto.class))).thenReturn(projetoSalvo);

        Projeto projetoRetornado = projetoService.salvar(projetoForm);

        assertNotNull(projetoRetornado);
        assertEquals(projetoSalvo.getId(), projetoRetornado.getId());
        assertEquals(projetoSalvo.getNome(), projetoRetornado.getNome());
        assertEquals(projetoSalvo.getDescricao(), projetoRetornado.getDescricao());
        assertEquals(projetoSalvo.getDataInicio(), projetoRetornado.getDataInicio());
        assertEquals(projetoSalvo.getDataPrevisaoTermino(), projetoRetornado.getDataPrevisaoTermino());
        assertEquals(projetoSalvo.getOrcamentoTotal(), projetoRetornado.getOrcamentoTotal());
        assertEquals(projetoSalvo.getGerenteResponsavel(), projetoRetornado.getGerenteResponsavel());
        assertEquals(projetoSalvo.getEmpresa(), projetoRetornado.getEmpresa());
        assertEquals(projetoSalvo.getRisco(), projetoRetornado.getRisco());
        assertEquals(projetoSalvo.getStatus(), projetoRetornado.getStatus());
    }

    @Test
    void testExcluirProjetoValido() {
        // Arrange
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setStatus(Status.EM_ANALISE);
        Optional<Projeto> optionalProjeto = Optional.of(projeto);
        when(projetoRepository.findById(1L)).thenReturn(optionalProjeto);
        
        // Act
        projetoService.excluir(1L);
        
        // Assert
        verify(projetoRepository, times(1)).deleteById(1L);
    }
    
    @Test
    void testExcluirProjetoInvalido() {
        // Arrange
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setStatus(Status.INICIADO);
        Optional<Projeto> optionalProjeto = Optional.of(projeto);
        when(projetoRepository.findById(1L)).thenReturn(optionalProjeto);
        
        // Act
        projetoService.excluir(1L);
        
        // Assert
        verify(projetoRepository, times(0)).deleteById(1L);
    }
    
    @Test
    void testExcluirProjetoInexistente() {
        // Arrange
        Optional<Projeto> optionalProjeto = Optional.empty();
        when(projetoRepository.findById(1L)).thenReturn(optionalProjeto);
        
        // Act
        projetoService.excluir(1L);
        
        // Assert
        verify(projetoRepository, times(0)).deleteById(1L);
    }
 
}
