package com.example.gestao_produtos.dto.response;

import java.math.BigDecimal;

public class ProdutoResponseDTO {

    private Long id;
    private String nome;
    private BigDecimal preco;
    private int quantidade;

    public ProdutoResponseDTO(Long id, String nome, BigDecimal preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }


}

