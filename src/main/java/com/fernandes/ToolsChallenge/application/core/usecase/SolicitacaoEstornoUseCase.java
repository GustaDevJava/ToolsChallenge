package com.fernandes.ToolsChallenge.application.core.usecase;

import com.fernandes.ToolsChallenge.application.core.domain.Pagamento;
import com.fernandes.ToolsChallenge.application.core.domain.Transacao;
import com.fernandes.ToolsChallenge.application.core.domain.enums.Status;
import com.fernandes.ToolsChallenge.application.core.exception.ApiException;
import com.fernandes.ToolsChallenge.application.core.exception.ObjectNotFoundException;
import com.fernandes.ToolsChallenge.application.ports.in.SolicitacaoEstornoInputPort;
import com.fernandes.ToolsChallenge.application.ports.out.BuscarSolicitacaoPagamentoOutputPort;
import com.fernandes.ToolsChallenge.application.ports.out.SolicitacaoPagamentoOutputPort;

public class SolicitacaoEstornoUseCase implements SolicitacaoEstornoInputPort {

    private final BuscarSolicitacaoPagamentoOutputPort buscarSolicitacaoPagamentoOutputPort;

    private final SolicitacaoPagamentoOutputPort solicitacaoPagamentoOutputPort;

    private final MascaraCartaoUseCase mascaraCartaoUseCase;

    public SolicitacaoEstornoUseCase(BuscarSolicitacaoPagamentoOutputPort buscarSolicitacaoPagamentoOutputPort, SolicitacaoPagamentoOutputPort solicitacaoPagamentoOutputPort, MascaraCartaoUseCase mascaraCartaoUseCase) {
        this.buscarSolicitacaoPagamentoOutputPort = buscarSolicitacaoPagamentoOutputPort;
        this.solicitacaoPagamentoOutputPort = solicitacaoPagamentoOutputPort;
        this.mascaraCartaoUseCase = mascaraCartaoUseCase;
    }

    @Override
    public Pagamento solicitacaoEstorno(String id) {
        var transacaoBD = buscarSolicitacaoPagamentoOutputPort.buscarTransacao(id);

        if (!transacaoBD.isPresent()){
            throw new ObjectNotFoundException("Pagamento não encontrado para id: "+ id);
        }

        Transacao transacao = transacaoBD.get();

        if(transacao.getDescricao().getStatus().equals(Status.NEGADO)){
            throw new ApiException(400,"Pagamento não pode ser estornado!");
        }

        transacao.getDescricao().setStatus(Status.CANCELADO);

        transacao = solicitacaoPagamentoOutputPort.salvarTransacao(transacao);

        mascaraCartaoUseCase.mascararCartao(transacao);
        return new Pagamento(transacao);
    }
}
