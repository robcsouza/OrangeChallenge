package br.com.orangetalents.orangeTalents.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.orangetalents.orangeTalents.model.Usuario;

public class UsuarioDetalheResponse {
	
	private Long id;
	private String nome;
	private List<EnderecoResponse> enderecos;
	
	public UsuarioDetalheResponse(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.enderecos = new ArrayList<EnderecoResponse>();
		this.enderecos.addAll(usuario.getEnderecos().stream().map(EnderecoResponse::new).collect(Collectors.toList()));
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<EnderecoResponse> getEnderecos() {
		return enderecos;
	}
	
	

}
