package br.com.augusto.PortProject.model.form;

import java.math.BigDecimal;

import br.com.augusto.PortProject.model.entity.Empresa;
import br.com.augusto.PortProject.model.entity.Pessoa;
import br.com.augusto.PortProject.model.enuns.Risco;
import br.com.augusto.PortProject.model.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjetoForm {
	
	private Long id;
	private String nome;
	private String descricao;
	private String dataInicio;
	private String dataPrevisaoTermino;
	private BigDecimal orcamentoTotal;
	private Pessoa gerenteResponsavel;
	private Empresa empresa;
	private Risco risco;

}