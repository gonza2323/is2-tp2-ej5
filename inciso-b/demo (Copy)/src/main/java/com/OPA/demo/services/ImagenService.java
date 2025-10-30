package com.OPA.demo.services;

import com.OPA.demo.dto.ImagenRequest;
import com.OPA.demo.entities.Imagen;
import com.OPA.demo.entities.Libro;
import com.OPA.demo.repositories.ImagenRepository;
import com.OPA.demo.repositories.LibroRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImagenService {

    private final ImagenRepository imagenRepository;
    private final LibroRepository libroRepository;

    public List<Imagen> findAll() {
        return imagenRepository.findAll();
    }

    public Optional<Imagen> findById(Long id) {
        return imagenRepository.findById(id);
    }

    public Imagen create(ImagenRequest request) {
        Long libroIsbn = request.getLibroIsbn();
        if (libroIsbn == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ISBN del libro es obligatorio");
        }
        if (request.getUrl() == null || request.getUrl().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La URL de la imagen es obligatoria");
        }

        Libro libro = libroRepository.findById(libroIsbn)
                .orElseThrow(() -> new EntityNotFoundException("Libro no encontrado: " + request.getLibroIsbn()));

        Imagen imagen = Imagen.builder()
                .url(request.getUrl())
                .descripcion(request.getDescripcion())
                .libro(libro)
                .build();

        return imagenRepository.save(imagen);
    }

    public Imagen update(Long id, ImagenRequest request) {
        Imagen imagen = imagenRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Imagen no encontrada: " + id));

        Long libroIsbn = request.getLibroIsbn();
        if (libroIsbn == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ISBN del libro es obligatorio");
        }
        if (request.getUrl() == null || request.getUrl().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La URL de la imagen es obligatoria");
        }

        Libro libro = libroRepository.findById(libroIsbn)
                .orElseThrow(() -> new EntityNotFoundException("Libro no encontrado: " + request.getLibroIsbn()));

        imagen.setUrl(request.getUrl());
        imagen.setDescripcion(request.getDescripcion());
        imagen.setLibro(libro);

        return imagenRepository.save(imagen);
    }

    public void delete(Long id) {
        if (!imagenRepository.existsById(id)) {
            throw new EntityNotFoundException("Imagen no encontrada: " + id);
        }
        imagenRepository.deleteById(id);
    }
}
