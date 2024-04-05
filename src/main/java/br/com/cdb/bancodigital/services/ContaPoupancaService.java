package br.com.cdb.bancodigital.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.cdb.bancodigital.DTO.ContaPoupancaDTO;
import br.com.cdb.bancodigital.entities.Cliente;
import br.com.cdb.bancodigital.entities.ContaPoupanca;
import br.com.cdb.bancodigital.repositories.ContaPoupancaRepository;
import br.com.cdb.bancodigital.services.exceptions.DatabaseException;
import br.com.cdb.bancodigital.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ContaPoupancaService {
	
	@Autowired
	private ContaPoupancaRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ContaPoupancaDTO> findAllPaged(PageRequest pageRequest) {

		Page<ContaPoupanca> list = repository.findAll(pageRequest);

		return list.map(x -> new ContaPoupancaDTO(x));

	}
	
	@Transactional(readOnly = true)
	public ContaPoupancaDTO findById(Long id) {

		Optional<ContaPoupanca> obj = repository.findById(id);

		ContaPoupanca entity = obj.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));

		return new ContaPoupancaDTO(entity);
	}
	
	@Transactional
	public ContaPoupancaDTO insert(ContaPoupancaDTO dto) {

		ContaPoupanca entity = new ContaPoupanca();
		
		contaEntity(dto, entity);

	    entity = repository.save(entity);

	    return new ContaPoupancaDTO(entity);
	}
	
	@Transactional
	public ContaPoupancaDTO update(Long id, ContaPoupancaDTO dto) {
		
		try {
			ContaPoupanca entity = repository.getReferenceById(id);
		
			entity.setContaTipo(dto.getContaTipo());
			entity.setContaSaldo(dto.getContaSaldo());
			entity.setTaxaRendimento(dto.getTaxaRendimento());
	
			entity = repository.save(entity);
		
			return new ContaPoupancaDTO(entity);
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

	private void contaEntity(ContaPoupancaDTO dto, ContaPoupanca entity) {
		
		entity.setContaTipo(dto.getContaTipo());
		entity.setContaSaldo(dto.getContaSaldo());
		entity.setTaxaRendimento(dto.getTaxaRendimento());
		
		Cliente cliente = new Cliente();
		
		cliente.setId(dto.getClienteConta().getId());
		
	    cliente.setCpf(dto.getClienteConta().getCpf());
	    cliente.setNome(dto.getClienteConta().getNome());
	    cliente.setCategoria(dto.getClienteConta().getCategoria());
	    cliente.setDataNascimento(dto.getClienteConta().getDataNascimento());
	    cliente.setEndereco(dto.getClienteConta().getEndereco());
	    
	    entity.setClienteConta(cliente);
	}
	
}
