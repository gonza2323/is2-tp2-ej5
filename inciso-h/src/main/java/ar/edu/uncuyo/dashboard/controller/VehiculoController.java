package ar.edu.uncuyo.dashboard.controller;

import ar.edu.uncuyo.dashboard.dto.vehiculo.VehiculoCreateDto;
import ar.edu.uncuyo.dashboard.dto.vehiculo.VehiculoDetailDto;
import ar.edu.uncuyo.dashboard.dto.vehiculo.VehiculoSummaryDto;
import ar.edu.uncuyo.dashboard.dto.vehiculo.VehiculoUpdateDto;
import ar.edu.uncuyo.dashboard.service.VehiculoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/vehiculos")
public class VehiculoController extends BaseController<
        Long,
        VehiculoDetailDto,
        VehiculoSummaryDto,
        VehiculoCreateDto,
        VehiculoUpdateDto,
        VehiculoService> {

    public VehiculoController(VehiculoService service) {
        super(service, "vehiculo", "vehiculos");
    }
}
