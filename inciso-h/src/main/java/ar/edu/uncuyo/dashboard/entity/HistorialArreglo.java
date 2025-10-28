package ar.edu.uncuyo.dashboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class HistorialArreglo extends BaseEntity<Long> {
    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private String detalle;

    @JoinColumn(nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    private Vehiculo vehiculo;

    @JoinColumn(nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    private Mecanico mecanico;
}
