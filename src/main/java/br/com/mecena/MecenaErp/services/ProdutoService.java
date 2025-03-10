package br.com.mecena.MecenaErp.services;

import br.com.mecena.MecenaErp.dtos.request.ProdutoRequestDTO;
import br.com.mecena.MecenaErp.dtos.response.ProdutoResponseDTO;
import br.com.mecena.MecenaErp.entities.Produto;
import br.com.mecena.MecenaErp.repositories.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoResponseDTO salvar(final ProdutoRequestDTO produtoRequestDTO) {

        var produtoEntity = new Produto();
        BeanUtils.copyProperties(produtoRequestDTO, produtoEntity);
        produtoRepository.save(produtoEntity);

        return new ProdutoResponseDTO(
                produtoEntity.getId(),
                produtoEntity.getNomeProduto(),
                produtoEntity.getUN(),
                produtoEntity.getPrecoVenda(),
                produtoEntity.getMarca(),
                produtoEntity.getCodBarras(),
                produtoEntity.getNCM()));
    }

    public List<ProdutoResponseDTO> listar() {
        List<Produto> produtos = produtoRepository.findAll();

        return produtos.stream()
                .map(produto -> new ProdutoResponseDTO(
                        produto.getId(),
                        produto.getNomeProduto(),
                        produto.getUN(),
                        produto.getPrecoVenda(),
                        produto.getMarca(),
                        produto.getCodBarras(),
                        produto.getNCM()))
                .collect(Collectors.toList());
    }

}
