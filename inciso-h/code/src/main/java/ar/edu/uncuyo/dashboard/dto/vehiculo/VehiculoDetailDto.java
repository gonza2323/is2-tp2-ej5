package ar.edu.uncuyo.dashboard.dto.vehiculo;

import ar.edu.uncuyo.dashboard.dto.IdentifiableDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class VehiculoDetailDto extends IdentifiableDto<Long> {
    private String patente;
    private String marca;
    private String modelo;

    private Long clienteId;
    private String clienteNombre;
    private String clienteApellido;
    private String clienteDni;
}
