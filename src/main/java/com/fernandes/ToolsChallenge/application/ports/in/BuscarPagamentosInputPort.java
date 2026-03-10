package com.fernandes.ToolsChallenge.application.ports.in;

import com.fernandes.ToolsChallenge.application.core.domain.Pagamento;

import java.util.List;

public interface BuscarPagamentosInputPort {

    List<Pagamento> buscarTodosPagamentos();
}
