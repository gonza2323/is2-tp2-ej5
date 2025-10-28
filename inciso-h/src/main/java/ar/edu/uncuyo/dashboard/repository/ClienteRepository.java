package ar.edu.uncuyo.dashboard.repository;

import ar.edu.uncuyo.dashboard.entity.Cliente;

import java.util.Optional;

public interface ClienteRepository extends BaseRepository<Cliente, Long> {
    boolean existsByDniAndEliminadoFalse(String dni);
    boolean existsByDniAndIdNotAndEliminadoFalse(String dni, Long id);
}
