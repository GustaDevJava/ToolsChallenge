package com.fernandes.ToolsChallenge.adapters.in.controller.mapper;

import com.fernandes.ToolsChallenge.adapters.in.controller.dto.PagamentoDTO;
import com.fernandes.ToolsChallenge.application.core.domain.Pagamento;

public interface PagamentoDTOMapper {

    PagamentoDTO toPagamentoDTO(Pagamento pagamento);

    Pagamento toPagamento(PagamentoDTO pagamentoDTO);
}
