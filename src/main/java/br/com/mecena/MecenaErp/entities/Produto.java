package br.com.mecena.MecenaErp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "CB_PRODUTOS")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String CodBarras;

    @NotEmpty(message = "O nome do produto é obrigatório")
    private String NomeProduto;

    private String UN;
    private String Marca;
    private Long IDGrupo;
    private BigDecimal PrecoCusto;
    private BigDecimal Margem;

    @NotEmpty(message = "O preço de venda é obrigatório")
    private BigDecimal PrecoVenda;

    private Long CodOrigem;
    private Long CodCST;
    private BigDecimal AliqICMS;
    private String NCM;
    private Long CodCSTIPI;
    private Long CodCSTPIS;
    private Long CodCSTCofins;
    private BigDecimal AliqIPI;
    private BigDecimal AliqPIS;
    private BigDecimal AliqCofins;
    private BigDecimal RedICMS;
    private BigDecimal AliqMVA;
    private BigDecimal AliqIVA;
    private Long ModBCICMS;
    private Long ModBCICMSST;

}
