package br.com.mecena.MecenaErp.dtos.response;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProdutoResponseDTO(
        long id,
        String CodBarras,
        String NomeProduto,
        String UN,
        String Marca,
        Long IDGrupo,
        BigDecimal PrecoCusto,
        BigDecimal Margem,
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
