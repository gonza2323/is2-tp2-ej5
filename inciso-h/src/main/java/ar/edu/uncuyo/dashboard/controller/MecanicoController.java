package ar.edu.uncuyo.dashboard.controller;

import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoCreateDto;
import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoDetailDto;
import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoSummaryDto;
import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoUpdateDto;
import ar.edu.uncuyo.dashboard.service.MecanicoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/mecanicos")
public class MecanicoController extends BaseController<
        Long,
        MecanicoDetailDto,
        MecanicoSummaryDto,
        MecanicoCreateDto,
        MecanicoUpdateDto,
        MecanicoService> {

    public MecanicoController(MecanicoService service) {
        super(service, "mecanico", "mecanicos");
    }
}
