package test.event.eventdriven.pagamento.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.event.eventdriven.pagamento.entity.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    
}
