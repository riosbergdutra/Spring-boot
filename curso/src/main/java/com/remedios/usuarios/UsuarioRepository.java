package com.remedios.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<usuario, Long> {

    UserDetails findByLogin(String login);

}
