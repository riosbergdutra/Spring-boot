package com.remedios.curso.remedio;

import java.time.LocalDate;

public record DadosDetalhamentoRemedio(
    Long id,
     String nome, 
     via via, 
     String lote, 
     int quantidade, 
     LocalDate validade, 
     laboratorio laboratorio
) {

    public DadosDetalhamentoRemedio(Remedios remedio) {
        this(remedio.getId(),
        remedio.getNome(),
        remedio.getVia(), 
        remedio.getLote(), 
        remedio.getQuantidade(), 
        remedio.getValidade(), 
        remedio.getLaboratorio());
    };

}
