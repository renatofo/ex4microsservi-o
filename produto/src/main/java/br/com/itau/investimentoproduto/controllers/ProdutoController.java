package br.com.itau.investimentoproduto.controllers;

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

import br.com.itau.investimentoproduto.models.Produto;
import br.com.itau.investimentoproduto.services.ProdutoService;

@RestController
public class ProdutoController {
	@Autowired
	ProdutoService produtoService;
	
	@GetMapping
	public Iterable<Produto> listar(){
		return produtoService.listar();
	}
	
	@GetMapping("/{id}")
	public Produto buscar(@PathVariable int id) {
		Optional<Produto> produtoOptional = produtoService.buscar(id);
		
		if(produtoOptional.isPresent()) {
			return produtoOptional.get();
		}
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto criar(@RequestBody Produto produto) {
		return produtoService.criar(produto);
	}
}
