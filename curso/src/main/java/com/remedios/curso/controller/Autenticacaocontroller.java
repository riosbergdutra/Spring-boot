package com.remedios.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedios.curso.infra.DadosTokenJWT;
import com.remedios.curso.infra.TokenService;
import com.remedios.usuarios.DadosAutenticacao;
import com.remedios.usuarios.usuario;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class Autenticacaocontroller {
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<DadosTokenJWT> EfetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
		var autentificacaoToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		var autentificacao = manager.authenticate(autentificacaoToken);
		var tokenJWT = tokenService.gerarToken((usuario) autentificacao.getPrincipal());
		
		return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
	}
}