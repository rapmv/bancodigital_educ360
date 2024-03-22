package br.com.cdb.bancodigital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cdb.bancodigital.entities.Cliente;
import br.com.cdb.bancodigital.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}

}
