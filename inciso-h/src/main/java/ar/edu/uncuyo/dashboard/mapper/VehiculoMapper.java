package ar.edu.uncuyo.dashboard.mapper;

import ar.edu.uncuyo.dashboard.dto.vehiculo.VehiculoCreateDto;
import ar.edu.uncuyo.dashboard.dto.vehiculo.VehiculoDetailDto;
import ar.edu.uncuyo.dashboard.dto.vehiculo.VehiculoSummaryDto;
import ar.edu.uncuyo.dashboard.dto.vehiculo.VehiculoUpdateDto;
import ar.edu.uncuyo.dashboard.entity.Vehiculo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VehiculoMapper extends BaseMapper<Vehiculo, VehiculoDetailDto, VehiculoSummaryDto, VehiculoCreateDto, VehiculoUpdateDto> {

    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "arreglos", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "eliminado", ignore = true)
    Vehiculo toEntity(VehiculoCreateDto dto);

    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "arreglos", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "eliminado", ignore = true)
    void updateEntity(VehiculoUpdateDto dto, @MappingTarget Vehiculo vehiculo);

    @Mapping(target = "clienteId", source = "cliente.id")
    @Mapping(target = "clienteNombre", source = "cliente.nombre")
    @Mapping(target = "clienteApellido", source = "cliente.apellido")
    @Mapping(target = "clienteDni", source = "cliente.dni")
    VehiculoDetailDto toDto(Vehiculo vehiculo);

    @Mapping(target = "clienteId", source = "cliente.id")
    @Mapping(target = "clienteDni", source = "cliente.dni")
    VehiculoSummaryDto toSummaryDto(Vehiculo vehiculo);
}
