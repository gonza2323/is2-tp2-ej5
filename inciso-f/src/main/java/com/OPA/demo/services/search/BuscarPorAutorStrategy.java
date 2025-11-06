package com.OPA.demo.services.search;

import com.OPA.demo.entities.Libro;
import com.OPA.demo.repositories.LibroRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscarPorAutorStrategy implements LibroSearchStrategy {

    private final LibroRepository libroRepository;

    public BuscarPorAutorStrategy(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> buscar(String autorNombre) {
        return libroRepository.findByAutorNombreContainingIgnoreCase(autorNombre);
    }
}