package com.example.gestao_produtos.service;

import com.example.gestao_produtos.domain.Produto;
import com.example.gestao_produtos.dto.request.ProdutoRequestDTO;
import com.example.gestao_produtos.dto.response.ProdutoResponseDTO;
import com.example.gestao_produtos.exception.ProdutoNotFoundException;
import com.example.gestao_produtos.mapper.ProdutoMapper;
import com.example.gestao_produtos.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository repository;

    @Mock
    private ProdutoMapper mapper;

    @InjectMocks
    private ProdutoService service;

    @Test
    void deveSalvarProduto() {

        ProdutoRequestDTO request =
                new ProdutoRequestDTO("Teclado", new BigDecimal("100"), 10);

        Produto produto = new Produto();
        ProdutoResponseDTO response =
                new ProdutoResponseDTO(1L, "Teclado", new BigDecimal("100"), 10);

        when(mapper.toEntity(request)).thenReturn(produto);
        when(repository.save(produto)).thenReturn(produto);
        when(mapper.toResponseDTO(produto)).thenReturn(response);

        ProdutoResponseDTO resultado = service.salvar(request);

        assertEquals("Teclado", resultado.getNome());
        assertEquals(10, resultado.getQuantidade());
    }

    @Test
    void deveLancarErroQuandoNaoEncontrar() {

        when(repository.findById(99L))
                .thenReturn(Optional.empty());

        assertThrows(ProdutoNotFoundException.class,
                () -> service.buscarPorId(99L));
    }
}

