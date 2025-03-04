package br.com.mecena.MecenaErp.dtos.request;

//Gera automaticamente (getters, equals, hashCode, toString)

//Imutáveis: Uma vez criado, o valor de um record não pode ser alterado

//Sintaxe enxuta

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

public record ClienteRequestDTO(
//         Garante que o atributo não seja nulo e tenha ao menos um caractere não branco.
        @NotBlank(message = "O campo nome é obrigatório.")
        @Size(message = "O campo nome deve ter pelo menos 3 caracteres.", min = 3)
        String nome,
        @NotBlank(message = "O campo cpf é obrigatório.")
        @CPF(message = "O campo cpf precisa ser válido.")
        String cpf,
        @NotBlank(message = "O campo email é obrigatório.")
        @Email(message = "O campo email precisa ser válido.")
        String email,
        @NotBlank(message = "O campo endereco é obrigatório.")
        String endereco,
        @NotBlank(message = "O campo CEP é obrigatório.")
        String Cep,
        @NotBlank(message = "O campo Celular é obrigatório.")
        String celular,
        @Min(message = "A idade mínima precisa ser igual a 18 anos", value = 18) @Max(message = "A idade máxima precisa ser igual a 120 anos", value = 120)
        Integer idade
) {
}