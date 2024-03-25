package br.com.cdb.bancodigital.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdb.bancodigital.DTO.ClienteDTO;
import br.com.cdb.bancodigital.entities.Cliente;
import br.com.cdb.bancodigital.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResources {
	
	@Autowired
	private ClienteService service;

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll(){
		
		List<ClienteDTO> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	
}
