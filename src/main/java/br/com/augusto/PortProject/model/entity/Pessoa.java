package br.com.augusto.PortProject.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.augusto.PortProject.model.enuns.Cargo;
import br.com.augusto.PortProject.model.form.PessoaForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Enumerated(EnumType.STRING)
	@Column(name = "cargo")
	private Cargo cargo;
	
	public Pessoa(PessoaForm pessoa) {
		this.nome = pessoa.getNome();
		this.cargo = pessoa.getCargo();
	}

}