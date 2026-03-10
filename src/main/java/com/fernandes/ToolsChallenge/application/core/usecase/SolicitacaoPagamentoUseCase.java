package com.fernandes.ToolsChallenge.application.core.usecase;

import com.fernandes.ToolsChallenge.application.core.domain.Descricao;
import com.fernandes.ToolsChallenge.application.core.domain.Pagamento;
import com.fernandes.ToolsChallenge.application.core.domain.Transacao;
import com.fernandes.ToolsChallenge.application.core.domain.enums.Status;
import com.fernandes.ToolsChallenge.application.ports.in.SolicitacaoPagamentoInputPort;
import com.fernandes.ToolsChallenge.application.ports.out.BuscarSolicitacaoPagamentoOutputPort;
import com.fernandes.ToolsChallenge.application.ports.out.SolicitacaoPagamentoOutputPort;

import java.util.concurrent.ThreadLocalRandom;

public class SolicitacaoPagamentoUseCase implements SolicitacaoPagamentoInputPort {

    public final SolicitacaoPagamentoOutputPort solicitacaoPagamentoOutputPort;
    public final BuscarSolicitacaoPagamentoOutputPort buscarSolicitacaoPagamentoOutputPort;
    public final MascaraCartaoUseCase mascaraCartaoUseCase;

    public SolicitacaoPagamentoUseCase(SolicitacaoPagamentoOutputPort solicitacaoPagamentoOutputPort, BuscarSolicitacaoPagamentoOutputPort buscarSolicitacaoPagamentoOutputPort, MascaraCartaoUseCase mascaraCartaoUseCase) {
        this.solicitacaoPagamentoOutputPort = solicitacaoPagamentoOutputPort;
        this.buscarSolicitacaoPagamentoOutputPort = buscarSolicitacaoPagamentoOutputPort;
        this.mascaraCartaoUseCase = mascaraCartaoUseCase;
    }

    @Override
    public Pagamento solicitarPagamento(Pagamento pagamento){
        Transacao transacao = pagamento.getTransacao();

        var transacaoBD = buscarSolicitacaoPagamentoOutputPort.buscarTransacao(transacao.getId());

        if (transacaoBD.isPresent()){
            mascaraCartaoUseCase.mascararCartao(transacaoBD.get());
            return new Pagamento(transacaoBD.get());
        }

        Descricao descricao = pagamento.getTransacao().getDescricao();
        descricao.setNsu("1234567890");
        descricao.setCodigoAutorizacao(String.valueOf(ThreadLocalRandom.current()
                .nextLong(100_000_000L, 1_000_000_000L)));


        boolean aprovada = ThreadLocalRandom.current().nextBoolean();

        if (aprovada){
            descricao.setStatus(Status.AUTORIZADO);
        }else {
            descricao.setStatus(Status.NEGADO);
        }

        transacao.setDescricao(descricao);
        transacao = solicitacaoPagamentoOutputPort.salvarTransacao(pagamento.getTransacao());

        mascaraCartaoUseCase.mascararCartao(transacao);
        return new Pagamento(transacao);
    }


}
