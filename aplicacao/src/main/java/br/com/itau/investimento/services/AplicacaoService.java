package br.com.itau.investimento.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.itau.investimento.clients.ClienteClient;
import br.com.itau.investimento.clients.ProdutoClient;
import br.com.itau.investimento.models.Aplicacao;
import br.com.itau.investimento.repositories.AplicacaoRepository;
import br.com.itau.investimento.viewobjects.Cliente;
import br.com.itau.investimento.viewobjects.Produto;

@Service
public class AplicacaoService {
	@Autowired
	AplicacaoRepository aplicacaoRepository;
	
	@Autowired
	ClienteClient clienteClient;
	
	@Autowired
	ProdutoClient produtoClient;

	public Aplicacao criar(Aplicacao aplicacao) {
		Produto produto = produtoClient.buscarPorId(aplicacao.getProduto().getId());
		Cliente cliente = clienteClient.buscarPorCpf(aplicacao.getCliente().getCpf());
		
		aplicacao.setProduto(produto);
		aplicacao.setCliente(cliente);
		aplicacao.setDataCriacao(LocalDate.now());
		
		return aplicacaoRepository.save(aplicacao);
	}
}
