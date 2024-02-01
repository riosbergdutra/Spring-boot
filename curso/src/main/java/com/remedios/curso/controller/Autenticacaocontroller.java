package com.remedios.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedios.curso.infra.tokenservice;
import com.remedios.usuarios.DadosAutenticacao;
import com.remedios.usuarios.usuario;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class Autenticacaocontroller {

    @Autowired
    private tokenservice tokenservice;

    @Autowired
    private AuthenticationManager menager;
    @PostMapping
    public ResponseEntity<?> efetuarlogin(@RequestBody @Valid DadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var autenticacao = menager.authenticate(token);

        return ResponseEntity.ok(tokenservice.gerarToken((usuario) autenticacao.getPrincipal()));
    }
}
