package com.fernandes.ToolsChallenge.adapters.in.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TransacaoDTO(

        @NotBlank(message = "O campo não pode ser vazio ou nulo.")
        String cartao,

        @NotBlank(message = "O campo não pode ser vazio ou nulo.")
        String id,

        @Valid
        @NotNull(message = "O campo não pode ser nulo.")
        DescricaoDTO descricao,

        @Valid
        @NotNull(message = "O campo não pode ser nulo.")
        FormaPagamentoDTO formaPagamento
) {
}
