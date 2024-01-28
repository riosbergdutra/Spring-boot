package com.remedios.curso.remedio;

import java.time.LocalDate;

public record DadosListagemRemedio( Long id,String nome, via via, String lote, laboratorio laboratorio, LocalDate validade ) {
    public DadosListagemRemedio(Remedios remedio){
        this(remedio.getId(),remedio.getNome(), remedio.getVia(), remedio.getLote(), remedio.getLaboratorio(), remedio.getValidade());
    }
} 
