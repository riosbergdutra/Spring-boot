package com.estudo.estudo.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.estudo.Model.Usuario;
import com.estudo.estudo.dtos.request.TransferenciaDtoReq;
import com.estudo.estudo.dtos.request.UsuarioDtoReq;
import com.estudo.estudo.dtos.request.UsuarioUpdateDtoReq;
import com.estudo.estudo.dtos.response.TransferenciaDtoRes;
import com.estudo.estudo.dtos.response.UsuarioDtoRes;
import com.estudo.estudo.dtos.response.UsuarioUpdateDtoRes;
import com.estudo.estudo.repository.UsuarioRepository;
import com.estudo.estudo.services.TestUsuarioService2;
@Service
public class TestUsuarioServiceImpl2 implements TestUsuarioService2 {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDtoRes criarUsuario2(UsuarioDtoReq usuarioDto) {
        Usuario usuarioJaExiste = usuarioRepository.findByEmail(usuarioDto.email());
        if (usuarioJaExiste != null) {
            throw new RuntimeException("Usuário já existe!");
        }

        Usuario novoUsuario = new Usuario(
            null,
            usuarioDto.nome(),
            usuarioDto.email(),
            usuarioDto.senha(),
            usuarioDto.quantia_dinheiro()
        );

        Usuario usuarioCriado = usuarioRepository.save(novoUsuario);

        return new UsuarioDtoRes(
            usuarioCriado.getNome(),
            usuarioCriado.getEmail(),
            usuarioCriado.getQuantia_dinheiro()
        );
    }

    @Override
    public TransferenciaDtoRes transferencia(TransferenciaDtoReq transferenciaDto) {
        Usuario remetenteUsuario = usuarioRepository.findByEmail(transferenciaDto.remetenteEmail());
        Usuario destinatarioUsuario = usuarioRepository.findByEmail(transferenciaDto.destinatarioEmail());
    
        if (remetenteUsuario == null || destinatarioUsuario == null) {
            throw new RuntimeException("Usuário remetente ou destinatário não encontrado!");
        }
    
        if (remetenteUsuario.getQuantia_dinheiro() < transferenciaDto.quantia()) {
            throw new RuntimeException("Saldo insuficiente para realizar a transferência!");
        }
    
        remetenteUsuario.setQuantia_dinheiro(remetenteUsuario.getQuantia_dinheiro() - transferenciaDto.quantia());
        destinatarioUsuario.setQuantia_dinheiro(destinatarioUsuario.getQuantia_dinheiro() + transferenciaDto.quantia());
    
        usuarioRepository.save(remetenteUsuario);
        usuarioRepository.save(destinatarioUsuario);
    
        return new TransferenciaDtoRes(
            transferenciaDto.remetenteEmail(),
            transferenciaDto.destinatarioEmail(),
            transferenciaDto.quantia()
        );
    }

    public UsuarioUpdateDtoRes atualizarUsuario(Long id, UsuarioUpdateDtoReq usuarioUpdateDtoReq) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        
        if (optionalUsuario.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado!");
        }
    
        Usuario usuarioExistente = optionalUsuario.get();
    
        if (usuarioUpdateDtoReq.nome() != null) {
            usuarioExistente.setNome(usuarioUpdateDtoReq.nome());
        }
        
        if (usuarioUpdateDtoReq.email() != null) {
            usuarioExistente.setEmail(usuarioUpdateDtoReq.email());
        }
    
        if (usuarioUpdateDtoReq.senha() != null) {
            usuarioExistente.setSenha(usuarioUpdateDtoReq.senha());
        }
        
    
        usuarioRepository.save(usuarioExistente);
        
        return new UsuarioUpdateDtoRes(
            usuarioExistente.getNome(),
            usuarioExistente.getEmail(),
            usuarioExistente.getSenha()
        );
    }

    
}
