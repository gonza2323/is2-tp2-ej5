package ar.edu.uncuyo.dashboard.dto.historialArreglo;

import ar.edu.uncuyo.dashboard.dto.IdentifiableDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class HistorialArregloDetailDto extends IdentifiableDto<Long> {
    private LocalDate fecha;
    private String detalle;

    private Long vehiculoId;
    private String vehiculoMarca;
    private String vehiculoModelo;
    private String vehiculoPatente;

    private Long clienteId;
    private String clienteDni;
    private String clienteNombre;
    private String clienteApellido;

    private Long mecanicoId;
    private String mecanicoLegajo;
    private String mecanicoNombre;
    private String mecanicoApellido;
}
