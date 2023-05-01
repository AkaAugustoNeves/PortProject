package br.com.augusto.PortProject.model.entity;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.augusto.PortProject.model.enuns.Risco;
import br.com.augusto.PortProject.model.enuns.Status;
import br.com.augusto.PortProject.model.form.ProjetoEditForm;
import br.com.augusto.PortProject.model.form.ProjetoForm;
import br.com.augusto.PortProject.service.ConvertService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private Date dataInicio;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private Date dataPrevisaoTermino;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private Date dataRealTermino;
	private BigDecimal orcamentoTotal;
	@ManyToOne
	@JoinColumn(name = "gerente_responsavel", referencedColumnName = "id")
	private Pessoa gerenteResponsavel;
	@ManyToOne
	private Empresa empresa;
	@Enumerated(EnumType.STRING)
	@Column(name = "risco")
	private Risco risco;
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;
	@ManyToMany(fetch= FetchType.LAZY)
	@JoinTable(name = "projeto_pessoa", joinColumns = @JoinColumn(name = "projeto_id"), inverseJoinColumns = @JoinColumn(name = "pessoa_id"))
	private List<Pessoa> integrantes = new ArrayList<>();
	
	public Projeto(Projeto antigo, ProjetoEditForm novo) throws ParseException {
		this.id = antigo.getId();
		this.nome = novo.getNome();
		this.descricao = novo.getDescricao();
		this.dataInicio = ConvertService.convertStringToDate(novo.getDataInicio());			
		this.dataPrevisaoTermino = ConvertService.convertStringToDate(novo.getDataPrevisaoTermino());			
		this.dataRealTermino = ConvertService.convertStringToDate(novo.getDataRealTermino());			
		this.orcamentoTotal = novo.getOrcamentoTotal();
		this.gerenteResponsavel = novo.getGerenteResponsavel();
		this.empresa = novo.getEmpresa();
		this.risco = novo.getRisco();
		this.status = novo.getStatus();
	}
	
	public Projeto(ProjetoEditForm form) throws ParseException {
		this.nome = form.getNome();
		this.descricao = form.getDescricao();
		this.dataInicio = ConvertService.convertStringToDate(form.getDataInicio());			
		this.dataPrevisaoTermino = ConvertService.convertStringToDate(form.getDataPrevisaoTermino());			
		this.dataRealTermino = ConvertService.convertStringToDate(form.getDataRealTermino());			
		this.orcamentoTotal = form.getOrcamentoTotal();
		this.gerenteResponsavel = form.getGerenteResponsavel();
		this.empresa = form.getEmpresa();
		this.risco = form.getRisco();
		this.status = form.getStatus();
	}
	
	public Projeto(ProjetoForm form) throws ParseException {
		this.nome = form.getNome();
		this.descricao = form.getDescricao();
		this.dataInicio = ConvertService.convertStringToDate(form.getDataInicio());			
		this.dataPrevisaoTermino = ConvertService.convertStringToDate(form.getDataPrevisaoTermino());			
		this.orcamentoTotal = form.getOrcamentoTotal();
		this.gerenteResponsavel = form.getGerenteResponsavel();
		this.empresa = form.getEmpresa();
		this.risco = form.getRisco();
		this.status = Status.EM_ANALISE;
	}
	
	public static boolean validDelete(Projeto projeto) {
		List<Status> statusList = List.of(Status.INICIADO, Status.EM_ANDAMENTO, Status.ENCERRADO);
		 for (Status status : statusList) {
	        if (projeto.getStatus().equals(status)) {
	            return false;
	        }
	    }
		return true;
	}
	
	
}