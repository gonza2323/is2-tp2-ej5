package ar.edu.uncuyo.dashboard.service;

import ar.edu.uncuyo.dashboard.dto.historialArreglo.HistorialArregloCreateDto;
import ar.edu.uncuyo.dashboard.dto.historialArreglo.HistorialArregloDetailDto;
import ar.edu.uncuyo.dashboard.dto.historialArreglo.HistorialArregloSummaryDto;
import ar.edu.uncuyo.dashboard.dto.historialArreglo.HistorialArregloUpdateDto;
import ar.edu.uncuyo.dashboard.entity.HistorialArreglo;
import ar.edu.uncuyo.dashboard.entity.Mecanico;
import ar.edu.uncuyo.dashboard.entity.Vehiculo;
import ar.edu.uncuyo.dashboard.mapper.HistorialArregloMapper;
import ar.edu.uncuyo.dashboard.repository.HistorialArregloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialArregloService extends BaseService<
        HistorialArreglo,
        Long,
        HistorialArregloRepository,
        HistorialArregloDetailDto,
        HistorialArregloSummaryDto,
        HistorialArregloCreateDto,
        HistorialArregloUpdateDto,
        HistorialArregloMapper> {

    private final MecanicoService mecanicoService;
    private final VehiculoService vehiculoService;

    public HistorialArregloService(HistorialArregloRepository repository, HistorialArregloMapper mapper, MecanicoService mecanicoService, VehiculoService vehiculoService) {
        super("HistorialArreglo", repository, mapper);
        this.mecanicoService = mecanicoService;
        this.vehiculoService = vehiculoService;
    }

    @Override
    public void preCreate(HistorialArregloCreateDto dto, HistorialArreglo historialArreglo) {
        Vehiculo vehiculo = vehiculoService.find(dto.getVehiculoId());
        historialArreglo.setVehiculo(vehiculo);

        Mecanico mecanico = mecanicoService.find(dto.getMecanicoId());
        historialArreglo.setMecanico(mecanico);
    }

    @Override
    public void preUpdate(HistorialArregloUpdateDto dto, HistorialArreglo historialArreglo) {
        Vehiculo vehiculo = vehiculoService.find(dto.getVehiculoId());
        historialArreglo.setVehiculo(vehiculo);

        Mecanico mecanico = mecanicoService.find(dto.getMecanicoId());
        historialArreglo.setMecanico(mecanico);
    }

    public void deleteByVehiculo(Vehiculo vehiculo) {
        List<HistorialArreglo> arreglos = repository.findAllByVehiculoAndEliminadoFalse(vehiculo);

        for (var arreglo : arreglos)
            arreglo.setEliminado(true);

        repository.saveAll(arreglos);
    }
}
