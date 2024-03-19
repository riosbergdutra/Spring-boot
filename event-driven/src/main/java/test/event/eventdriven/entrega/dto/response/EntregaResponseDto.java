package test.event.eventdriven.entrega.dto.response;

import test.event.eventdriven.entrega.enums.StatusPedido;

public record EntregaResponseDto(
    String endereco,
    StatusPedido StatusPedido
) {
    
}
