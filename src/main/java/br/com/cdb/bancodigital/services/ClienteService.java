package br.com.cdb.bancodigital.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.cdb.bancodigital.DTO.ClienteDTO;
import br.com.cdb.bancodigital.entities.Cliente;
import br.com.cdb.bancodigital.entities.Endereco;
import br.com.cdb.bancodigital.repositories.ClienteRepository;
import br.com.cdb.bancodigital.services.exceptions.DatabaseException;
import br.com.cdb.bancodigital.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Transactional(readOnly = true)
	public Page<ClienteDTO> findAllPaged(PageRequest pageRequest) {

		Page<Cliente> list = repository.findAll(pageRequest);

		return list.map(x -> new ClienteDTO(x));

	}

	@Transactional(readOnly = true)
	public ClienteDTO findById(Long id) {

		Optional<Cliente> obj = repository.findById(id);

		Cliente entity = obj.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));

		return new ClienteDTO(entity);
	}

	@Transactional
	public ClienteDTO insert(ClienteDTO dto) {

		Cliente entity = new Cliente();
		Endereco endereco = new Endereco();
		
		entity.setCpf(dto.getCpf());
		entity.setNome(dto.getNome());
		entity.setCategoria(dto.getCategoria());
		entity.setEndereco(null)
		

		entity = repository.save(entity);

		return new ClienteDTO(entity);
	}

	@Transactional
	public ClienteDTO update(Long id, ClienteDTO dto) {
		
		try {
			Cliente entity = repository.getReferenceById(id);
		
			entity.setCpf(dto.getCpf());
			entity.setNome(dto.getNome());
			entity.setCategoria(dto.getCategoria());
		
			entity = repository.save(entity);
		
			return new ClienteDTO(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException ("id não existe" + id);
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if(!repository.existsById(id)) {
			throw new ResourceNotFoundException("Id não encontrado");
		}
		try {
			repository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade");
		}
	}
	
}
