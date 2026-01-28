package com.example.gestao_produtos.controller;

import com.example.gestao_produtos.domain.Produto;
import com.example.gestao_produtos.dto.request.ProdutoPatchRequestDTO;
import com.example.gestao_produtos.dto.request.ProdutoRequestDTO;
import com.example.gestao_produtos.dto.response.ProdutoResponseDTO;
import com.example.gestao_produtos.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> salvar(
            @RequestBody @Valid ProdutoRequestDTO dto
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.salvar(dto));
    }


    @GetMapping
    public Page<ProdutoResponseDTO> listar(
            @RequestParam(required = false) String nome,
            Pageable pageable
    ) {
        return service.listar(nome, pageable);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid ProdutoRequestDTO dto) {

        return ResponseEntity.ok(service.atualizar(id, dto));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizarParcial(
            @PathVariable Long id,
            @RequestBody ProdutoPatchRequestDTO dto
    ) {
        return ResponseEntity.ok(service.atualizarParcial(id, dto));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

