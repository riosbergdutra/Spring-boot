package com.estudo.estudo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.estudo.Model.Usuario;
import com.estudo.estudo.dtos.request.UsuarioDtoReq;
import com.estudo.estudo.dtos.response.UsuarioDtoRes;
import com.estudo.estudo.repository.UsuarioRepository;
import com.estudo.estudo.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDtoRes criarUsuario(UsuarioDtoReq usuarioDTO) {
        Usuario novoUsuario = new Usuario();

        if (usuarioDTO.nome() != null) {
            novoUsuario.setNome(usuarioDTO.nome());
        }
        if (usuarioDTO.quantia_dinheiro() != null) {
            novoUsuario.setQuantia_dinheiro(usuarioDTO.quantia_dinheiro());
        }
        if (usuarioDTO.senha() != null) {
            novoUsuario.setSenha((usuarioDTO.senha()));
        }
        if (usuarioDTO.email() != null) {
            novoUsuario.setEmail(usuarioDTO.email());
        }

        Usuario usuarioCriado = usuarioRepository.save(novoUsuario);

        return new UsuarioDtoRes(
            usuarioCriado.getNome(),
            usuarioCriado.getEmail(),
            usuarioCriado.getQuantia_dinheiro()
        );
    }
}