package ar.edu.uncuyo.dashboard.facade;

import ar.edu.uncuyo.dashboard.entity.Vehiculo;
import ar.edu.uncuyo.dashboard.service.HistorialArregloService;
import ar.edu.uncuyo.dashboard.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArreglosFacade {
    private final VehiculoService vehiculoService;
    private final HistorialArregloService historialArregloService;

    @Transactional
    public void eliminarVehiculo(Long id) {
        Vehiculo vehiculo = vehiculoService.delete(id);
        historialArregloService.deleteByVehiculo(vehiculo);
    }
}
