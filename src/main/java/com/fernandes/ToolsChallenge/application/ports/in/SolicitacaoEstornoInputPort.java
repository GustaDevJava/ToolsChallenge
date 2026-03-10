package com.fernandes.ToolsChallenge.application.ports.in;

import com.fernandes.ToolsChallenge.application.core.domain.Pagamento;

public interface SolicitacaoEstornoInputPort {

    Pagamento solicitacaoEstorno(String id);
}
