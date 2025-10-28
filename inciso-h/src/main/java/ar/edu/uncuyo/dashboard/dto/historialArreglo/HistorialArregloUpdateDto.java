package ar.edu.uncuyo.dashboard.dto.historialArreglo;

import ar.edu.uncuyo.dashboard.dto.IdentifiableDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class HistorialArregloUpdateDto extends IdentifiableDto<Long> {
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
