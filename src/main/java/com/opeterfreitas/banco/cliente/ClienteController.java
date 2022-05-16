package com.opeterfreitas.banco.cliente;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

	private ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping("/cliente")
	ClienteDTO novoCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
		return clienteService.save(clienteDTO);
	}

	@GetMapping("/cliente")
	public List<ClienteDTO> getClientes() {
		List<ClienteDTO> clientes = clienteService.getAll();
		return clientes;
	}
	
	@GetMapping("/cliente/{cpf}")
	ClienteDTO findByCpf(@PathVariable String cpf) {
		return clienteService.findByCpf(cpf);
	}

	@DeleteMapping("/cliente/{id}")
	ClienteDTO delete(@PathVariable Long id) {
		return clienteService.delete(id);
	}
	
}