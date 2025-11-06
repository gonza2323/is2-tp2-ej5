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
public class MecanicoSummaryDto extends IdentifiableDto<Long> {
    private String nombre;
    private String apellido;
    private String legajo;
    private String email;
}
