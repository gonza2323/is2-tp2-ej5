package ar.edu.uncuyo.dashboard.service;

import ar.edu.uncuyo.dashboard.dto.IdentifiableDto;
import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoCreateDto;
import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoDetailDto;
import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoSummaryDto;
import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoUpdateDto;
import ar.edu.uncuyo.dashboard.entity.BaseEntity;
import ar.edu.uncuyo.dashboard.entity.Mecanico;
import ar.edu.uncuyo.dashboard.entity.Usuario;
import ar.edu.uncuyo.dashboard.mapper.BaseMapper;
import ar.edu.uncuyo.dashboard.mapper.MecanicoMapper;
import ar.edu.uncuyo.dashboard.repository.BaseRepository;
import ar.edu.uncuyo.dashboard.repository.MecanicoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class MecanicoService extends BaseService<
        Mecanico,
        Long,
        MecanicoRepository,
        MecanicoDetailDto,
        MecanicoSummaryDto,
        MecanicoCreateDto,
        MecanicoUpdateDto,
        MecanicoMapper> {

    private final UsuarioService usuarioService;

    public MecanicoService(MecanicoRepository repository, MecanicoMapper mapper, UsuarioService usuarioService) {
        super("Mecánico", repository, mapper);
        this.usuarioService = usuarioService;
    }

    @Override
    public void preCreate(MecanicoCreateDto dto, Mecanico mecanico) {
        Usuario usuario = usuarioService.create(dto.getUsuario());
        mecanico.setUsuario(usuario);
    }

    @Override
    public void preUpdate(MecanicoUpdateDto dto, Mecanico mecanico) {
        usuarioService.update(dto.getUsuario(), mecanico.getUsuario());
    }

    @Override
    public void preDelete(Mecanico mecanico) {
        usuarioService.delete(mecanico.getUsuario());
    }
}
