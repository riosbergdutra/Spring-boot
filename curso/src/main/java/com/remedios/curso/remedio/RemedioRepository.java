package com.remedios.curso.remedio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedioRepository extends JpaRepository<Remedios, Long> {

    List<Remedios> findAllByAtivoTrue();

    
} 
