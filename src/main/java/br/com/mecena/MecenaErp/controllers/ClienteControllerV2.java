package br.com.mecena.MecenaErp.controllers;

import br.com.mecena.MecenaErp.dtos.request.ClienteRequestDTO;
import br.com.mecena.MecenaErp.dtos.response.ClienteResponseDTO;
import br.com.mecena.MecenaErp.dtos.response.ClienteResumoResponseDTO;
import br.com.mecena.MecenaErp.dtos.response.PagedResponse;
import br.com.mecena.MecenaErp.entities.Cliente;
import br.com.mecena.MecenaErp.services.ClienteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


   /* @GetMapping //Adicionando o endpoint para listar clientes
    public ResponseEntity<List<ClienteResponseDTO>> listarClientes() {
        List<ClienteResponseDTO> clientes = clienteService.listar();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }*/

    @GetMapping //Adicionando o endpoint para listar clientes
    public PagedResponse<ClienteResumoResponseDTO> obterClientes(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanho
    ) {
        var pageable = PageRequest.of(pagina, tamanho);
        var paginaClientes = clienteService.obterClientes(pageable);

        return new PagedResponse<>(paginaClientes);
    }

   @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarClientePorId(@PathVariable UUID id) {
        ClienteResponseDTO clienteResponseDTO = clienteService.buscarPorId(id);
        return new ResponseEntity<>(clienteResponseDTO, HttpStatus.OK);
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
