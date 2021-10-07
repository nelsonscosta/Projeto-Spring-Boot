package com.soutoMoney17.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soutoMoney17.model.Lancamento;
import com.soutoMoney17.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
