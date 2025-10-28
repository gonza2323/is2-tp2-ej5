package ar.edu.uncuyo.dashboard.repository;

import ar.edu.uncuyo.dashboard.entity.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {
    Optional<Mecanico> findByIdAndEliminadoFalse(Long id);

    Optional<Mecanico> findByUsuarioEmailAndEliminadoFalse(String email);

    List<Mecanico> findByEliminadoFalse();

    List<Mecanico> findAllByEliminadoFalseOrderByApellidoAscNombreAsc();
}
