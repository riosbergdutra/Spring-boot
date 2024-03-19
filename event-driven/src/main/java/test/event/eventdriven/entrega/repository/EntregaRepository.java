package test.event.eventdriven.entrega.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.event.eventdriven.entrega.entity.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
    
}
