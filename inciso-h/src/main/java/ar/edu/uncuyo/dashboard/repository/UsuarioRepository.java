package ar.edu.uncuyo.dashboard.repository;

import ar.edu.uncuyo.dashboard.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends BaseRepository<Usuario, Long> {
    boolean existsByEmailAndEliminadoFalse(String nombreUsuario);
    boolean existsByEmailAndIdNotAndEliminadoFalse(String email, Long id);

    Optional<Usuario> findByEmailAndEliminadoFalse(String email);
}
