package br.com.augusto.PortProject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.augusto.PortProject.model.entity.Empresa;
import br.com.augusto.PortProject.repositories.EmpresaRepository;

public class EmpresaServiceImplTest {

	private EmpresaServiceImpl empresaService;

    @Mock
    private EmpresaRepository empresaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        empresaService = new EmpresaServiceImpl(empresaRepository);
    }

    @Test
    void buscarTodos_deveRetornarUmaListaDeEmpresas() {
        // given
        List<Empresa> empresas = new ArrayList<>();
        empresas.add(new Empresa("Empresa 1"));
        empresas.add(new Empresa("Empresa 2"));

        // when
        when(empresaRepository.findAll()).thenReturn(empresas);

        // then
        List<Empresa> empresasRetornadas = empresaService.buscarTodos();
        assertEquals(empresas, empresasRetornadas);
    }
	
}
