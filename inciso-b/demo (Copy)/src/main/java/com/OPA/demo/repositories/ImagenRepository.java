package com.OPA.demo.repositories;

import com.OPA.demo.entities.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenRepository extends JpaRepository<Imagen, String> {
}
