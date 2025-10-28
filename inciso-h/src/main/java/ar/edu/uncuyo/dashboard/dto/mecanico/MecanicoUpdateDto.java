package ar.edu.uncuyo.dashboard.dto.mecanico;

import ar.edu.uncuyo.dashboard.dto.IdentifiableDto;
import ar.edu.uncuyo.dashboard.dto.usuario.UsuarioUpdateDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MecanicoUpdateDto extends IdentifiableDto<Long> {
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 50, message = "Máximo 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(max = 50, message = "Máximo 50 caracteres")
    private String apellido;

    @NotBlank(message = "El legajo no puede estar vacío")
    @Size(max = 20, message = "Máximo 20 caracteres")
    private String legajo;

    @Valid
    private UsuarioUpdateDto usuario;
}
