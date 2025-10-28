package ar.edu.uncuyo.dashboard.dto.usuario;

import ar.edu.uncuyo.dashboard.dto.IdentifiableDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioUpdateDto extends IdentifiableDto<Long> {
    @NotBlank(message = "Debe indicar una dirección de correo")
    @Email(message = "Debe especificar un email válido")
    private String email;
}
