package br.com.cdb.bancodigital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cdb.bancodigital.DTO.ContaDTO;
import br.com.cdb.bancodigital.entities.Conta;
import br.com.cdb.bancodigital.repositories.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ContaDTO> findAllPaged(PageRequest pageRequest) {

		Page<Conta> list = repository.findAll(pageRequest);

		return list.map(x -> new ContaDTO(x));

	}

}
