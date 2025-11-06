package ar.edu.uncuyo.dashboard.repository;

import ar.edu.uncuyo.dashboard.entity.HistorialArreglo;
import ar.edu.uncuyo.dashboard.entity.Mecanico;
import ar.edu.uncuyo.dashboard.entity.Vehiculo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistorialArregloRepository extends BaseRepository<HistorialArreglo, Long> {
    List<HistorialArreglo> findAllByVehiculoAndEliminadoFalse(Vehiculo vehiculo);
}
