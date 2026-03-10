package com.fernandes.ToolsChallenge.application.ports.in;

import com.fernandes.ToolsChallenge.application.core.domain.Pagamento;

public interface BuscarPagamentoPorIdInputPort {

    Pagamento buscarPorId(String id);
}
