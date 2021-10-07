package com.soutoMoney17.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.soutoMoney17.model.Lancamento;
import com.soutoMoney17.model.Pessoa;
import com.soutoMoney17.repository.LancamentoRepository;
import com.soutoMoney17.repository.PessoaRepository;
import com.soutoMoney17.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	public Lancamento atualizar(Long codigo, Lancamento lancamento) {
		Lancamento lancamentoSalvo = this.lancamentoRepository.findById(codigo)
			      .orElseThrow(() -> new EmptyResultDataAccessException(1));

			  BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
		return lancamentoRepository.save(lancamentoSalvo);
	}

	public Lancamento salvar(@Valid Lancamento lancamento) {
		Pessoa pessoa = this.pessoaRepository.findById(lancamento.getPessoa().getCodigo())
				.orElseThrow(() -> new PessoaInexistenteOuInativaException());
		
		// AS LINHAS ABAIXO FORAM RETIRADAS PARA EXPERIMENTAR E ALTERAR AS RESPOSTAS DAS MENSAGENS NO POSTMAN
			    //  .orElseThrow(() -> new EmptyResultDataAccessException(1));
		
	    if (pessoa == null || pessoa.isInativo()) {
			throw  new PessoaInexistenteOuInativaException();
		}
			
		return lancamentoRepository.save(lancamento);
	}
	
//	
//	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
//		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
//		pessoaSalva.setAtivo(ativo);
//		lancamentoRepository.save(pessoaSalva);
//	}
//	
//	private Lancamento buscarPessoaPeloCodigo(Long codigo) {
//		Lancamento lancamentoSalvo = this.lancamentoRepository.findById(codigo)
//			      .orElseThrow(() -> new EmptyResultDataAccessException(1));
//		return lancamentoSalvo;
//	}


}
