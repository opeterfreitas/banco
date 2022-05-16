package com.opeterfreitas.banco.cliente;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ClienteDTO {

	@NotBlank
	private String nome;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String cpf;
	private LocalDate dataNascimento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public static ClienteDTO convert(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setDataNascimento(cliente.getDataNascimento());
		return clienteDTO;

	}

}