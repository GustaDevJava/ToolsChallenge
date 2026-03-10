package com.fernandes.ToolsChallenge.adapters.out;

import com.fernandes.ToolsChallenge.adapters.out.repository.TransacaoRepository;
import com.fernandes.ToolsChallenge.adapters.out.repository.mapper.TransacaoEntityMapper;
import com.fernandes.ToolsChallenge.application.core.domain.Transacao;
import com.fernandes.ToolsChallenge.application.ports.out.BuscarPagamentosOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarPagamentosAdapter implements BuscarPagamentosOutputPort {

    private final TransacaoRepository repository;
    private final TransacaoEntityMapper mapper;

    @Override
    public List<Transacao> buscarTransacoes() {
        var listaTransacoesEntity = repository.findAll();
        return listaTransacoesEntity.stream().map(mapper::toTransacao).toList();
    }
}
