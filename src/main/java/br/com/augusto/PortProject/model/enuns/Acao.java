package br.com.augusto.PortProject.model.enuns;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Acao {

	ALOCAR,
	DESALOCAR;
	
	private Long id;
	private String nome;
	
	public static List<Acao> valores(){
		return Arrays.asList(values());
	}
	
}