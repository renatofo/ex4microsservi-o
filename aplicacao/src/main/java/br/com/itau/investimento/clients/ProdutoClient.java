package br.com.itau.investimento.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.itau.investimento.viewobjects.Produto;

@FeignClient(name="produto", url="localhost:8082")
public interface ProdutoClient {

	@GetMapping("/{id}")
	public Produto buscarPorId(@PathVariable int id);
}
