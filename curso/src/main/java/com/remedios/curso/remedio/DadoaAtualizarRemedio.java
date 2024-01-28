package com.remedios.curso.remedio;

import jakarta.validation.constraints.NotNull;

public record DadoaAtualizarRemedio(
    @NotNull
    Long id, 
    String nome, 
    via via,
    laboratorio laboratorio) {
}
