package com.OPA.demo.controllers.api;

import com.OPA.demo.dto.ImagenRequest;
import com.OPA.demo.entities.Imagen;
import com.OPA.demo.services.ImagenService;
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
@RequestMapping("/api/imagenes")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class ImagenController {

    private final ImagenService imagenService;

    @GetMapping
    public ResponseEntity<List<Imagen>> listar() {
        return ResponseEntity.ok(imagenService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imagen> obtenerPorId(@PathVariable Long id) {
        return imagenService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Imagen> crear(@RequestBody ImagenRequest request) {
        Imagen imagen = imagenService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(imagen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imagen> actualizar(@PathVariable Long id, @RequestBody ImagenRequest request) {
        try {
            Imagen actualizada = imagenService.update(id, request);
            return ResponseEntity.ok(actualizada);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            imagenService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
