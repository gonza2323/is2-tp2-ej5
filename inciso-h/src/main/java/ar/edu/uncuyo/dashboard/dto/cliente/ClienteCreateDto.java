package ar.edu.uncuyo.dashboard.dto.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteCreateDto {
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
