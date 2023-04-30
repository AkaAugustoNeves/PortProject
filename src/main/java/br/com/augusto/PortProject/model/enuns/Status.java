package br.com.augusto.PortProject.model.enuns;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Status {
	
	EM_ANALISE,
	ANALISE_REALIZADA,
	ANALISE_APROVADA,
	INICIADO,
	PLANEJADO,
	EM_ANDAMENTO,
	ENCERRADO,
	CANCELADO;
	
	private Long id;
	private String nome;
	
	public static List<Status> valores(){
		return Arrays.asList(values());
	}
	
}