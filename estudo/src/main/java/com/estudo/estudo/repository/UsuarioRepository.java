package com.estudo.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.estudo.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
