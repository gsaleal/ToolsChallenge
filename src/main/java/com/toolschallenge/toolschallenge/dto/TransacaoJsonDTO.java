package com.toolschallenge.toolschallenge.dto;

import jakarta.validation.Valid;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransacaoJsonDTO {
    @Valid
    private TransacaoDTO transacao;
}

