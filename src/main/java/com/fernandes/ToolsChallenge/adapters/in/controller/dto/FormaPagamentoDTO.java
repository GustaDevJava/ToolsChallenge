package com.fernandes.ToolsChallenge.adapters.in.controller.dto;

import com.fernandes.ToolsChallenge.application.core.domain.enums.TipoPagamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FormaPagamentoDTO(

        @NotNull(message = "O campo não pode ser nulo.")
        TipoPagamento tipo,

        @NotBlank(message = "O campo não pode ser vazio ou nulo.")
        String parcelas
) {
}
