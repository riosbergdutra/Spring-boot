package com.estudo.estudo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.estudo.dtos.request.TransferenciaDtoReq;
import com.estudo.estudo.dtos.request.UsuarioDtoReq;
import com.estudo.estudo.dtos.request.UsuarioUpdateDtoReq;
import com.estudo.estudo.dtos.response.TransferenciaDtoRes;
import com.estudo.estudo.dtos.response.UsuarioDtoRes;
import com.estudo.estudo.dtos.response.UsuarioUpdateDtoRes;
import com.estudo.estudo.services.TestUsuarioService2;
import com.estudo.estudo.services.UsuarioService;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TestUsuarioService2 usuarioService2;

    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioDtoRes> criarUsuario(@RequestBody UsuarioDtoReq usuarioDtoReq) {
        UsuarioDtoRes usuarioCriado = usuarioService.criarUsuario(usuarioDtoReq);
        return new ResponseEntity<>(usuarioCriado, HttpStatus.CREATED);
    }
    @PostMapping("test/usuarios")
    public ResponseEntity<UsuarioDtoRes> criarUsuario2(@RequestBody UsuarioDtoReq usuarioDtoReq) {
        UsuarioDtoRes usuarioCriado = usuarioService2.criarUsuario2(usuarioDtoReq);
        return new ResponseEntity<>(usuarioCriado, HttpStatus.CREATED);
    }

    @PostMapping("/transferencia")
public ResponseEntity<TransferenciaDtoRes> transferencia(@RequestBody TransferenciaDtoReq transferenciaDto) {
    TransferenciaDtoRes responseDto = usuarioService2.transferencia(transferenciaDto);
    return new ResponseEntity<>(responseDto, HttpStatus.OK);
}

@PostMapping("/usuarios/{id}")
public ResponseEntity<UsuarioUpdateDtoRes> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioUpdateDtoReq usuarioUpdateDtoReq) {
    UsuarioUpdateDtoRes usuarioAtualizado = usuarioService2.atualizarUsuario(id, usuarioUpdateDtoReq);
    return ResponseEntity.ok(usuarioAtualizado);
}

}
