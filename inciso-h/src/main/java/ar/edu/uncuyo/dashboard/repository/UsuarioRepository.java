package ar.edu.uncuyo.dashboard.repository;

import ar.edu.uncuyo.dashboard.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmailAndEliminadoFalse(String nombreUsuario);
    boolean existsByEmailAndIdNotAndEliminadoFalse(String correoElectronico, Long id);

    Optional<Usuario> findByIdAndEliminadoFalse(Long id);
    Optional<Usuario> findByEmailAndEliminadoFalse(String email);
}
