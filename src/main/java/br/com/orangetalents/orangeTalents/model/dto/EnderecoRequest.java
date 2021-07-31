package br.com.orangetalents.orangeTalents.model.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

import br.com.orangetalents.orangeTalents.model.Endereco;
import br.com.orangetalents.orangeTalents.model.Usuario;

public class EnderecoRequest {
	
	@NotBlank
	private String logradouro;
	@NotBlank
	private String numero;
	private String complemento;
	@NotBlank
	private String bairro;
	@NotBlank
	private String cidade;
	@NotBlank
	private String estado;
	@NotBlank
	private String cep;
	private Long usuarioId;
	public EnderecoRequest(@NotBlank String logradouro, @NotBlank String numero, String complemento,
			@NotBlank String bairro, @NotBlank String cidade, @NotBlank String estado, @NotBlank String cep,
			Long usuarioId) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.usuarioId = usuarioId;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEstado() {
		return estado;
	}
	public String getCep() {
		return cep;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	
	public Endereco converter(EntityManager m) {
		return new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep,
				m.find(Usuario.class, usuarioId));
	}
}
