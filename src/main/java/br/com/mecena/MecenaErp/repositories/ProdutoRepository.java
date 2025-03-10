package br.com.mecena.MecenaErp.repositories;

import br.com.mecena.MecenaErp.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
