package br.com.orangetalents.orangeTalents.model.dto;

import br.com.orangetalents.orangeTalents.model.Endereco;

public class EnderecoResponse {
	
	private Long id;
	private String logradouro;
	
	public EnderecoResponse(Endereco endereco) {
		this.id = endereco.getId();
		this.logradouro = endereco.getLogradouro();
	}

	public Long getId() {
		return id;
	}

	public String getLogradouro() {
		return logradouro;
	}
	

}
