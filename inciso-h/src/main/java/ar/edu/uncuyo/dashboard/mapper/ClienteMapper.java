package ar.edu.uncuyo.dashboard.mapper;

import ar.edu.uncuyo.dashboard.dto.cliente.ClienteCreateDto;
import ar.edu.uncuyo.dashboard.dto.cliente.ClienteDetailDto;
import ar.edu.uncuyo.dashboard.dto.cliente.ClienteSummaryDto;
import ar.edu.uncuyo.dashboard.dto.cliente.ClienteUpdateDto;
import ar.edu.uncuyo.dashboard.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper extends BaseMapper<Cliente, ClienteDetailDto, ClienteSummaryDto, ClienteCreateDto, ClienteUpdateDto> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "eliminado", ignore = true)
    Cliente toEntity(ClienteCreateDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "eliminado", ignore = true)
    void updateEntity(ClienteUpdateDto dto, @MappingTarget Cliente cliente);

    ClienteDetailDto toDto(Cliente cliente);

    ClienteSummaryDto toSummaryDto(Cliente cliente);
}
