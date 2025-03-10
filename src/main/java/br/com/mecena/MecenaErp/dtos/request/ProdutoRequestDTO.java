package br.com.mecena.MecenaErp.dtos.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

public record ProdutoRequestDTO(

            String CodBarras,
            @NotBlank(message = "O campo nome do produto é obrigatório.")
            String NomeProduto,
            String UN,
            String Marca,
            Long IDGrupo,
            BigDecimal PrecoCusto,
            BigDecimal Margem,
            @NotBlank(message = "O preço de venda é obrigatório")
            BigDecimal PrecoVenda,
            Long CodOrigem,
            Long CodCST,
            BigDecimal AliqICMS,
            String NCM,
            Long CodCSTIPI,
            Long CodCSTPIS,
            Long CodCSTCofins,
            BigDecimal AliqIPI,
            BigDecimal AliqPIS,
            BigDecimal AliqCofins,
            BigDecimal RedICMS,
            BigDecimal AliqMVA,
            BigDecimal AliqIVA,
            Long ModBCICMS,
            Long ModBCICMSST
) {
}
