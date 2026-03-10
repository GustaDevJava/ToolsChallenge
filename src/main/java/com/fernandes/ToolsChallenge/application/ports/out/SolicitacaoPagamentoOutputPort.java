package com.fernandes.ToolsChallenge.application.ports.out;

import com.fernandes.ToolsChallenge.application.core.domain.Transacao;

public interface SolicitacaoPagamentoOutputPort {

    Transacao salvarTransacao(Transacao transacao);
}
