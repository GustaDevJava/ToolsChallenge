package com.fernandes.ToolsChallenge.adapters.out;

import com.fernandes.ToolsChallenge.adapters.out.repository.TransacaoRepository;
import com.fernandes.ToolsChallenge.adapters.out.repository.mapper.TransacaoEntityMapper;
import com.fernandes.ToolsChallenge.application.core.domain.Transacao;
import com.fernandes.ToolsChallenge.application.ports.out.SolicitacaoPagamentoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SolicitacaoPagamentoAdapter implements SolicitacaoPagamentoOutputPort {

    private final TransacaoRepository repository;

    private final TransacaoEntityMapper mapper;

    @Override
    public Transacao salvarTransacao(Transacao transacao) {
        var transacaoEntity = mapper.toTransacaoEntity(transacao);
        transacaoEntity = repository.save(transacaoEntity);
        return mapper.toTransacao(transacaoEntity);
    }
}
