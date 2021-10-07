package com.soutoMoney17.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soutoMoney17.model.Pessoa;
import com.soutoMoney17.repository.pessoa.PessoaRepositoryQuery;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaRepositoryQuery {

	

}
