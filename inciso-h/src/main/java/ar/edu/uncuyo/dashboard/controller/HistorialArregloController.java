package ar.edu.uncuyo.dashboard.controller;

import ar.edu.uncuyo.dashboard.dto.cliente.ClienteSummaryDto;
import ar.edu.uncuyo.dashboard.dto.historialArreglo.HistorialArregloCreateDto;
import ar.edu.uncuyo.dashboard.dto.historialArreglo.HistorialArregloDetailDto;
import ar.edu.uncuyo.dashboard.dto.historialArreglo.HistorialArregloSummaryDto;
import ar.edu.uncuyo.dashboard.dto.historialArreglo.HistorialArregloUpdateDto;
import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoSummaryDto;
import ar.edu.uncuyo.dashboard.dto.vehiculo.VehiculoSummaryDto;
import ar.edu.uncuyo.dashboard.service.ClienteService;
import ar.edu.uncuyo.dashboard.service.HistorialArregloService;
import ar.edu.uncuyo.dashboard.service.MecanicoService;
import ar.edu.uncuyo.dashboard.service.VehiculoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/arreglos")
public class HistorialArregloController extends BaseController<
        Long,
        HistorialArregloDetailDto,
        HistorialArregloSummaryDto,
        HistorialArregloCreateDto,
        HistorialArregloUpdateDto,
        HistorialArregloService> {

    private final MecanicoService mecanicoService;
    private final VehiculoService vehiculoService;

    public HistorialArregloController(HistorialArregloService service, MecanicoService mecanicoService, VehiculoService vehiculoService) {
        super(service, "arreglo", "arreglos", Sort.by(Sort.Direction.DESC, "fecha"));
        this.mecanicoService = mecanicoService;
        this.vehiculoService = vehiculoService;
    }

    private void loadVehiculos(Model model) {
        Sort sort = Sort.by(Sort.Direction.ASC, "patente");
        Page<VehiculoSummaryDto> vehiculos = vehiculoService.findDtos(Pageable.unpaged(sort));
        model.addAttribute("vehiculos", vehiculos.getContent());
    }

    private void loadMecanicos(Model model) {
        Sort sort = Sort.by(Sort.Direction.ASC, "legajo");
        Page<MecanicoSummaryDto> mecanicos = mecanicoService.findDtos(Pageable.unpaged(sort));
        model.addAttribute("mecanicos", mecanicos.getContent());
    }

    private void loadSelects(Model model) {
        loadVehiculos(model);
        loadMecanicos(model);
    }

    @Override
    protected void preDetailView(Model model, Long id) {
        loadSelects(model);
    }

    @Override
    protected void preCreateView(Model model) {
        loadSelects(model);
    }

    @Override
    protected void preEditView(Model model) {
        loadSelects(model);
    }
}
