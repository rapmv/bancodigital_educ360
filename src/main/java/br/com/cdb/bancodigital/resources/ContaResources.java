package br.com.cdb.bancodigital.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdb.bancodigital.DTO.ContaDTO;
import br.com.cdb.bancodigital.services.ContaService;

@RestController
@RequestMapping(value = "/contas")
public class ContaResources {
	
	@Autowired
	private ContaService service;
	
	@GetMapping
	public ResponseEntity<Page<ContaDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "3") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "contaTipo") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),  orderBy);
		
		Page<ContaDTO> list = service.findAllPaged(pageRequest);

		return ResponseEntity.ok().body(list);
	}
	

}
