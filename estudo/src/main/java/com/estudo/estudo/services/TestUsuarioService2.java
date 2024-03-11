package com.estudo.estudo.services;

import com.estudo.estudo.dtos.request.TransferenciaDtoReq;
import com.estudo.estudo.dtos.request.UsuarioDtoReq;
import com.estudo.estudo.dtos.request.UsuarioUpdateDtoReq;
import com.estudo.estudo.dtos.response.TransferenciaDtoRes;
import com.estudo.estudo.dtos.response.UsuarioDtoRes;
import com.estudo.estudo.dtos.response.UsuarioUpdateDtoRes;

public interface TestUsuarioService2 {
    UsuarioDtoRes criarUsuario2(UsuarioDtoReq usuarioDTO);
    TransferenciaDtoRes transferencia(TransferenciaDtoReq transferenciaDto);
    UsuarioUpdateDtoRes atualizarUsuario(Long id, UsuarioUpdateDtoReq usuarioUpdateDtoReq);
}
