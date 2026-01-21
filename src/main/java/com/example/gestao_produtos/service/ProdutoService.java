package com.example.gestao_produtos.service;

import com.example.gestao_produtos.domain.Produto;
import com.example.gestao_produtos.dto.request.ProdutoRequestDTO;
import com.example.gestao_produtos.dto.response.ProdutoResponseDTO;
import com.example.gestao_produtos.exception.ProdutoNotFoundException;
import com.example.gestao_produtos.mapper.ProdutoMapper;
import com.example.gestao_produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public ProdutoResponseDTO salvar(ProdutoRequestDTO dto) {
        Produto produto = ProdutoMapper.toEntity(dto);
        Produto salvo = repository.save(produto);
        return ProdutoMapper.toResponseDTO(salvo);
    }

    // READ - LISTAR
    public List<ProdutoResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(ProdutoMapper::toResponseDTO)
                .toList();
    }

    // READ - POR ID
    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));

        return ProdutoMapper.toResponseDTO(produto);
    }

    // UPDATE
    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());

        Produto atualizado = repository.save(produto);
        return ProdutoMapper.toResponseDTO(atualizado);
    }

    // DELETE
    public void deletar(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));

        repository.delete(produto);
    }
}



