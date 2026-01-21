package com.example.gestao_produtos.controller;

import com.example.gestao_produtos.domain.Produto;
import com.example.gestao_produtos.dto.request.ProdutoRequestDTO;
import com.example.gestao_produtos.dto.response.ProdutoResponseDTO;
import com.example.gestao_produtos.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> salvar(
            @RequestBody @Valid ProdutoRequestDTO dto) {

        ProdutoResponseDTO response = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // READ - LISTAR
    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    // READ - POR ID
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid ProdutoRequestDTO dto) {

        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

