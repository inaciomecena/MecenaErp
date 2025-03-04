package br.com.mecena.MecenaErp.dtos.response;

import java.util.UUID;

public record ClienteResponseDTO(
        UUID id,
        String nome,
        String cpf, String CriadoPeloUsuario,
        String CriadoDataHora,
        String email, String cidade
) {
}