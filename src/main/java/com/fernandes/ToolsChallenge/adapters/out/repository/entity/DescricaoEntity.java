package com.fernandes.ToolsChallenge.adapters.out.repository.entity;

import com.fernandes.ToolsChallenge.application.core.domain.enums.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DescricaoEntity {

    private BigDecimal valor;
    private LocalDateTime dataHora;
    private String estabelecimento;
    private String nsu;
    private String codigoAutorizacao;
    private Status status;
}
