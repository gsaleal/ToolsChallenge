package com.toolschallenge.toolschallenge.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cartao;
    @Embedded
    private Descricao descricao;
    @Embedded
    private FormaPagamento formaPagamento;
}
