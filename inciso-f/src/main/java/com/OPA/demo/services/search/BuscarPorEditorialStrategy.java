package com.OPA.demo.services.search;

import com.OPA.demo.entities.Libro;
import com.OPA.demo.repositories.LibroRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscarPorEditorialStrategy implements LibroSearchStrategy {

    private final LibroRepository libroRepository;

    public BuscarPorEditorialStrategy(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> buscar(String editorialNombre) {
        return libroRepository.findByEditorialNombreContainingIgnoreCase(editorialNombre);
    }
}