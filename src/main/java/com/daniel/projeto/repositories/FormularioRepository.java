package com.daniel.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.projeto.entities.Formulario;

@Repository
public interface FormularioRepository extends JpaRepository<Formulario, Long>{

}
