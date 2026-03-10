package com.fernandes.ToolsChallenge.application.ports.out;

import com.fernandes.ToolsChallenge.application.core.domain.Transacao;

import java.util.List;

public interface BuscarPagamentosOutputPort {

    List<Transacao> buscarTransacoes();
}
