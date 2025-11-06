package com.OPA.demo.repositories;

import com.OPA.demo.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, String> {

    boolean existsByIsbn(Long isbn);

    List<Libro> findByAutorNombreContainingIgnoreCase(String autorNombre);

    List<Libro> findByEditorialNombreContainingIgnoreCase(String editorialNombre);

    List<Libro> findByAnio(int i);
}
