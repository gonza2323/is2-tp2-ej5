package ar.edu.uncuyo.dashboard.dto.vehiculo;

import ar.edu.uncuyo.dashboard.dto.IdentifiableDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoUpdateDto extends IdentifiableDto<Long> {
    @NotBlank(message = "Debe indicar la patente")
    @Size(max = 10, message = "Máximo 10 caracteres")
    private String patente;

    @NotBlank(message = "Debe indicar la marca")
    @Size(max = 30, message = "Máximo 30 caracteres")
    private String marca;

    @NotBlank(message = "Debe indicar el modelo")
    @Size(max = 30, message = "Máximo 30 caracteres")
    private String modelo;

    @NotNull(message = "Debe indicar el dueño")
    private Long clienteId;
}
