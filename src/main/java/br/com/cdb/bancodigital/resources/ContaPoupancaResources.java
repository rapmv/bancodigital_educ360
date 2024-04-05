package br.com.cdb.bancodigital.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cdb.bancodigital.DTO.ContaCorrenteDTO;
import br.com.cdb.bancodigital.DTO.ContaPoupancaDTO;
import br.com.cdb.bancodigital.services.ContaPoupancaService;

@RestController
@RequestMapping(value= "/contapoupancas")
public class ContaPoupancaResources {
	
	@Autowired
	private ContaPoupancaService service;
	
	@GetMapping
	public ResponseEntity<Page<ContaPoupancaDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "3") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "contaId") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),  orderBy);
		
		Page<ContaPoupancaDTO> list = service.findAllPaged(pageRequest);

		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ContaPoupancaDTO> findById(@PathVariable Long id){

		ContaPoupancaDTO dto = service.findById(id);	
		
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<ContaPoupancaDTO> insert(@RequestBody ContaPoupancaDTO dto){
		
		dto = service.insert(dto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(dto.getContaId()).toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ContaPoupancaDTO> update(@PathVariable Long id, @RequestBody ContaPoupancaDTO dto){
		
		dto = service.update(id, dto);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
