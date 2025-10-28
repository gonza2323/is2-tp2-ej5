package ar.edu.uncuyo.dashboard.service;

import ar.edu.uncuyo.dashboard.dto.UsuarioCreateDto;
import ar.edu.uncuyo.dashboard.entity.Usuario;
import ar.edu.uncuyo.dashboard.error.BusinessException;
import ar.edu.uncuyo.dashboard.mapper.UsuarioMapper;
import ar.edu.uncuyo.dashboard.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;
//
//    @Transactional
//    public Usuario buscarUsuario(Long id) {
//        return usuarioRepository.findByIdAndEliminadoFalse(id)
//                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
//    }
//
//    @Transactional
//    public UsuarioDto buscarUsuarioDto(Long id) {
//        Usuario usuario = buscarUsuario(id);
//        return usuarioMapper.toDto(usuario);
//    }
//
//    @Transactional
//    public List<UsuarioDto> listarUsuariosDtos() {
//        List<Usuario> usuarios = usuarioRepository.findAllByEliminadoFalseOrderByNombreAsc();
//        return usuarioMapper.toDtos(usuarios);
//    }
//
    @Transactional
    public Usuario crearUsuario(UsuarioCreateDto usuarioCreateDto) {
        validar(usuarioCreateDto);

        Usuario usuario = usuarioMapper.toEntity(usuarioCreateDto);
        String clave = passwordEncoder.encode(usuarioCreateDto.getClave());
        usuario.setClave(clave);

        return usuarioRepository.save(usuario);
    }
//
//    @Transactional
//    public void modificarUsuario(UsuarioDto usuarioDto) {
//        validarDatos(usuarioDto);
//
//        Usuario usuario = buscarUsuario(usuarioDto.getId());
////        personaService.modificarPersona(usuario, usuarioDto);
//
////        usuario.setCuenta(usuarioDto.getCorreoElectronico());
//        usuarioRepository.save(usuario);
//    }
//
//    @Transactional
//    public void eliminarUsuario(Long id){
//        personaService.eliminarPersona(id);
//    }
//
//    @Transactional
//    public void cambiarClave(CambiarClaveFormDto form){
//        Usuario usuario = buscarUsuarioActual();
//
//        String claveActual = passwordEncoder.encode(form.getClaveActual());
//        if (!passwordEncoder.matches(form.getClaveActual(), usuario.getClave()))
//            throw new BusinessException("La contraseña actual es incorrecta");
//
//        if (!form.getNuevaClave().equals(form.getConfirmacionClave()))
//            throw new BusinessException("Las contraseñas no coinciden");
//
//        if (form.getClaveActual().equals(form.getNuevaClave()))
//            throw new BusinessException("La nueva contraseña debe ser distinta a la actual");
//
//        String nuevaClave = passwordEncoder.encode(form.getNuevaClave());
//        usuario.setClave(nuevaClave);
//        usuarioRepository.save(usuario);
//    }
//
//    @Transactional
//    public Usuario buscarUsuarioActual() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication == null || !authentication.isAuthenticated())
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
//
//        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
//
//        return buscarUsuario(userDetails.getId());
//    }

    private void validar(UsuarioCreateDto usuarioDto) {
        if (!usuarioDto.getClave().equals(usuarioDto.getConfirmacionClave()))
            throw new BusinessException("Las contraseñas no coinciden");

        if (usuarioRepository.existsByEmailAndEliminadoFalse(usuarioDto.getEmail())) {
            throw new BusinessException("La dirección de correo electrónico ya está en uso");
        }
    }
//
//    private void validar(UsuarioDto usuarioDto) {
//        if (usuarioRepository.existsByCuentaAndIdNotAndEliminadoFalse(
//                usuarioDto.getCorreoElectronico(),
//                usuarioDto.getId())) {
//            throw new BusinessException("La dirección de correo electrónico ya está en uso");
//        }
//    }
}
