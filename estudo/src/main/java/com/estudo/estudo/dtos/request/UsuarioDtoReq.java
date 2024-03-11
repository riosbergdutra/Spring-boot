package com.estudo.estudo.dtos.request;

public record UsuarioDtoReq(
     Long id_usuario,
      String nome,
      String email,
      String senha,
      Double quantia_dinheiro
) {
    
}
