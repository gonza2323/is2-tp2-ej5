package com.OPA.demo.services;

import com.OPA.demo.entities.Autor;
import com.OPA.demo.repositories.AutorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public Optional<Autor> findById(Long id) {
        return autorRepository.findById(id);
    }

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor update(Long id, Autor autorData) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Autor no encontrado: " + id));

        autor.setNombre(autorData.getNombre());
        autor.setAlta(autorData.isAlta());

        return autorRepository.save(autor);
    }

    public void delete(Long id) {
        if (!autorRepository.existsById(id)) {
            throw new EntityNotFoundException("Autor no encontrado: " + id);
        }
        autorRepository.deleteById(id);
    }
}
