package com.estudo.estudo.services;

import com.estudo.estudo.dtos.request.UsuarioDtoReq;
import com.estudo.estudo.dtos.response.UsuarioDtoRes;

public interface UsuarioService {
    UsuarioDtoRes criarUsuario(UsuarioDtoReq usuarioDTO);

}
