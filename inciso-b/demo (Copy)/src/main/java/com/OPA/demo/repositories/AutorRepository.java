package com.OPA.demo.repositories;

import com.OPA.demo.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, String> {
}
