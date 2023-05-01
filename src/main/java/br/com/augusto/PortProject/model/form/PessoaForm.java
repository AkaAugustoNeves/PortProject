package br.com.augusto.PortProject.model.form;

import br.com.augusto.PortProject.model.enuns.Cargo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaForm {

	private String nome;
	private Cargo cargo;	
	
}