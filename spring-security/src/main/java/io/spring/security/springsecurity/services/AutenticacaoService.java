package io.spring.security.springsecurity.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import io.spring.security.springsecurity.dtos.AuthDto;

public interface AutenticacaoService  extends UserDetailsService{

    public String obterToken(AuthDto authDto);
    
    public String validaTokenJWT(String token);
}
