package com.fernandes.ToolsChallenge.adapters.out;

import com.fernandes.ToolsChallenge.adapters.out.repository.TransacaoRepository;
import com.fernandes.ToolsChallenge.adapters.out.repository.mapper.TransacaoEntityMapper;
import com.fernandes.ToolsChallenge.application.core.domain.Transacao;
import com.fernandes.ToolsChallenge.application.ports.out.BuscarSolicitacaoPagamentoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BuscarSolicitacaoPagamentoAdapter implements BuscarSolicitacaoPagamentoOutputPort {

    private final TransacaoRepository repository;

    private final TransacaoEntityMapper mapper;

    @Override
    public Optional<Transacao> buscarTransacao(String id) {
        var transacaoEntity = repository.findById(id);
        return transacaoEntity.map(mapper::toTransacao);
    }
}
