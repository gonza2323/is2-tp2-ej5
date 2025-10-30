package com.OPA.demo.services;

import com.OPA.demo.entities.Editorial;
import com.OPA.demo.repositories.EditorialRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EditorialService {

    private final EditorialRepository editorialRepository;

    public List<Editorial> findAll() {
        return editorialRepository.findAll();
    }

    public Optional<Editorial> findById(String id) {
        return editorialRepository.findById(id);
    }

    public Editorial save(Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    public Editorial update(String id, Editorial editorialData) {
        Editorial editorial = editorialRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Editorial no encontrada: " + id));

        editorial.setNombre(editorialData.getNombre());
        editorial.setAlta(editorialData.isAlta());

        return editorialRepository.save(editorial);
    }

    public void delete(String id) {
        if (!editorialRepository.existsById(id)) {
            throw new EntityNotFoundException("Editorial no encontrada: " + id);
        }
        editorialRepository.deleteById(id);
    }
}
