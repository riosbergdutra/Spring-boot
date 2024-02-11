package io.spring.security.springsecurity.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.spring.security.springsecurity.dtos.UsuarioDto;
import io.spring.security.springsecurity.models.Usuario;
import io.spring.security.springsecurity.repositories.UsuarioRepository;
import io.spring.security.springsecurity.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UsuarioDto salvar(UsuarioDto usuarioDto){

        Usuario usuarioJaExiste = usuarioRepository.findByLogin(usuarioDto.login());

        if (usuarioJaExiste != null) {
            throw new RuntimeException("Usuario Ja existe!");
        }

        var passwordHash = passwordEncoder.encode(usuarioDto.senha());

        Usuario entity = new Usuario(usuarioDto.nome(),usuarioDto.login(), passwordHash);  

        Usuario novoUsuario = usuarioRepository.save(entity);

        return new UsuarioDto(novoUsuario.getNome(), novoUsuario.getLogin(), novoUsuario.getSenha());
    }
}
