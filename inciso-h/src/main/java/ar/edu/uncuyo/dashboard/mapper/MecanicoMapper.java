package ar.edu.uncuyo.dashboard.mapper;

import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoCreateDto;
import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoDetailDto;
import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoSummaryDto;
import ar.edu.uncuyo.dashboard.dto.mecanico.MecanicoUpdateDto;
import ar.edu.uncuyo.dashboard.entity.Mecanico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MecanicoMapper extends BaseMapper<Mecanico, MecanicoDetailDto, MecanicoSummaryDto, MecanicoCreateDto, MecanicoUpdateDto> {

    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "eliminado", ignore = true)
    Mecanico toEntity(MecanicoCreateDto dto);

    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "eliminado", ignore = true)
    void updateEntity(MecanicoUpdateDto dto, @MappingTarget Mecanico mecanico);

    MecanicoDetailDto toDto(Mecanico mecanico);

    MecanicoSummaryDto toSummaryDto(Mecanico mecanico);

    List<MecanicoSummaryDto> toSummaryDtos(List<Mecanico> proveedores);
}
