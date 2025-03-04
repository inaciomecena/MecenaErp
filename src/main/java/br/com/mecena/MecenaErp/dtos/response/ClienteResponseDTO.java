package br.com.mecena.MecenaErp.dtos.response;

import br.com.mecena.MecenaErp.entities.enums.Status;

import java.util.UUID;

public record ClienteResponseDTO(
        UUID id,
        Status status,
        String clienteNome, String clienteCpf, String nome,
        String cpf
) {
}