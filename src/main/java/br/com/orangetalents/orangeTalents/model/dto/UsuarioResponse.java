package br.com.orangetalents.orangeTalents.model.dto;

import br.com.orangetalents.orangeTalents.model.Usuario;

public class UsuarioResponse {
	
	private Long id;
	private String nome;
	
	public UsuarioResponse(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	

}
