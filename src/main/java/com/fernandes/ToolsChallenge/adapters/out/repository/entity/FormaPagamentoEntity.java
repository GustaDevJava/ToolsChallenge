package com.fernandes.ToolsChallenge.adapters.out.repository.entity;

import com.fernandes.ToolsChallenge.application.core.domain.enums.TipoPagamento;
import lombok.Data;

@Data
public class FormaPagamentoEntity {

    private TipoPagamento tipo;
    private String parcelas;
}
