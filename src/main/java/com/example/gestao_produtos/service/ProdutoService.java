package com.example.gestao_produtos.service;

import com.example.gestao_produtos.domain.Produto;
import com.example.gestao_produtos.dto.request.ProdutoPatchRequestDTO;
import com.example.gestao_produtos.dto.request.ProdutoRequestDTO;
import com.example.gestao_produtos.dto.response.ProdutoResponseDTO;
import com.example.gestao_produtos.exception.ProdutoNotFoundException;
import com.example.gestao_produtos.mapper.ProdutoMapper;
import com.example.gestao_produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }


    public ProdutoResponseDTO salvar(ProdutoRequestDTO dto) {
        Produto produto = ProdutoMapper.toEntity(dto);
        Produto salvo = repository.save(produto);
        return ProdutoMapper.toResponseDTO(salvo);
    }

    public Page<ProdutoResponseDTO> listar(String nome, Pageable pageable) {

        Page<Produto> page;

        if (nome == null || nome.isBlank()) {
            page = repository.findAll(pageable);
        } else {
            page = repository.findByNomeContainingIgnoreCase(nome, pageable);
        }

        return page.map(ProdutoMapper::toResponseDTO);
    }


    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));

        return ProdutoMapper.toResponseDTO(produto);
    }


    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());

        Produto atualizado = repository.save(produto);
        return ProdutoMapper.toResponseDTO(atualizado);
    }


    public ProdutoResponseDTO atualizarParcial(Long id, ProdutoPatchRequestDTO dto) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));

        if (dto.getNome() != null) {
            produto.setNome(dto.getNome());
        }

        if (dto.getPreco() != null) {
            produto.setPreco(dto.getPreco());
        }

        if (dto.getQuantidade() != null) {
            produto.setQuantidade(dto.getQuantidade());
        }

        Produto atualizado = repository.save(produto);
        return ProdutoMapper.toResponseDTO(atualizado);
    }


    public void deletar(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));

        repository.delete(produto);
    }
}



