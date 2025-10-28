package ar.edu.uncuyo.dashboard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
//
//    private final MecanicoService mecanicoService;
//
//    private final String vistaLista = "/usuario/usuarioLista";
//    private final String vistaDetalle = "/usuario/usuarioDetalle";
//    private final String vistaAlta = "/usuario/usuarioAlta";
//    private final String vistaEdicion = "/usuario/usuarioEdit";
//    private final String redirectLista = "/usuarios";
//
//    @GetMapping("")
//    public String listarUsuarios(Model model) {
//        return prepararVistaLista(model);
//    }
//
//    @GetMapping("/{id}")
//    public String detalleUsuario(Model model, @PathVariable Long id) {
//        UsuarioDto usuario = mecanicoService.buscarMecanico(id);
//        model.addAttribute("usuario", usuario);
//        return vistaDetalle;
//    }
//
//    @GetMapping("/alta")
//    public String altaUsuario(Model model) {
//        return prepararVistaFormularioAlta(model, new UsuarioCreateFormDto());
//    }
//
//    @GetMapping("/{id}/edit")
//    public String modificarUsuario(Model model, @PathVariable Long id) {
//        UsuarioDto usuario = mecanicoService.buscarUsuarioDto(id);
//        return prepararVistaFormularioEdicion(model, usuario);
//    }
//
//    @PostMapping("/alta")
//    public String altaUsuario(Model model, @Valid @ModelAttribute("usuario") UsuarioCreateFormDto usuarioDto, BindingResult bindingResult) {
//        if (bindingResult.hasErrors())
//            return prepararVistaFormularioAlta(model, usuarioDto);
//
//        try {
//            mecanicoService.crearUsuario(usuarioDto);
//            return "redirect:" + redirectLista;
//        } catch (BusinessException e) {
//            model.addAttribute("msgError", e.getMessage());
//            return prepararVistaFormularioAlta(model, usuarioDto);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            model.addAttribute("msgError", "Error de sistema");
//            return prepararVistaFormularioAlta(model, usuarioDto);
//        }
//    }
//
//    @PostMapping("/edit")
//    public String modificarUsuario(Model model, @Valid @ModelAttribute("usuario") UsuarioDto usuarioDto, BindingResult bindingResult) {
//        if (bindingResult.hasErrors())
//            return prepararVistaFormularioEdicion(model, usuarioDto);
//
//        try {
//            mecanicoService.modificarUsuario(usuarioDto);
//            return "redirect:" + redirectLista;
//        } catch (BusinessException e) {
//            model.addAttribute("msgError", e.getMessage());
//            return prepararVistaFormularioEdicion(model, usuarioDto);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            model.addAttribute("msgError", "Error de sistema");
//            return prepararVistaFormularioEdicion(model, usuarioDto);
//        }
//    }
//
//    @PostMapping("/{id}/baja")
//    public String eliminarUsuario(Model model, @PathVariable Long id) {
//        try {
//            mecanicoService.eliminarUsuario(id);
//            return "redirect:" + redirectLista;
//        } catch (BusinessException e) {
//            model.addAttribute("msgError", e.getMessage());
//            return prepararVistaLista(model);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            model.addAttribute("msgError", "Error de sistema");
//            return prepararVistaLista(model);
//        }
//    }
//
//    private String prepararVistaLista(Model model) {
//        List<UsuarioDto> usuarios = mecanicoService.listarUsuariosDtos();
//        model.addAttribute("usuarios", usuarios);
//        return vistaLista;
//    }
//
//    private String prepararVistaFormularioAlta(Model model, UsuarioCreateFormDto usuario) {
//        model.addAttribute("usuario", usuario);
//        return vistaAlta;
//    }
//
//    private String prepararVistaFormularioEdicion(Model model, UsuarioDto usuario) {
//        model.addAttribute("usuario", usuario);
//        return vistaEdicion;
//    }
}
