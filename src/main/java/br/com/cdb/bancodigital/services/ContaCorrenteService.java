package br.com.cdb.bancodigital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cdb.bancodigital.DTO.ContaCorrenteDTO;
import br.com.cdb.bancodigital.entities.ContaCorrente;
import br.com.cdb.bancodigital.repositories.ContaCorrenteRepository;

@Service
public class ContaCorrenteService {
	
	@Autowired
	private ContaCorrenteRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ContaCorrenteDTO> findAllPaged(PageRequest pageRequest) {

		Page<ContaCorrente> list = repository.findAll(pageRequest);

		return list.map(x -> new ContaCorrenteDTO(x));

	}

}
