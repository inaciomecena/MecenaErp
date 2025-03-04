package br.com.mecena.MecenaErp.dtos.response;

import br.com.mecena.MecenaErp.entities.enums.Status;

import java.util.UUID;

public record ClienteResponseDTO(
        UUID id,
        Status status,
        String criadoPeloUsuario,
        String criadoDataEHora,
        String editadoPeloUsuario,
        String editadoDataEHora
) {
}