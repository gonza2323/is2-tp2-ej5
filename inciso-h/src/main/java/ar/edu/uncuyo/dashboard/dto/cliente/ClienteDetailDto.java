package ar.edu.uncuyo.dashboard.dto.cliente;

import ar.edu.uncuyo.dashboard.dto.IdentifiableDto;
import ar.edu.uncuyo.dashboard.dto.usuario.UsuarioDetailDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDetailDto extends IdentifiableDto<Long> {
    private String nombre;
    private String apellido;
    private String dni;
}
