package br.com.cdb.bancodigital.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdb.bancodigital.entities.Cliente;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResources {

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		
		List<Cliente> list = new ArrayList<>();
		
		//id, cpf, nome, categoria, dataNascimento
		list.add(new Cliente(1L, "111", "raphael", "super"));
		list.add(new Cliente(2L, "222", "jorge", "premium"));
		
		return ResponseEntity.ok().body(list);
	}
	
}
