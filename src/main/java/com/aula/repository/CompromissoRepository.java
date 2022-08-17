package com.aula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aula.entities.Compromisso;

public interface CompromissoRepository extends JpaRepository<Compromisso, Long>{
     @Query("select cp from  Compromisso cp,  Contato ct where cp.contato= ct.id  and ct.nome=?1")
     List<Compromisso> consultaCompromissosPorNomeContato(String nome);
}
