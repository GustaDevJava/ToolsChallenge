package com.fernandes.ToolsChallenge.application.ports.out;

import com.fernandes.ToolsChallenge.application.core.domain.Transacao;

import java.util.Optional;

public interface BuscarSolicitacaoPagamentoOutputPort {

    Optional<Transacao> buscarTransacao(String id);
}
