package br.com.augusto.PortProject.model.enuns;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Risco {

	BAIXO,
	MEDIO,
	ALTO;
	
	private Long id;
	private String nome;
	
	public static List<Risco> valores(){
		return Arrays.asList(values());
	}
	
}