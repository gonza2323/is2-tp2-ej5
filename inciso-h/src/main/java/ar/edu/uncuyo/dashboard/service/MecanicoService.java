package ar.edu.uncuyo.dashboard.service;

import ar.edu.uncuyo.dashboard.dto.MecanicoCreateFormDto;
import ar.edu.uncuyo.dashboard.dto.MecanicoDto;
import ar.edu.uncuyo.dashboard.entity.Mecanico;
import ar.edu.uncuyo.dashboard.entity.Usuario;
import ar.edu.uncuyo.dashboard.mapper.MecanicoMapper;
import ar.edu.uncuyo.dashboard.repository.MecanicoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MecanicoService {
    private final MecanicoRepository mecanicoRepository;
    private final MecanicoMapper mecanicoMapper;
    private final UsuarioService usuarioService;

    @Transactional
    public Mecanico buscarMecanico(Long id) {
        return mecanicoRepository.findByIdAndEliminadoFalse(id)
                .orElseThrow(() -> new RuntimeException("Mecanico no encontrado"));
    }

    @Transactional
    public MecanicoDto buscarMecanicoDto(Long id) {
        Mecanico mecanico = buscarMecanico(id);
        return mecanicoMapper.toDto(mecanico);
    }

    @Transactional
    public List<MecanicoDto> listarMecanicosDtos() {
        List<Mecanico> mecanicos = mecanicoRepository.findAllByEliminadoFalseOrderByApellidoAscNombreAsc();
        return mecanicoMapper.toDtos(mecanicos);
    }

    @Transactional
    public void create(MecanicoCreateFormDto mecanicoDto) {
        Mecanico mecanico = mecanicoMapper.toEntity(mecanicoDto);

        Usuario usuario = usuarioService.crearUsuario(mecanicoDto.getUsuario());
        mecanico.setUsuario(usuario);

        mecanicoRepository.save(mecanico);
    }

    @Transactional
    public void modificarMecanico(MecanicoDto mecanicoDto) {
        Mecanico mecanico = buscarMecanico(mecanicoDto.getId());
        mecanicoMapper.updateEntityFromDto(mecanicoDto, mecanico);

        mecanicoRepository.save(mecanico);
    }

    @Transactional
    public void eliminarMecanico(Long id) {
        Mecanico mecanico = buscarMecanico(id);
    }
}
