package ar.edu.uncuyo.dashboard.dto.historialArreglo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistorialArregloCreateDto {
    @NotNull(message = "Debe indicar la fecha")
    @PastOrPresent(message = "La fecha no puede ser futura")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fecha = LocalDate.now();

    @NotBlank(message = "Debe indicar el detalle del arreglo")
    @Size(min = 5, max = 200, message = "Entre 5 y 200 caracteres")
    private String detalle;

    @NotNull(message = "Debe indicar el vehículo")
    private Long vehiculoId;

    @NotNull(message = "Debe indicar el mecánico que hizo el arreglo")
    private Long mecanicoId;
}
