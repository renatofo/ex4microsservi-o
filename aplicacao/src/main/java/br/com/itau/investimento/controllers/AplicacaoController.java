package br.com.itau.investimento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.investimento.models.Aplicacao;
import br.com.itau.investimento.services.AplicacaoService;

@RestController
public class AplicacaoController {
	@Autowired
	AplicacaoService aplicacaoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aplicacao criar(@RequestBody Aplicacao aplicacao){
		return aplicacaoService.criar(aplicacao);
	}
}
