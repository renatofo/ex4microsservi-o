package br.com.itau.investimentoproduto.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.investimentoproduto.models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

}
