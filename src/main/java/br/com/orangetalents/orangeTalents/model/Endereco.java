package br.com.orangetalents.orangeTalents.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity //Utilizada pelo Hibernate para mapeamento da entidade.
public class Endereco {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
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
	@ManyToOne
	private Usuario usuario;
	
	public Endereco() {
		
	}
	

	public Endereco(@NotBlank String logradouro, @NotBlank String numero, String complemento, @NotBlank String bairro,
			@NotBlank String cidade, @NotBlank String estado, @NotBlank String cep, Usuario usuario) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.usuario = usuario;
	}


	public Long getId() {
		return id;
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


	public Usuario getUsuario() {
		return usuario;
	}
	
}
