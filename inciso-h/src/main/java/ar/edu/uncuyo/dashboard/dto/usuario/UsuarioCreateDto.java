package ar.edu.uncuyo.dashboard.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCreateDto {
    @NotBlank(message = "Debe indicar una dirección de correo")
    @Email(message = "Debe especificar un email válido")
    private String email;

    @NotEmpty(message = "Debe indicar una contraseña")
    @Size(min = 8, max = 255, message = "La contraseña debe tener entre 8 y 255 caracteres")
    private String clave;

    @NotEmpty(message = "Debe confirmar su contraseña")
    private String confirmacionClave;
}
