package com.toolschallenge.toolschallenge.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescricaoDTO {

    @NotNull(message = "O valor da transação é obrigatório")
    @Min(value = 1, message = "O valor da transação deve ser maior que zero")
    private String valor;

    @NotNull(message = "Deve ser informado uma hora valida")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataHora;

    private String estabelecimento;

    private String nsu;

    private String codigoAutorizacao;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private StatusTransacaoENUM status;
}

