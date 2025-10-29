package ar.edu.uncuyo.dashboard.controller;

import ar.edu.uncuyo.dashboard.dto.cliente.ClienteCreateDto;
import ar.edu.uncuyo.dashboard.dto.cliente.ClienteDetailDto;
import ar.edu.uncuyo.dashboard.dto.cliente.ClienteSummaryDto;
import ar.edu.uncuyo.dashboard.dto.cliente.ClienteUpdateDto;
import ar.edu.uncuyo.dashboard.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/clientes")
public class ClienteController extends BaseController<
        Long,
        ClienteDetailDto,
        ClienteSummaryDto,
        ClienteCreateDto,
        ClienteUpdateDto,
        ClienteService> {

    public ClienteController(ClienteService service) {
        super(service, "cliente", "clientes");
    }
}
