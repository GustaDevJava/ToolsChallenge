package com.fernandes.ToolsChallenge.application.core.usecase;

import com.fernandes.ToolsChallenge.application.core.domain.Pagamento;
import com.fernandes.ToolsChallenge.application.ports.in.BuscarPagamentosInputPort;
import com.fernandes.ToolsChallenge.application.ports.out.BuscarPagamentosOutputPort;

import java.util.List;

public class BuscarPagamentosUseCase implements BuscarPagamentosInputPort {

    private final BuscarPagamentosOutputPort buscarPagamentosOutputPort;

    private final MascaraCartaoUseCase mascaraCartaoUseCase;

    public BuscarPagamentosUseCase(BuscarPagamentosOutputPort buscarPagamentosOutputPort, MascaraCartaoUseCase mascaraCartaoUseCase) {
        this.buscarPagamentosOutputPort = buscarPagamentosOutputPort;
        this.mascaraCartaoUseCase = mascaraCartaoUseCase;
    }

    @Override
    public List<Pagamento> buscarTodosPagamentos() {
        var transacoes = buscarPagamentosOutputPort.buscarTransacoes();

        return transacoes.stream().map(transacao -> {
            Pagamento pagamento = new Pagamento();
            mascaraCartaoUseCase.mascararCartao(transacao);
            pagamento.setTransacao(transacao);

            return pagamento;
        }).toList();
    }
}
