package ar.edu.uncuyo.dashboard.dto.historialArreglo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistorialArregloCreateDto {
    @NotNull(message = "Debe indicar la fecha")
    private LocalDate fecha;

    @NotBlank(message = "Debe indicar el detalle del arreglo")
    @Size(min = 5, max = 200, message = "Entre 5 y 200 caracteres")
    private String detalle;

    @NotNull(message = "Debe indicar el vehículo")
    private Long vehiculoId;

    @NotNull(message = "Debe indicar el mecánico que hizo el arreglo")
    private Long mecanicoId;
}
