package ar.edu.uncuyo.dashboard.controller;

import ar.edu.uncuyo.dashboard.dto.cliente.ClienteSummaryDto;
import ar.edu.uncuyo.dashboard.dto.vehiculo.VehiculoCreateDto;
import ar.edu.uncuyo.dashboard.dto.vehiculo.VehiculoDetailDto;
import ar.edu.uncuyo.dashboard.dto.vehiculo.VehiculoSummaryDto;
import ar.edu.uncuyo.dashboard.dto.vehiculo.VehiculoUpdateDto;
import ar.edu.uncuyo.dashboard.error.BusinessException;
import ar.edu.uncuyo.dashboard.facade.VehiculoFacade;
import ar.edu.uncuyo.dashboard.service.ClienteService;
import ar.edu.uncuyo.dashboard.service.VehiculoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    private final ClienteService clienteService;
    private final VehiculoFacade vehiculoFacade;

    public VehiculoController(VehiculoService service, ClienteService clienteService, VehiculoFacade vehiculoFacade) {
        super(service, "vehiculo", "vehiculos", Sort.by("patente"));
        this.clienteService = clienteService;
        this.vehiculoFacade = vehiculoFacade;
    }

    @Override
    @PostMapping("/{id}/baja")
    public String delete(Model model, @PathVariable Long id) {
        try {
            preDelete(id);
            vehiculoFacade.eliminarVehiculo(id);
            postDelete(id);
            return "redirect:" + listUrl;
        } catch (BusinessException e) {
            model.addAttribute("msgError", e.getMessage());
            return prepareListView(model);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("msgError", "Error de sistema");
            return prepareListView(model);
        }
    }

    private void loadClientes(Model model) {
        Sort sort = Sort.by(Sort.Direction.ASC, "dni");
        Page<ClienteSummaryDto> clientes = clienteService.findDtos(Pageable.unpaged(sort));
        model.addAttribute("clientes", clientes.getContent());
    }

    @Override
    protected void preDetailView(Model model, Long id) {
        loadClientes(model);
    }

    @Override
    protected void preCreateView(Model model) {
        loadClientes(model);
    }

    @Override
    protected void preEditView(Model model) {
        loadClientes(model);
    }
}
