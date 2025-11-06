package ar.edu.uncuyo.dashboard.controller;

import ar.edu.uncuyo.dashboard.auth.CustomUserDetails;
import ar.edu.uncuyo.dashboard.dto.auth.CambiarClaveFormDto;
import ar.edu.uncuyo.dashboard.error.BusinessException;
import ar.edu.uncuyo.dashboard.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UsuarioService usuarioService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", "");
        return "auth/login";
    }

    @GetMapping(path = "/cambiar-clave")
    public String cambiarClave(Model model) {
        return prepararVistaCambiarClave(model, new CambiarClaveFormDto());
    }

    @PostMapping(path = "/cambiar-clave")
    public String cambiarClave(Model model,
                               @AuthenticationPrincipal CustomUserDetails userDetails,
                               @Valid @ModelAttribute("cambiarClaveForm") CambiarClaveFormDto form,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return prepararVistaCambiarClave(model, form);

        try {
            usuarioService.cambiarClave(userDetails.getId(), form);
            return "redirect:/";
        } catch (BusinessException e) {
            model.addAttribute("msgError", e.getMessage());
            return prepararVistaCambiarClave(model, form);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("msgError", "Error de sistema");
            return prepararVistaCambiarClave(model, form);
        }
    }

    private String prepararVistaCambiarClave(Model model, CambiarClaveFormDto form) {
        model.addAttribute("cambiarClaveForm", form);
        return "auth/cambiarClave";
    }
}
