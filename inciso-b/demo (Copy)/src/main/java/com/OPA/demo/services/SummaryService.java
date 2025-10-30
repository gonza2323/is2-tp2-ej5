package com.OPA.demo.services;

import com.OPA.demo.repositories.AutorRepository;
import com.OPA.demo.repositories.EditorialRepository;
import com.OPA.demo.repositories.ImagenRepository;
import com.OPA.demo.repositories.LibroRepository;
import com.OPA.demo.repositories.PrestamoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SummaryService {

    private final AutorRepository autorRepository;
    private final EditorialRepository editorialRepository;
    private final LibroRepository libroRepository;
    private final PrestamoRepository prestamoRepository;
    private final ImagenRepository imagenRepository;

    public Map<String, Object> buildSummary() {
        Map<String, Object> summary = new LinkedHashMap<>();
        summary.put("timestamp", Instant.now().toString());
        summary.put("autores", autorRepository.count());
        summary.put("editoriales", editorialRepository.count());
        summary.put("libros", libroRepository.count());
        summary.put("prestamos", prestamoRepository.count());
        summary.put("imagenes", imagenRepository.count());
        return summary;
    }
}
