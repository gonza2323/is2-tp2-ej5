package ar.edu.uncuyo.dashboard.mapper;

import ar.edu.uncuyo.dashboard.dto.MecanicoCreateFormDto;
import ar.edu.uncuyo.dashboard.dto.MecanicoDto;
import ar.edu.uncuyo.dashboard.entity.Mecanico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

//@Mapper(componentModel = "spring", uses = {DireccionMapper.class})
@Mapper(componentModel = "spring")
public interface MecanicoMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "eliminado", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    Mecanico toEntity(MecanicoCreateFormDto dto);

    @Mapping(target = "eliminado", ignore = true)
    void updateEntityFromDto(MecanicoDto dto, @MappingTarget Mecanico mecanico);

    MecanicoDto toDto(Mecanico mecanico);

    List<MecanicoDto> toDtos(List<Mecanico> proveedores);
}
