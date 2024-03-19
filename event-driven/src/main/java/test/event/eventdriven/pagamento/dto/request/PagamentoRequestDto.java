package test.event.eventdriven.pagamento.dto.request;

public record PagamentoRequestDto(
    Long id_pagamento,
    double valor,
    String endereco
) {
    
}
