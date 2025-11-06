package ar.edu.uncuyo.dashboard.repository;

import ar.edu.uncuyo.dashboard.entity.Vehiculo;

public interface VehiculoRepository extends BaseRepository<Vehiculo, Long> {
    boolean existsByPatenteAndEliminadoFalse(String patente);
    boolean existsByPatenteAndIdNotAndEliminadoFalse(String patente, Long id);
}
