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
public class Mecanico extends Persona {
    @Column(nullable = false)
    private String legajo;

    @JoinColumn(nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    private Usuario usuario;
}
