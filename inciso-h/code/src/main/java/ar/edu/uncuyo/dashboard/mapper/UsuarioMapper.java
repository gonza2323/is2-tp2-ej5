package ar.edu.uncuyo.dashboard.mapper;

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
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends BaseMapper<Usuario, UsuarioDetailDto, UsuarioSummaryDto, UsuarioCreateDto, UsuarioUpdateDto> {

    @Mapping(target = "clave", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "eliminado", ignore = true)
    Usuario toEntity(UsuarioCreateDto dto);

    @Mapping(target = "clave", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "eliminado", ignore = true)
    void updateEntity(UsuarioUpdateDto dto, @MappingTarget Usuario usuario);

    UsuarioDetailDto toDto(Usuario usuario);

    UsuarioSummaryDto toSummaryDto(Usuario usuario);
}
