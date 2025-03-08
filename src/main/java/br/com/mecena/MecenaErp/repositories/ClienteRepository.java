package br.com.mecena.MecenaErp.repositories;

import br.com.mecena.MecenaErp.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {


    boolean existsByCpf(String numeroCpf);


}