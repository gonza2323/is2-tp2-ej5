package ar.edu.uncuyo.dashboard.service;

import ar.edu.uncuyo.dashboard.dto.cliente.ClienteCreateDto;
import ar.edu.uncuyo.dashboard.dto.cliente.ClienteDetailDto;
import ar.edu.uncuyo.dashboard.dto.cliente.ClienteSummaryDto;
import ar.edu.uncuyo.dashboard.dto.cliente.ClienteUpdateDto;
import ar.edu.uncuyo.dashboard.entity.Cliente;
import ar.edu.uncuyo.dashboard.error.BusinessException;
import ar.edu.uncuyo.dashboard.mapper.ClienteMapper;
import ar.edu.uncuyo.dashboard.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends BaseService<
        Cliente,
        Long,
        ClienteRepository,
        ClienteDetailDto,
        ClienteSummaryDto,
        ClienteCreateDto,
        ClienteUpdateDto,
        ClienteMapper> {

    public ClienteService(ClienteRepository repository, ClienteMapper mapper) {
        super("Cliente", repository, mapper);
    }

    @Override
    public void validateCreate(ClienteCreateDto clienteDto) {
        if (repository.existsByDniAndEliminadoFalse(clienteDto.getDni())) {
            throw new BusinessException("Ya existe un cliente con ese DNI");
        }
    }

    @Override
    public void validateUpdate(ClienteUpdateDto clienteDto) {
        if (repository.existsByDniAndIdNotAndEliminadoFalse(
                clienteDto.getDni(),
                clienteDto.getId())) {
            throw new BusinessException("Ya existe un cliente con ese DNI");
        }
    }
}
