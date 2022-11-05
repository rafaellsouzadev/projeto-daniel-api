package com.daniel.projeto.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.daniel.projeto.entities.Formulario;
import com.daniel.projeto.service.FormularioService;

@RestController
@RequestMapping("/formularios")
public class FormularioController {
	
	@Autowired
	private FormularioService formularioService;
	
	
	@GetMapping
	public ResponseEntity<List<Formulario>> buscarTodos() {
		List<Formulario> form = formularioService.findAll();		
		return ResponseEntity.ok().body(form);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Formulario> buscar(Long id) {
		Formulario form = formularioService.buscar(id);		
		return ResponseEntity.ok().body(form);
	}
	
	@PostMapping
	public ResponseEntity<Formulario> salvar(@RequestBody Formulario form) {
		Formulario formSalva = formularioService.save(form);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(formSalva.getId()).toUri();
		
		return ResponseEntity.created(uri).body(formSalva);
	}

}
