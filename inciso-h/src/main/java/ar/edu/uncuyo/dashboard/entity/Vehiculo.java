package ar.edu.uncuyo.dashboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo extends BaseEntity<Long> {
    @Column(nullable = false)
    private String patente;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @JoinColumn(nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    private Cliente cliente;
}
