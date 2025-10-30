package com.OPA.demo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PrestamoRequest {

    private Long libroIsbn;
    private Long usuarioId;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean devuelto;
}
