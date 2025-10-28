package ar.edu.uncuyo.dashboard.init;

import ar.edu.uncuyo.dashboard.dto.MecanicoCreateFormDto;
import ar.edu.uncuyo.dashboard.dto.UsuarioCreateDto;
import ar.edu.uncuyo.dashboard.repository.*;
import ar.edu.uncuyo.dashboard.service.MecanicoService;
import ar.edu.uncuyo.dashboard.service.UsuarioService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitialization implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;
    private final MecanicoService mecanicoService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        crearDatosIniciales();
    }

    @Transactional
    protected void crearDatosIniciales() throws Exception {
        if (usuarioRepository.existsByEmailAndEliminadoFalse("pepeargento@gmail.com")) {
            System.out.println("Datos iniciales ya creados. Salteando creación de datos iniciales. Para forzar su creación, borrar la base de datos");
            return;
        }

        // Nos damos permisos para poder crear los datos iniciales
        var auth = new UsernamePasswordAuthenticationToken("system", null);
        SecurityContextHolder.getContext().setAuthentication(auth);

        System.out.println("Creando datos iniciales...");

        // Creación de datos iniciales
        crearMecanicos();
//        crearClientes();

        // Resetear los permisos
        SecurityContextHolder.clearContext();

        System.out.println("Datos iniciales creados.");
    }

    @Transactional
    protected void crearMecanicos() {
        mecanicoService.create(MecanicoCreateFormDto.builder()
                .legajo("123456")
                .nombre("Javier")
                .apellido("Perez")
                .usuario(UsuarioCreateDto.builder()
                        .email("pepeargento@gmail.com")
                        .clave("1234")
                        .confirmacionClave("1234")
                        .build())
                .build());
    }
}