package com.example.gestao_produtos.exception;

public class ProdutoNotFoundException extends RuntimeException {

    public ProdutoNotFoundException (Long id) {
        super("Produto não encontrado. Id" +  id);
    }
}
