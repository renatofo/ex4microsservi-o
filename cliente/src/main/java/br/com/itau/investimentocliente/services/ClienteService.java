package br.com.itau.investimentocliente.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.itau.investimentocliente.models.Cliente;
import br.com.itau.investimentocliente.repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente cadastrar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Optional<Cliente> buscar(String cpf){
		return clienteRepository.findByCpf(cpf);
	}
}
