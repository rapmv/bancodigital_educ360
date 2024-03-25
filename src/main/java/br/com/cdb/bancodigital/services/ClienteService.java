package br.com.cdb.bancodigital.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cdb.bancodigital.DTO.ClienteDTO;
import br.com.cdb.bancodigital.entities.Cliente;
import br.com.cdb.bancodigital.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClienteDTO> findAll(){
		
		List<Cliente> list = repository.findAll();
		
		return list.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());

	}

}
