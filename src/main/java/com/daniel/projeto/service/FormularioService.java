package com.daniel.projeto.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.projeto.entities.Formulario;
import com.daniel.projeto.repositories.FormularioRepository;

@Service
public class FormularioService {
	
	@Autowired
	private FormularioRepository formularioRepository;
	
	public List<Formulario> findAll() {
		return formularioRepository.findAll();
		
	}
	
	public Formulario buscar(Long id) {
		Optional<Formulario> form = formularioRepository.findById(id);
		
		return form.orElseThrow(() -> new ObjectNotFoundException(
				"formulario não encontrato! Id: " + id + ", Tipo: " + Formulario.class.getName(), null));
	}
	
	public Formulario save(Formulario form) {
		return formularioRepository.save(form);
	}

}
