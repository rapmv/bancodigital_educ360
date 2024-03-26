package br.com.cdb.bancodigital.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cdb.bancodigital.DTO.ClienteDTO;
import br.com.cdb.bancodigital.entities.Cliente;
import br.com.cdb.bancodigital.repositories.ClienteRepository;
import br.com.cdb.bancodigital.services.exceptions.DatabaseException;
import br.com.cdb.bancodigital.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Transactional(readOnly = true)
	public List<ClienteDTO> findAll() {

		List<Cliente> list = repository.findAll();

		return list.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());

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
		entity.setCpf(dto.getCpf());
		entity.setNome(dto.getNome());
		entity.setCategoria(dto.getCategoria());

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

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não existe" + id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException ("Violação de integridade");
		}
	}
	
}
