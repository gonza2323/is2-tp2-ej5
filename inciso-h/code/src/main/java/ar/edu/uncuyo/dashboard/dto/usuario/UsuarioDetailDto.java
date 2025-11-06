package ar.edu.uncuyo.dashboard.dto.usuario;

import ar.edu.uncuyo.dashboard.dto.IdentifiableDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDetailDto extends IdentifiableDto<Long> {
    private String email;
}
