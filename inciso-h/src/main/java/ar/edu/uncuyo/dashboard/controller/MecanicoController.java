package ar.edu.uncuyo.dashboard.controller;

import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoCreateDto;
import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoDetailDto;
import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoSummaryDto;
import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoUpdateDto;
import ar.edu.uncuyo.dashboard.error.BusinessException;
import ar.edu.uncuyo.dashboard.service.MecanicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mecanicos")
@RequiredArgsConstructor
public class MecanicoController {

    private final MecanicoService mecanicoService;

    private final String vistaLista = "/mecanico/mecanicoLista";
    private final String vistaDetalle = "/mecanico/mecanicoDetalle";
    private final String vistaAlta = "/mecanico/mecanicoAlta";
    private final String vistaEdicion = "/mecanico/mecanicoEdit";
    private final String redirectLista = "/mecanicos";

    @GetMapping("")
    public String listarMecanicos(Model model, Pageable pageable) {
        return prepararVistaLista(model, pageable);
    }

    @GetMapping("/{id}")
    public String detalleMecanico(Model model, @PathVariable Long id) {
        MecanicoDetailDto mecanico = mecanicoService.findDto(id);
        model.addAttribute("mecanico", mecanico);
        return vistaDetalle;
    }

    @GetMapping("/alta")
    public String altaMecanico(Model model) {
        return prepararVistaFormularioAlta(model, new MecanicoCreateDto());
    }

    @GetMapping("/{id}/edit")
    public String modificarMecanico(Model model, @PathVariable Long id) {
        MecanicoDetailDto mecanico = mecanicoService.findDto(id);
        return prepararVistaFormularioEdicion(model, mecanico);
    }

    @PostMapping("/alta")
    public String altaMecanico(Model model, @Valid @ModelAttribute("mecanico") MecanicoCreateDto mecanicoDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return prepararVistaFormularioAlta(model, mecanicoDto);

        try {
            mecanicoService.create(mecanicoDto);
            return "redirect:" + redirectLista;
        } catch (BusinessException e) {
            model.addAttribute("msgError", e.getMessage());
            return prepararVistaFormularioAlta(model, mecanicoDto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("msgError", "Error de sistema");
            return prepararVistaFormularioAlta(model, mecanicoDto);
        }
    }

    @PostMapping("/edit")
    public String modificarMecanico(Model model, @Valid @ModelAttribute("mecanico") MecanicoUpdateDto mecanicoDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return prepararVistaFormularioEdicion(model, mecanicoDto);

        try {
            mecanicoService.update(mecanicoDto);
            return "redirect:" + redirectLista;
        } catch (BusinessException e) {
            model.addAttribute("msgError", e.getMessage());
            return prepararVistaFormularioEdicion(model, mecanicoDto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("msgError", "Error de sistema");
            return prepararVistaFormularioEdicion(model, mecanicoDto);
        }
    }

    @PostMapping("/{id}/baja")
    public String eliminarMecanico(Model model, @PathVariable Long id) {
        try {
            mecanicoService.delete(id);
            return "redirect:" + redirectLista;
        } catch (BusinessException e) {
            model.addAttribute("msgError", e.getMessage());
            return prepararVistaLista(model, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("msgError", "Error de sistema");
            return prepararVistaLista(model, null);
        }
    }

    private String prepararVistaLista(Model model, Pageable pageable) {
        Page<MecanicoSummaryDto> mecanicos = mecanicoService.findDtos(pageable);
        model.addAttribute("mecanicos", mecanicos);
        return vistaLista;
    }

    private String prepararVistaFormularioAlta(Model model, MecanicoCreateDto mecanico) {
        model.addAttribute("mecanico", mecanico);
        return vistaAlta;
    }

    private String prepararVistaFormularioEdicion(Model model, Object mecanico) {
        model.addAttribute("mecanico", mecanico);
        return vistaEdicion;
    }
}
