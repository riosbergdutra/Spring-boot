package io.spring.security.springsecurity.dtos;

public record UsuarioDto(
    String nome,
    String login,
    String senha
) {
}
