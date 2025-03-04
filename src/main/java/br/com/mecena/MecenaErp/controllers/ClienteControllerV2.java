package br.com.mecena.MecenaErp.controllers;

import br.com.mecena.MecenaErp.dtos.request.ClienteRequestDTO;
import br.com.mecena.MecenaErp.dtos.response.ClienteResponseDTO;
import br.com.mecena.MecenaErp.entities.Cliente;
import br.com.mecena.MecenaErp.services.ClienteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v2/clientes")

@Slf4j
public class ClienteControllerV2 {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> salvar(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {

        log.info("m=salvar, ClienteRequestDTO={}", clienteRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteService.salvar(clienteRequestDTO));
    }

    @GetMapping //Adicionando o endpoint para listar clientes
    public ResponseEntity<List<ClienteResponseDTO>> listarClientes() {
        List<ClienteResponseDTO> clientes = clienteService.listar();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @PutMapping("/{id}") // Adicionando o endpoint para atualizar clientes
    public ResponseEntity<ClienteResponseDTO> atualizarCliente(@PathVariable UUID id, @RequestBody ClienteRequestDTO clienteRequestDTO) {
        ClienteResponseDTO clienteResponseDTO = clienteService.atualizar(id, clienteRequestDTO);
        return new ResponseEntity<>(clienteResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}") // Adicionando o endpoint para deletar clientes
    public ResponseEntity<Void> deletarCliente(@PathVariable UUID id) {
        clienteService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna 204 No Content

    }

}
