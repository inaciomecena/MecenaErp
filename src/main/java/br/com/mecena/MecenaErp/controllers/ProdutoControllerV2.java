package br.com.mecena.MecenaErp.controllers;


import br.com.mecena.MecenaErp.dtos.request.ClienteRequestDTO;
import br.com.mecena.MecenaErp.dtos.request.ProdutoRequestDTO;
import br.com.mecena.MecenaErp.dtos.response.ClienteResponseDTO;
import br.com.mecena.MecenaErp.dtos.response.ProdutoResponseDTO;
import br.com.mecena.MecenaErp.services.ProdutoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v2/produtos")

@Slf4j

public class ProdutoControllerV2 {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping //Adicionando o endpoint para listar clientes
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutos() {
        List<ProdutoResponseDTO> produtos = produtoService.listar();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> salvar(@Valid @RequestBody ProdutoRequestDTO produtoRequestDTO) {

        log.info("m=salvar, ProdutoResponseDTO={}", produtoRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoService.salvar(produtoRequestDTO));
    }
}
