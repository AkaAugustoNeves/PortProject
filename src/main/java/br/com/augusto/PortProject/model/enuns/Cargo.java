package br.com.augusto.PortProject.model.enuns;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Cargo {

	GERENTE,
	FUNCIONARIO;
	
	private Long id;
	private String nome;
	
	public static List<Cargo> valores(){
		return Arrays.asList(values());
	}
	
}