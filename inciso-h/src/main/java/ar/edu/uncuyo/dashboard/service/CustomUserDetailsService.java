package ar.edu.uncuyo.dashboard.service;

import ar.edu.uncuyo.dashboard.auth.CustomUserDetails;
import ar.edu.uncuyo.dashboard.entity.Mecanico;
import ar.edu.uncuyo.dashboard.entity.Usuario;
import ar.edu.uncuyo.dashboard.repository.MecanicoRepository;
import ar.edu.uncuyo.dashboard.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final MecanicoRepository mecanicoRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Mecanico mecanico = mecanicoRepository.findByUsuarioEmailAndEliminadoFalse(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Usuario usuario = mecanico.getUsuario();

        return new CustomUserDetails(usuario.getId(), mecanico.getId(), usuario.getEmail(), usuario.getClave());
    }
}