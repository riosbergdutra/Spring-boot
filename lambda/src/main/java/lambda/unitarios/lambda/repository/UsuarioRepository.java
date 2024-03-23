package lambda.unitarios.lambda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lambda.unitarios.lambda.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
