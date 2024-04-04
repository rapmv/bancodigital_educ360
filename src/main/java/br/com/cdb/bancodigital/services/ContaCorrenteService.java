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
import br.com.cdb.bancodigital.DTO.ContaCorrenteDTO;
import br.com.cdb.bancodigital.entities.Cliente;
import br.com.cdb.bancodigital.entities.ContaCorrente;
import br.com.cdb.bancodigital.repositories.ContaCorrenteRepository;
import br.com.cdb.bancodigital.services.exceptions.DatabaseException;
import br.com.cdb.bancodigital.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ContaCorrenteService {
	
	@Autowired
	private ContaCorrenteRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ContaCorrenteDTO> findAllPaged(PageRequest pageRequest) {

		Page<ContaCorrente> list = repository.findAll(pageRequest);

		return list.map(x -> new ContaCorrenteDTO(x));

	}
	
	@Transactional(readOnly = true)
	public ContaCorrenteDTO findById(Long id) {

		Optional<ContaCorrente> obj = repository.findById(id);

		ContaCorrente entity = obj.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));

		return new ContaCorrenteDTO(entity);
	}
	
	@Transactional
	public ContaCorrenteDTO insert(ContaCorrenteDTO dto) {

		ContaCorrente entity = new ContaCorrente();
		
		entity.setContaTipo(dto.getContaTipo());
		entity.setContaSaldo(dto.getContaSaldo());
		entity.setTaxaMensal(dto.getTaxaMensal());
		
		Cliente cliente = new Cliente();
		
		cliente.setId(dto.getClienteConta().getId());
		
	    cliente.setCpf(dto.getClienteConta().getCpf());
	    cliente.setNome(dto.getClienteConta().getNome());
	    cliente.setCategoria(dto.getClienteConta().getCategoria());
	    cliente.setDataNascimento(dto.getClienteConta().getDataNascimento());
	    cliente.setEndereco(dto.getClienteConta().getEndereco());
	    
	    entity.setClienteConta(cliente);

	    entity = repository.save(entity);

	    return new ContaCorrenteDTO(entity);
	}
	
	@Transactional
	public ContaCorrenteDTO update(Long id, ContaCorrenteDTO dto) {
		
		try {
			ContaCorrente entity = repository.getReferenceById(id);
		
			entity.setContaTipo(dto.getContaTipo());
			entity.setContaSaldo(dto.getContaSaldo());
			entity.setTaxaMensal(dto.getTaxaMensal());
	
			entity = repository.save(entity);
		
			return new ContaCorrenteDTO(entity);
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
