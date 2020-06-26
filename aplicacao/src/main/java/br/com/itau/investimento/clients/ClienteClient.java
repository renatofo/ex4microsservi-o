package br.com.itau.investimento.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.itau.investimento.viewobjects.Cliente;

@FeignClient(name="cliente", url="localhost:8081")
public interface ClienteClient {
	@GetMapping("/{cpf}")
	public Cliente buscarPorCpf(@PathVariable String cpf);
}
