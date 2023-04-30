package br.com.augusto.PortProject.model.dto;

import java.math.BigDecimal;

import br.com.augusto.PortProject.model.entity.Empresa;
import br.com.augusto.PortProject.model.entity.Pessoa;
import br.com.augusto.PortProject.model.entity.Projeto;
import br.com.augusto.PortProject.model.enuns.Risco;
import br.com.augusto.PortProject.model.enuns.Status;
import br.com.augusto.PortProject.service.ConvertService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjetoDTO {
	
	private Long id;
	private String nome;
	private String descricao;
	private String dataInicio;
	private String dataPrevisaoTermino;
	private String dataRealTermino;
	private BigDecimal orcamentoTotal;
	private Pessoa gerenteResponsavel;
	private Empresa empresa;
	private Risco risco;
	private Status status;
	
	public ProjetoDTO(Projeto projeto) {
		this.id = projeto.getId();
		this.nome = projeto.getNome();
		this.descricao = projeto.getDescricao();
		if(projeto.getDataInicio() !=  null) {
			this.dataInicio = ConvertService.convertDataFormat(projeto.getDataInicio());			
		}
		if(projeto.getDataPrevisaoTermino() !=  null) {
			this.dataPrevisaoTermino = ConvertService.convertDataFormat(projeto.getDataPrevisaoTermino());			
		}
		if(projeto.getDataRealTermino() !=  null) {
			this.dataRealTermino = ConvertService.convertDataFormat(projeto.getDataRealTermino());			
		}
		this.orcamentoTotal = projeto.getOrcamentoTotal();
		this.gerenteResponsavel = projeto.getGerenteResponsavel();
		this.empresa = projeto.getEmpresa();
		this.risco = projeto.getRisco();
		this.status = projeto.getStatus();
	}

}
