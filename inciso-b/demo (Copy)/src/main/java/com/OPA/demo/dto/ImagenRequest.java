package com.OPA.demo.dto;

import lombok.Data;

@Data
public class ImagenRequest {

    private String url;
    private String descripcion;
    private Long libroIsbn;
}
