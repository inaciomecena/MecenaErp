package br.com.mecena.MecenaErp.services;

import br.com.mecena.MecenaErp.dtos.request.ClienteRequestDTO;
import br.com.mecena.MecenaErp.dtos.response.ClienteResponseDTO;
import br.com.mecena.MecenaErp.dtos.response.ClienteResumoResponseDTO;
import br.com.mecena.MecenaErp.entities.Cliente;
import br.com.mecena.MecenaErp.entities.enums.Status;
import br.com.mecena.MecenaErp.exceptions.ClienteJaExistenteException;
import br.com.mecena.MecenaErp.exceptions.ClienteNaoEncontradoException;
import br.com.mecena.MecenaErp.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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


        return new ClienteResponseDTO(
                clienteEntity.getId(),
                clienteEntity.getNome(),
                clienteEntity.getCpf(),
                clienteEntity.getCriadoPeloUsuario(),
                clienteEntity.getCriadoDataEHora(),
                clienteEntity.getEmail(),
                clienteEntity.getCidade()
        );
    }

    private void verificarCpfDuplicado(final ClienteRequestDTO clienteRequestDTO) {
        final var numeroCpf = clienteRequestDTO.cpf();

        if (clienteRepository.existsByCpf(numeroCpf)) {
            throw new ClienteJaExistenteException("Cliente com o cpf " +numeroCpf + " já existe.");
        }
    }

    public List<ClienteResponseDTO> listar() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.stream()
                .map(cliente -> new ClienteResponseDTO(
                        cliente.getId(),
                        cliente.getNome(),
                        cliente.getCpf(),
                        cliente.getCriadoPeloUsuario(),
                        cliente.getCriadoDataEHora(),
                        cliente.getEmail(),
                        cliente.getCidade()))
                .collect(Collectors.toList());
    }

    public ClienteResponseDTO atualizar(UUID id, ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado com o ID: " + id));

        BeanUtils.copyProperties(clienteRequestDTO, cliente);
        cliente.setEditadoDataEHora(String.valueOf(LocalDateTime.now())); // Atualiza a data e hora de edição

        clienteRepository.save(cliente);

        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getCriadoPeloUsuario(),
                cliente.getCriadoDataEHora(),
                cliente.getEmail(),
                cliente.getCidade()


        );
    }

    public void deletar(UUID id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado com o ID: " + id));

        clienteRepository.delete(cliente);
    }

    public ClienteResponseDTO buscarPorId(UUID id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado com o ID: " + id));

        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getCriadoPeloUsuario(),
                cliente.getCriadoDataEHora(),
                cliente.getEmail(),
                cliente.getCidade()


        );
    }

    public Page<ClienteResumoResponseDTO> obterClientes(Pageable pageable) {

        return clienteRepository.findAll(pageable)
                .map(cliente -> new ClienteResumoResponseDTO(
                   cliente.getId(),
                   cliente.getNome(),
                   cliente.getStatus()));
    }




}
