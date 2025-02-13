package com.toolschallenge.toolschallenge.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormaPagamento {

    private String tipo;
    private Integer parcelas;
}