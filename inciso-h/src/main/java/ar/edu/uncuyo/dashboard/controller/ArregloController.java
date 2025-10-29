package ar.edu.uncuyo.dashboard.controller;

import ar.edu.uncuyo.dashboard.dto.historialArreglo.HistorialArregloCreateDto;
import ar.edu.uncuyo.dashboard.dto.historialArreglo.HistorialArregloDetailDto;
import ar.edu.uncuyo.dashboard.dto.historialArreglo.HistorialArregloSummaryDto;
import ar.edu.uncuyo.dashboard.dto.historialArreglo.HistorialArregloUpdateDto;
import ar.edu.uncuyo.dashboard.service.HistorialArregloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/arreglos")
public class ArregloController extends BaseController<
        Long,
        HistorialArregloDetailDto,
        HistorialArregloSummaryDto,
        HistorialArregloCreateDto,
        HistorialArregloUpdateDto,
        HistorialArregloService> {

    public ArregloController(HistorialArregloService service) {
        super(service, "arreglo", "arreglos");
    }
}
