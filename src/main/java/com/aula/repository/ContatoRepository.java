package com.aula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula.entities.Contato;



@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	
  List<Contato> findByEmail(String email);

}
