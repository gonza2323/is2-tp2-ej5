package ar.edu.uncuyo.dashboard.dto.cliente;

import ar.edu.uncuyo.dashboard.dto.IdentifiableDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteSummaryDto extends IdentifiableDto<Long> {
    private String nombre;
    private String apellido;
    private String dni;
}
