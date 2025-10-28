package ar.edu.uncuyo.dashboard.repository;

import ar.edu.uncuyo.dashboard.entity.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MecanicoRepository extends BaseRepository<Mecanico, Long> {
    boolean existsByLegajoAndEliminadoFalse(String legajo);
    boolean existsByLegajoAndIdNotAndEliminadoFalse(String legajo, Long id);

    Optional<Mecanico> findByUsuarioEmailAndEliminadoFalse(String email);

    List<Mecanico> findAllByEliminadoFalseOrderByApellidoAscNombreAsc();
}
