package com.fernandes.ToolsChallenge.adapters.in.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fernandes.ToolsChallenge.application.core.domain.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DescricaoDTO(

        @NotNull(message = "O campo não pode ser nulo.")
        BigDecimal valor,

        @NotNull(message = "O campo não pode ser nulo.")
        @JsonFormat( pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime dataHora,

        @NotBlank(message = "O campo não pode ser vazio ou nulo.")
        String estabelecimento,

        String nsu,
        String codigoAutorizacao,
        Status status
) {
}
