package br.com.itau.investimentoproduto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.itau.investimentoproduto.models.Produto;
import br.com.itau.investimentoproduto.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;
	
	public Iterable<Produto> listar(){
		return produtoRepository.findAll();
	}
	
	public Optional<Produto> buscar(int id) {
		return produtoRepository.findById(id);
	}

	public Produto criar(Produto produto){
		return produtoRepository.save(produto);
	}
}
