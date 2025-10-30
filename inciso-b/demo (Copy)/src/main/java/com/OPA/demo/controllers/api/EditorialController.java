package com.OPA.demo.controllers.api;

import com.OPA.demo.entities.Editorial;
import com.OPA.demo.services.EditorialService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/editoriales")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class EditorialController {

    private final EditorialService editorialService;

    @GetMapping
    public ResponseEntity<List<Editorial>> listar() {
        return ResponseEntity.ok(editorialService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editorial> obtenerPorId(@PathVariable String id) {
        return editorialService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Editorial> crear(@RequestBody Editorial editorial) {
        Editorial nuevaEditorial = editorialService.save(editorial);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaEditorial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Editorial> actualizar(@PathVariable String id, @RequestBody Editorial editorial) {
        try {
            Editorial actualizada = editorialService.update(id, editorial);
            return ResponseEntity.ok(actualizada);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        try {
            editorialService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
