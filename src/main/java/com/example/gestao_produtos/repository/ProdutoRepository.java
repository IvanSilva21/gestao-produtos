package com.example.gestao_produtos.repository;

import com.example.gestao_produtos.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
