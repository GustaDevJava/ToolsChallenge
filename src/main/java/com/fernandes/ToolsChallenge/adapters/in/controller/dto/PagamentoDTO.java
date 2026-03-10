package com.fernandes.ToolsChallenge.adapters.in.controller.dto;

import jakarta.validation.Valid;

public record PagamentoDTO(

        @Valid
        TransacaoDTO transacao
) {
}
