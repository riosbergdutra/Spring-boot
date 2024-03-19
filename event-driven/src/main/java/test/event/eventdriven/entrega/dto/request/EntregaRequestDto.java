package test.event.eventdriven.entrega.dto.request;

import test.event.eventdriven.entrega.enums.StatusPedido;

public record EntregaRequestDto(
    Long id_entrega,
    Long id_pagamento,
    String endereco,
    StatusPedido StatusPedido
) {
    
}
