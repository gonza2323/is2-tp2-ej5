package com.OPA.demo.services;

import com.OPA.demo.entities.Libro;
import com.OPA.demo.repositories.LibroRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibroService {

    private final LibroRepository libroRepository;

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public Optional<Libro> findByIsbn(Long isbn) {
        return libroRepository.findById(isbn);
    }

    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro update(Long isbn, Libro libroData) {
        Libro libro = libroRepository.findById(isbn)
                .orElseThrow(() -> new EntityNotFoundException("Libro no encontrado: " + isbn));

        libro.setTitulo(libroData.getTitulo());
        libro.setAnio(libroData.getAnio());
        libro.setEjemplares(libroData.getEjemplares());
        libro.setEjemplaresPrestados(libroData.getEjemplaresPrestados());
        libro.setEjemplaresRestantes(libroData.getEjemplaresRestantes());
        libro.setAlta(libroData.isAlta());
        libro.setAutor(libroData.getAutor());
        libro.setEditorial(libroData.getEditorial());

        return libroRepository.save(libro);
    }

    public void delete(Long isbn) {
        if (!libroRepository.existsById(isbn)) {
            throw new EntityNotFoundException("Libro no encontrado: " + isbn);
        }
        libroRepository.deleteById(isbn);
    }
}
