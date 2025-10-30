package com.OPA.demo.services;

import com.OPA.demo.dto.PrestamoRequest;
import com.OPA.demo.entities.Libro;
import com.OPA.demo.entities.Prestamo;
import com.OPA.demo.entities.UserEntity;
import com.OPA.demo.repositories.LibroRepository;
import com.OPA.demo.repositories.PrestamoRepository;
import com.OPA.demo.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final LibroRepository libroRepository;
    private final UserRepository userRepository;

    public List<Prestamo> findAll() {
        return prestamoRepository.findAll();
    }

    public Optional<Prestamo> findById(Long id) {
        return prestamoRepository.findById(id);
    }

    public Prestamo create(PrestamoRequest request) {
        Long libroIsbn = request.getLibroIsbn();
        Long usuarioId = request.getUsuarioId();

        if (libroIsbn == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ISBN del libro es obligatorio");
        }
        if (usuarioId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El id del usuario es obligatorio");
        }
        if (request.getFechaPrestamo() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La fecha de préstamo es obligatoria");
        }

        Libro libro = libroRepository.findById(libroIsbn)
                .orElseThrow(() -> new EntityNotFoundException("Libro no encontrado: " + request.getLibroIsbn()));

        UserEntity usuario = userRepository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + request.getUsuarioId()));

        Prestamo prestamo = Prestamo.builder()
                .fechaPrestamo(request.getFechaPrestamo())
                .fechaDevolucion(request.getFechaDevolucion())
                .devuelto(request.isDevuelto())
                .libro(libro)
                .usuario(usuario)
                .build();

        return prestamoRepository.save(prestamo);
    }

    public Prestamo update(Long id, PrestamoRequest request) {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Prestamo no encontrado: " + id));

        Long libroIsbn = request.getLibroIsbn();
        Long usuarioId = request.getUsuarioId();

        if (libroIsbn == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ISBN del libro es obligatorio");
        }
        if (usuarioId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El id del usuario es obligatorio");
        }
        if (request.getFechaPrestamo() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La fecha de préstamo es obligatoria");
        }

        Libro libro = libroRepository.findById(libroIsbn)
                .orElseThrow(() -> new EntityNotFoundException("Libro no encontrado: " + request.getLibroIsbn()));

        UserEntity usuario = userRepository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + request.getUsuarioId()));

        prestamo.setFechaPrestamo(request.getFechaPrestamo());
        prestamo.setFechaDevolucion(request.getFechaDevolucion());
        prestamo.setDevuelto(request.isDevuelto());
        prestamo.setLibro(libro);
        prestamo.setUsuario(usuario);

        return prestamoRepository.save(prestamo);
    }

    public void delete(Long id) {
        if (!prestamoRepository.existsById(id)) {
            throw new EntityNotFoundException("Prestamo no encontrado: " + id);
        }
        prestamoRepository.deleteById(id);
    }
}
