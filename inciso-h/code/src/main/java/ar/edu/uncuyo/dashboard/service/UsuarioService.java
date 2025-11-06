package ar.edu.uncuyo.dashboard.service;

import ar.edu.uncuyo.dashboard.dto.auth.CambiarClaveFormDto;
import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoCreateDto;
import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoDetailDto;
import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoSummaryDto;
import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoUpdateDto;
import ar.edu.uncuyo.dashboard.dto.usuario.UsuarioCreateDto;
import ar.edu.uncuyo.dashboard.dto.usuario.UsuarioDetailDto;
import ar.edu.uncuyo.dashboard.dto.usuario.UsuarioSummaryDto;
import ar.edu.uncuyo.dashboard.dto.usuario.UsuarioUpdateDto;
import ar.edu.uncuyo.dashboard.entity.Mecanico;
import ar.edu.uncuyo.dashboard.entity.Usuario;
import ar.edu.uncuyo.dashboard.error.BusinessException;
import ar.edu.uncuyo.dashboard.mapper.MecanicoMapper;
import ar.edu.uncuyo.dashboard.mapper.UsuarioMapper;
import ar.edu.uncuyo.dashboard.repository.MecanicoRepository;
import ar.edu.uncuyo.dashboard.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends BaseService<
        Usuario,
        Long,
        UsuarioRepository,
        UsuarioDetailDto,
        UsuarioSummaryDto,
        UsuarioCreateDto,
        UsuarioUpdateDto,
        UsuarioMapper> {

    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository, UsuarioMapper mapper, PasswordEncoder passwordEncoder) {
        super("Usuario", repository, mapper);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void preCreate(UsuarioCreateDto dto, Usuario usuario) {
        String clave = passwordEncoder.encode(dto.getClave());
        usuario.setClave(clave);
    }

    @Transactional
    public void cambiarClave(Long userId, CambiarClaveFormDto form){
        Usuario usuario = find(userId);

        if (!passwordEncoder.matches(form.getClaveActual(), usuario.getClave()))
            throw new BusinessException("La contraseña actual es incorrecta");

        if (!form.getNuevaClave().equals(form.getConfirmacionClave()))
            throw new BusinessException("Las contraseñas no coinciden");

        if (form.getClaveActual().equals(form.getNuevaClave()))
            throw new BusinessException("La nueva contraseña debe ser distinta a la actual");

        String nuevaClave = passwordEncoder.encode(form.getNuevaClave());
        usuario.setClave(nuevaClave);
        repository.save(usuario);
    }

    @Override
    public void validateCreate(UsuarioCreateDto usuarioDto) {
        if (!usuarioDto.getClave().equals(usuarioDto.getConfirmacionClave()))
            throw new BusinessException("Las contraseñas no coinciden");

        if (repository.existsByEmailAndEliminadoFalse(usuarioDto.getEmail())) {
            throw new BusinessException("La dirección de correo electrónico ya está en uso");
        }
    }

    @Override
    public void validateUpdate(UsuarioUpdateDto usuarioDto) {
        if (repository.existsByEmailAndIdNotAndEliminadoFalse(
                usuarioDto.getEmail(),
                usuarioDto.getId())) {
            throw new BusinessException("La dirección de correo electrónico ya está en uso");
        }
    }
}
