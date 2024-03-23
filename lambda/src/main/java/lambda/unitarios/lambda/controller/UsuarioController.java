package lambda.unitarios.lambda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lambda.unitarios.lambda.dto.req.UsuarioReqDto;
import lambda.unitarios.lambda.dto.res.UsuarioResDto;
import lambda.unitarios.lambda.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResDto> createUsuario(@RequestBody UsuarioReqDto usuarioReqDto) {
        UsuarioResDto novoUsuario = usuarioService.createUsuarioService(usuarioReqDto);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResDto> findUsuarioById(@PathVariable("id") Long userId) {
        UsuarioResDto usuario = usuarioService.findUsuarioByIdService(userId);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResDto>> findAllUsuarios() {
        List<UsuarioResDto> usuarios = usuarioService.findAllUsuariosService();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResDto> updateUsuario(@PathVariable("id") Long userId, @RequestBody UsuarioReqDto usuarioReqDto) {
        UsuarioResDto usuarioAtualizado = usuarioService.updateUsuarioService(userId, usuarioReqDto);
        return new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeUsuario(@PathVariable("id") Long userId) {
        usuarioService.removeUsuarioService(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

