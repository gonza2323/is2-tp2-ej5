package ar.edu.uncuyo.dashboard.mapper;

import ar.edu.uncuyo.dashboard.dto.UsuarioCreateDto;
import ar.edu.uncuyo.dashboard.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mapping(target = "eliminado", ignore = true)
    @Mapping(target = "clave", ignore = true)
    Usuario toEntity(UsuarioCreateDto usuarioCreateDto);

    @Mapping(target = "eliminado", ignore = true)
    @Mapping(target = "clave", ignore = true)
    Usuario updateEntityFromDto(UsuarioCreateDto usuarioCreateDto, @MappingTarget Usuario usuario);

    UsuarioCreateDto toDto(Usuario usuario);

    List<UsuarioCreateDto> toDtos(List<Usuario> usuarios);
}
