package com.fernandes.ToolsChallenge.application.core.usecase;

import com.fernandes.ToolsChallenge.application.core.domain.Pagamento;
import com.fernandes.ToolsChallenge.application.core.exception.ObjectNotFoundException;
import com.fernandes.ToolsChallenge.application.ports.in.BuscarPagamentoPorIdInputPort;
import com.fernandes.ToolsChallenge.application.ports.out.BuscarSolicitacaoPagamentoOutputPort;

public class BuscarPagamentoPorIdUseCase implements BuscarPagamentoPorIdInputPort {

    private final BuscarSolicitacaoPagamentoOutputPort buscarSolicitacaoPagamentoOutputPort;

    private final MascaraCartaoUseCase mascaraCartaoUseCase;

    public BuscarPagamentoPorIdUseCase(BuscarSolicitacaoPagamentoOutputPort buscarSolicitacaoPagamentoOutputPort, MascaraCartaoUseCase mascaraCartaoUseCase) {
        this.buscarSolicitacaoPagamentoOutputPort = buscarSolicitacaoPagamentoOutputPort;
        this.mascaraCartaoUseCase = mascaraCartaoUseCase;
    }

    @Override
    public Pagamento buscarPorId(String id){
        var transacao = buscarSolicitacaoPagamentoOutputPort.buscarTransacao(id);

        if (!transacao.isPresent()){
            throw new ObjectNotFoundException("Transação não encontrada");
        }

        mascaraCartaoUseCase.mascararCartao(transacao.get());
        return new Pagamento(transacao.get());
    }
}
