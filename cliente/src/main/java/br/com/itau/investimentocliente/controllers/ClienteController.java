package br.com.itau.investimentocliente.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.itau.investimentocliente.models.Cliente;
import br.com.itau.investimentocliente.services.ClienteService;

@RestController
public class ClienteController {
	@Autowired
	ClienteService clienteService;

	@GetMapping("/{cpf}")
	public Cliente buscar(@PathVariable String cpf) {
		Optional<Cliente> clienteOptional = clienteService.buscar(cpf);
		
		if(clienteOptional.isPresent()) {
			return clienteOptional.get();
		}
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente criar(@RequestBody Cliente cliente){
		return clienteService.cadastrar(cliente);
	}
}
