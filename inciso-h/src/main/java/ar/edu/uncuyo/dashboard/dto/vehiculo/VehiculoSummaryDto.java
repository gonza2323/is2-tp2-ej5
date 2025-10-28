package ar.edu.uncuyo.dashboard.dto.vehiculo;

import ar.edu.uncuyo.dashboard.dto.IdentifiableDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoSummaryDto extends IdentifiableDto<Long> {
    private String patente;
    private String marca;
    private String modelo;

    private Long clienteId;
    private String clienteDni;
}
