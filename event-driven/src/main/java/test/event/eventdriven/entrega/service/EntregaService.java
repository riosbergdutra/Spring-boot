package test.event.eventdriven.entrega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.event.eventdriven.entrega.dto.request.EntregaRequestDto;
import test.event.eventdriven.entrega.dto.response.EntregaResponseDto;
import test.event.eventdriven.entrega.entity.Entrega;
import test.event.eventdriven.entrega.enums.StatusPedido;
import test.event.eventdriven.entrega.repository.EntregaRepository;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    public EntregaResponseDto iniciarEntrega(EntregaRequestDto entregaDto) {
        entregaDto.StatusPedido();
        Entrega novaEntrega = new Entrega(
            null,
            entregaDto.id_pagamento(),
            entregaDto.endereco(),
            entregaDto.StatusPedido()
        );

        Entrega entregaSalva = entregaRepository.save(novaEntrega);

        return new EntregaResponseDto(entregaSalva.getEndereco(), entregaSalva.getStatusPedido());
    }

    public void processarMensagemSQS(String mensagemSQS) {
        try {
            String[] partes = mensagemSQS.split("\n");
            // Parse da mensagem SQS para extrair os dados relevantes
            Long idPagamento = Long.parseLong(partes[0].split(": ")[1]);
            String endereco = partes[2].split(": ")[1];
            
            // Criação da requisição de entrega
            EntregaRequestDto entregaDto = new EntregaRequestDto(null, idPagamento, endereco, StatusPedido.pendente);

            // Iniciar a entrega com base nos dados recebidos
            iniciarEntrega(entregaDto);
        } catch (Exception e) {
            // Tratamento de exceção adequado, se necessário
            e.printStackTrace();
        }
    }
}
