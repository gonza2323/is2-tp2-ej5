package com.OPA.demo.services.search;

import com.OPA.demo.entities.Libro;
import com.OPA.demo.repositories.LibroRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscarPorAnioStrategy implements LibroSearchStrategy {

    private final LibroRepository libroRepository;

    public BuscarPorAnioStrategy(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> buscar(String anio) {
        return libroRepository.findByAnio(Integer.parseInt(anio));
    }
}