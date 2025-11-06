package ar.edu.uncuyo.dashboard.mapper;

import ar.edu.uncuyo.dashboard.dto.historialArreglo.HistorialArregloCreateDto;
import ar.edu.uncuyo.dashboard.dto.historialArreglo.HistorialArregloDetailDto;
import ar.edu.uncuyo.dashboard.dto.historialArreglo.HistorialArregloSummaryDto;
import ar.edu.uncuyo.dashboard.dto.historialArreglo.HistorialArregloUpdateDto;
import ar.edu.uncuyo.dashboard.entity.HistorialArreglo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface HistorialArregloMapper extends BaseMapper<HistorialArreglo, HistorialArregloDetailDto, HistorialArregloSummaryDto, HistorialArregloCreateDto, HistorialArregloUpdateDto> {

    @Mapping(target = "mecanico", ignore = true)
    @Mapping(target = "vehiculo", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "eliminado", ignore = true)
    HistorialArreglo toEntity(HistorialArregloCreateDto dto);

    @Mapping(target = "mecanico", ignore = true)
    @Mapping(target = "vehiculo", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "eliminado", ignore = true)
    void updateEntity(HistorialArregloUpdateDto dto, @MappingTarget HistorialArreglo historialArreglo);

    @Mapping(target = "vehiculoId", source = "vehiculo.id")
    @Mapping(target = "vehiculoMarca", source = "vehiculo.marca")
    @Mapping(target = "vehiculoModelo", source = "vehiculo.modelo")
    @Mapping(target = "vehiculoPatente", source = "vehiculo.patente")
    @Mapping(target = "clienteId", source = "vehiculo.cliente.id")
    @Mapping(target = "clienteNombre", source = "vehiculo.cliente.nombre")
    @Mapping(target = "clienteApellido", source = "vehiculo.cliente.apellido")
    @Mapping(target = "clienteDni", source = "vehiculo.cliente.dni")
    @Mapping(target = "mecanicoId", source = "mecanico.id")
    @Mapping(target = "mecanicoNombre", source = "mecanico.nombre")
    @Mapping(target = "mecanicoApellido", source = "mecanico.apellido")
    @Mapping(target = "mecanicoLegajo", source = "mecanico.legajo")
    HistorialArregloDetailDto toDto(HistorialArreglo historialArreglo);

    @Mapping(target = "vehiculoId", source = "vehiculo.id")
    @Mapping(target = "vehiculoPatente", source = "vehiculo.patente")
    @Mapping(target = "clienteId", source = "vehiculo.cliente.id")
    @Mapping(target = "clienteDni", source = "vehiculo.cliente.dni")
    @Mapping(target = "mecanicoId", source = "mecanico.id")
    @Mapping(target = "mecanicoLegajo", source = "mecanico.legajo")
    HistorialArregloSummaryDto toSummaryDto(HistorialArreglo historialArreglo);
}
