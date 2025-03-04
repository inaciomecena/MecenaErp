package br.com.mecena.MecenaErp.services;

import br.com.mecena.MecenaErp.dtos.request.ClienteRequestDTO;
import br.com.mecena.MecenaErp.dtos.response.ClienteResponseDTO;
import br.com.mecena.MecenaErp.entities.Cliente;
import br.com.mecena.MecenaErp.entities.enums.Status;
import br.com.mecena.MecenaErp.exceptions.ClienteJaExistenteException;
import br.com.mecena.MecenaErp.repositories.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteResponseDTO salvar(final ClienteRequestDTO clienteRequestDTO) {

        verificarCpfDuplicado(clienteRequestDTO);

        var clienteEntity = new Cliente();

        BeanUtils.copyProperties(clienteRequestDTO, clienteEntity);

        clienteEntity.setStatus(Status.ATIVO);

        clienteRepository.save(clienteEntity);


        return new ClienteResponseDTO(clienteEntity.getId(),
                clienteEntity.getStatus(),
                clienteEntity.getCriadoPeloUsuario(),
                clienteEntity.getCriadoDataEHora(),
                clienteEntity.getEditadoPeloUsuario(),
                clienteEntity.getEditadoDataEHora()
                );
    }

    private void verificarCpfDuplicado(final ClienteRequestDTO clienteRequestDTO) {
        final var numeroCpf = clienteRequestDTO.cpf();

        if (clienteRepository.existsByCpf(numeroCpf)) {
            throw new ClienteJaExistenteException("Cliente com o cpf " +numeroCpf + " já existe.");
        }
    }


}
