package com.example.gestao_produtos.mapper;

import com.example.gestao_produtos.domain.Produto;
import com.example.gestao_produtos.dto.request.ProdutoRequestDTO;
import com.example.gestao_produtos.dto.response.ProdutoResponseDTO;

public class ProdutoMapper {

    public static Produto toEntity(ProdutoRequestDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade(dto.getQuantidade());
        return produto;
    }

    public static ProdutoResponseDTO toResponseDTO(Produto produto) {
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getQuantidade()
        );
    }
}

