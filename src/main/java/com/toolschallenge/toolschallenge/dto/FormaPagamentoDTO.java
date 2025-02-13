package com.toolschallenge.toolschallenge.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormaPagamentoDTO {

    private FormaPagamentoENUM tipo;

    @NotBlank(message = "O numero de parcelas é obrigatório")
    private String parcelas;
}
