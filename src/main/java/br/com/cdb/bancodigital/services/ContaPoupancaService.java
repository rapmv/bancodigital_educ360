package br.com.cdb.bancodigital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cdb.bancodigital.DTO.ContaPoupancaDTO;
import br.com.cdb.bancodigital.entities.ContaPoupanca;
import br.com.cdb.bancodigital.repositories.ContaPoupancaRepository;

@Service
public class ContaPoupancaService {
	
	@Autowired
	private ContaPoupancaRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ContaPoupancaDTO> findAllPaged(PageRequest pageRequest) {

		Page<ContaPoupanca> list = repository.findAll(pageRequest);

		return list.map(x -> new ContaPoupancaDTO(x));

	}

}
