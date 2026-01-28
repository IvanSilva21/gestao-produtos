package com.example.gestao_produtos.dto.request;

import java.math.BigDecimal;

public class ProdutoPatchRequestDTO {

    private String nome;
    private BigDecimal preco;
    private Integer quantidade;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
