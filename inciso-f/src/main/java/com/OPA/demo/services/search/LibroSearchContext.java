package com.OPA.demo.services.search;
import com.OPA.demo.entities.Libro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroSearchContext {

    private LibroSearchStrategy strategy;

    public void setStrategy(LibroSearchStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Libro> buscar(String criterio) {
        if (strategy == null)
            throw new IllegalStateException("No hay estrategia de búsqueda configurada");
        return strategy.buscar(criterio);
    }
}