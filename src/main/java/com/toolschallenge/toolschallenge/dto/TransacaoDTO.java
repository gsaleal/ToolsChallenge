package com.toolschallenge.toolschallenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransacaoDTO {

    @NotBlank(message = "O número do cartão é obrigatório")
    @Size(min = 16, max = 16, message = "O número do cartão deve ter 16 dígitos")
    private String cartao;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @Valid
    private DescricaoDTO descricao;

    @Valid
    private FormaPagamentoDTO formaPagamento;
}
