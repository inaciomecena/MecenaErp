package br.com.mecena.MecenaErp.dtos.response;

import br.com.mecena.MecenaErp.entities.enums.Status;

import java.util.UUID;

public record ClienteResumoResponseDTO(UUID id, String nome, Status Status) {
}
