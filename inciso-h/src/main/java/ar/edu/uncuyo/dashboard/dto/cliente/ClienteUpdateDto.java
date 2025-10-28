package ar.edu.uncuyo.dashboard.dto.cliente;

import ar.edu.uncuyo.dashboard.dto.IdentifiableDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteUpdateDto extends IdentifiableDto<Long> {
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 50, message = "Máximo 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(max = 50, message = "Máximo 50 caracteres")
    private String apellido;

    @NotBlank(message = "El documento no puede estar vacío")
    @Size(max = 20, message = "Máximo 20 caracteres")
    private String dni;
}
