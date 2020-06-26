package br.com.itau.investimento.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.investimento.models.Aplicacao;

public interface AplicacaoRepository extends CrudRepository<Aplicacao, Integer> {

}
