package com.toolschallenge.toolschallenge.controller;

import com.toolschallenge.toolschallenge.dto.TransacaoJsonDTO;
import com.toolschallenge.toolschallenge.service.TransacaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@AllArgsConstructor
public class TransacaoController {
    private final TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<?> createTransaction(@Valid @RequestBody TransacaoJsonDTO transaction, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        TransacaoJsonDTO response = transacaoService.processarTransacao(transaction.getTransacao());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/estorno/{id}")
    @Transactional
    public ResponseEntity<TransacaoJsonDTO> createEstorno(@PathVariable Long id) {
        TransacaoJsonDTO response = transacaoService.processarEstorno(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TransacaoJsonDTO>> getAllTransactions() {
        return ResponseEntity.ok(transacaoService.getAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransacaoJsonDTO> getTransactionsById(@PathVariable Long id) {
        return ResponseEntity.ok(transacaoService.getTransacaoById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transacaoService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
