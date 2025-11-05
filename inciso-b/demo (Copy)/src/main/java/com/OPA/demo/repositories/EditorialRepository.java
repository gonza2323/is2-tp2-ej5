package com.OPA.demo.repositories;

import com.OPA.demo.entities.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorialRepository extends JpaRepository<Editorial, String> {
}
