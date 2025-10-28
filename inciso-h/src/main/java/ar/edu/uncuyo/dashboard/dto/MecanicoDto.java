package ar.edu.uncuyo.dashboard.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MecanicoDto {
    private Long id;

    @NotBlank(message = "Debe indicar el CUIT")
    @Size(min = 11, max = 13, message = "El CUIT debe tener entre 11 y 13 dígitos")
    private String legajo;

    private String nombrePais;
    private String nombreProvincia;
}
