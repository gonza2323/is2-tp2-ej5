package ar.edu.uncuyo.dashboard.dto.historialArreglo;

import ar.edu.uncuyo.dashboard.dto.IdentifiableDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class HistorialArregloSummaryDto extends IdentifiableDto<Long> {
    private LocalDate fecha;
    private String detalle;

    private Long vehiculoId;
    private String vehiculoPatente;

    private Long clienteId;
    private String clienteDni;

    private Long mecanicoId;
    private String mecanicoLegajo;
}
