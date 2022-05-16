package com.opeterfreitas.banco.cliente;

import java.util.List;
import java.util.Optional;
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
	
	public ClienteDTO findByCpf(String cpf) {
		Cliente cliente = clienteRepository.findByCpf(cpf);
		if (cliente != null) {
			return ClienteDTO.convert(cliente);
		}
		return null;
	}

	public ClienteDTO delete(Long clienteId) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		if (cliente.isPresent()) {
			clienteRepository.delete(cliente.get());
		}
		return null;
	}
	
}