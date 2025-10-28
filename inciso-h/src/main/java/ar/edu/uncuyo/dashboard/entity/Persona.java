package ar.edu.uncuyo.dashboard.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona extends BaseEntity<Long> {
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;
}
