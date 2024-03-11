package com.estudo.estudo.dtos.request;

public record TransferenciaDtoReq(
     String remetenteEmail,
     String destinatarioEmail,
     double quantia
) {
    
}
