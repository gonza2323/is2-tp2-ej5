package ar.edu.uncuyo.dashboard.dto.mecanico;

import ar.edu.uncuyo.dashboard.dto.IdentifiableDto;
import ar.edu.uncuyo.dashboard.dto.usuario.UsuarioDetailDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MecanicoDetailDto extends IdentifiableDto<Long> {
    private String nombre;
    private String apellido;
    private String legajo;
    private UsuarioDetailDto usuario;
}
