package com.OPA.demo.services.search;

import com.OPA.demo.entities.Libro;

import java.util.List;

public interface LibroSearchStrategy {
    List<Libro> buscar(String criterio);
}
