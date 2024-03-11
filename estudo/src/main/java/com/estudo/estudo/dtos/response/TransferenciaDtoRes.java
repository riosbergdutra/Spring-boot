package com.estudo.estudo.dtos.response;

public record TransferenciaDtoRes(
    String remetenteEmail,
    String destinatarioEmail,
    double quantia
) {
    
}
