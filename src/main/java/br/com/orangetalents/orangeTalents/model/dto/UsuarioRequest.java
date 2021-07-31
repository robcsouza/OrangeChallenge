package br.com.orangetalents.orangeTalents.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.orangetalents.orangeTalents.model.Usuario;

public class UsuarioRequest {
	
	@NotBlank(message = "O campo Nome é obrigatório.")
	private String nome;
	@NotBlank(message = "O campo E-Mail é obrigatório.")
	@Email(message = "E-Mail inválido!")
	private String email;
	@NotBlank(message = "O campo CPF é obrigatório.")
	@CPF(message = "CPF inválido!")
	private String cpf;
	@NotNull(message = "O campo Data de Nascimento é obrigatório.")
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dtnasc;
	
	public UsuarioRequest(@NotBlank(message = "O campo Nome é obrigatório.") String nome,
			@NotBlank(message = "O campo E-Mail é obrigatório.") @Email(message = "E-Mail inválido!") String email,
			@NotBlank(message = "O campo CPF é obrigatório.") @CPF(message = "CPF inválido!") String cpf,
			@NotNull(message = "O campo Data de Nascimento é obrigatório.") LocalDate dtnasc) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dtnasc = dtnasc;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDtnasc() {
		return dtnasc;
	}
	
	public Usuario converter() {
		Usuario usuario = new Usuario(nome, email, cpf, dtnasc);
		return usuario;
	}
}
