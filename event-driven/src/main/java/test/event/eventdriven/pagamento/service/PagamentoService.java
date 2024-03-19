package test.event.eventdriven.pagamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import test.event.eventdriven.pagamento.dto.request.PagamentoRequestDto;
import test.event.eventdriven.pagamento.dto.response.PagamentoResponseDto;
import test.event.eventdriven.pagamento.entity.Pagamento;
import test.event.eventdriven.pagamento.respository.PagamentoRepository;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private SqsTemplate sqsTemplate;

    public PagamentoResponseDto processarPagamento(PagamentoRequestDto pagamentoDto) {
        Pagamento novoPagamento = new Pagamento(
            null,
            pagamentoDto.valor(),
            pagamentoDto.endereco()
        );

        Pagamento pagamentoSalvo = pagamentoRepository.save(novoPagamento);

        // Envie a mensagem para a fila SQS com texto simples
        String queueUrl = "http://localhost:4566/000000000000/payments";
        String messageBody = "ID do Pagamento: " + pagamentoSalvo.getId_pagamento() + "\n" +
                     "Valor: " + pagamentoSalvo.getValor() + "\n" +
                     "Endereço: " + pagamentoSalvo.getEndereco();
sqsTemplate.send(queueUrl, messageBody);


        PagamentoResponseDto responseDto = new PagamentoResponseDto(
            pagamentoSalvo.getValor(),
            pagamentoSalvo.getEndereco()
        );
        return responseDto;
    }
}
