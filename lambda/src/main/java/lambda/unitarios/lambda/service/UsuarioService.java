package lambda.unitarios.lambda.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lambda.unitarios.lambda.dto.req.UsuarioReqDto;
import lambda.unitarios.lambda.dto.res.UsuarioResDto;
import lambda.unitarios.lambda.model.Usuario;
import lambda.unitarios.lambda.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResDto createUsuarioService(UsuarioReqDto usuarioReqDto) {
        Usuario usuarioJaExiste = usuarioRepository.findByEmail(usuarioReqDto.email());
        if (usuarioJaExiste != null) {
            throw new RuntimeException("Usuário já existe!");
        }
        Usuario usuario = new Usuario(null, usuarioReqDto.nome(), usuarioReqDto.email(), usuarioReqDto.senha());

        Usuario novoUsuario = usuarioRepository.save(usuario);

        return new UsuarioResDto(
            novoUsuario.getNome(),
            novoUsuario.getEmail()
        );
    }

    public UsuarioResDto findUsuarioByIdService(Long userId) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(userId);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            return new UsuarioResDto(
                usuario.getNome(),
                usuario.getEmail()
            );
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }

    public List<UsuarioResDto> findAllUsuariosService() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResDto> usuariosDto = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuariosDto.add(new UsuarioResDto(
                usuario.getNome(),
                usuario.getEmail()
            ));
        }
        return usuariosDto;
    }

    public UsuarioResDto updateUsuarioService(Long userId, UsuarioReqDto usuarioReqDto) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(userId);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setNome(usuarioReqDto.nome());
            usuario.setEmail(usuarioReqDto.email());
            usuario.setSenha(usuarioReqDto.senha());

            Usuario usuarioAtualizado = usuarioRepository.save(usuario);

            return new UsuarioResDto(
                usuarioAtualizado.getNome(),
                usuarioAtualizado.getEmail()
            );
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }

    public void removeUsuarioService(Long userId) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(userId);
        if (optionalUsuario.isPresent()) {
            usuarioRepository.deleteById(userId);
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }
}
