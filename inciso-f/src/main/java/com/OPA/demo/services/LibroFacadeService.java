package com.OPA.demo.services;

import com.OPA.demo.entities.*;
import com.OPA.demo.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibroFacadeService {

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private final EditorialRepository editorialRepository;
    private final ImagenRepository imagenRepository;

    public LibroFacadeService(LibroRepository libroRepository,
                              AutorRepository autorRepository,
                              EditorialRepository editorialRepository,
                              ImagenRepository imagenRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
        this.editorialRepository = editorialRepository;
        this.imagenRepository = imagenRepository;
    }

    @Transactional
    public Libro registrarLibro(Libro libro, Long idAutor, Long idEditorial, Imagen imagen) {
        Autor autor = autorRepository.findById(String.valueOf(idAutor))
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        Editorial editorial = editorialRepository.findById(String.valueOf(idEditorial))
                .orElseThrow(() -> new RuntimeException("Editorial no encontrada"));

        libro.setAutor(autor);
        libro.setEditorial(editorial);

        if (imagen != null) {
            imagenRepository.save(imagen);
            libro.setImagen(imagen);
        }

        libro.setAlta(true);
        return libroRepository.save(libro);
    }
}
