package com.opeterfreitas.banco.cliente;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	private ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public ClienteDTO save(ClienteDTO clienteDTO) {
		Cliente cliente = clienteRepository.save(Cliente.convert(clienteDTO));
		return ClienteDTO.convert(cliente);
	}

	public List<ClienteDTO> getAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes.stream().map(ClienteDTO::convert).collect(Collectors.toList());
	}

}