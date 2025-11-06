package ar.edu.uncuyo.dashboard.service;

import ar.edu.uncuyo.dashboard.dto.vehiculo.VehiculoCreateDto;
import ar.edu.uncuyo.dashboard.dto.vehiculo.VehiculoDetailDto;
import ar.edu.uncuyo.dashboard.dto.vehiculo.VehiculoSummaryDto;
import ar.edu.uncuyo.dashboard.dto.vehiculo.VehiculoUpdateDto;
import ar.edu.uncuyo.dashboard.entity.Cliente;
import ar.edu.uncuyo.dashboard.entity.Vehiculo;
import ar.edu.uncuyo.dashboard.error.BusinessException;
import ar.edu.uncuyo.dashboard.mapper.VehiculoMapper;
import ar.edu.uncuyo.dashboard.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService extends BaseService<
        Vehiculo,
        Long,
        VehiculoRepository,
        VehiculoDetailDto,
        VehiculoSummaryDto,
        VehiculoCreateDto,
        VehiculoUpdateDto,
        VehiculoMapper> {

    private final ClienteService clienteService;

    public VehiculoService(VehiculoRepository repository, VehiculoMapper mapper, ClienteService clienteService) {
        super("Vehiculo", repository, mapper);
        this.clienteService = clienteService;
    }

    @Override
    public void preCreate(VehiculoCreateDto dto, Vehiculo vehiculo) {
        Cliente cliente = clienteService.find(dto.getClienteId());
        vehiculo.setCliente(cliente);
    }

    @Override
    public void preUpdate(VehiculoUpdateDto dto, Vehiculo vehiculo) {
        Cliente cliente = clienteService.find(dto.getClienteId());
        vehiculo.setCliente(cliente);
    }

    @Override
    public void validateCreate(VehiculoCreateDto dto) {
        if (repository.existsByPatenteAndEliminadoFalse(dto.getPatente())) {
            throw new BusinessException("Ya existe un vehiculo con esa patente");
        }
    }

    @Override
    public void validateUpdate(VehiculoUpdateDto dto) {
        if (repository.existsByPatenteAndIdNotAndEliminadoFalse(
                dto.getPatente(),
                dto.getId())) {
            throw new BusinessException("Ya existe un vehiculo con esa patente");
        }
    }
}
