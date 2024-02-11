package io.spring.security.springsecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.security.springsecurity.dtos.UsuarioDto;
import io.spring.security.springsecurity.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    private UsuarioDto salvar(@RequestBody  UsuarioDto usuarioDto){
        return usuarioService.salvar(usuarioDto);   
    }
    @GetMapping
    private String getOk(){
        return "OK";
    }
}
