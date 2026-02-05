package com.example.gestao_produtos.dto.request;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class ProdutoRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Preço é obrigatório")
    @DecimalMin(value = "0.1", message = "Preço deve ser maior que zero")
    private BigDecimal preco;

    @NotNull(message = "Quantidade é obrigatória")
    @DecimalMin(value = "0", message = "Quantidade não pode ser negativa")
    private int quantidade;

    public ProdutoRequestDTO(String teclado, BigDecimal bigDecimal, int i) {
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

