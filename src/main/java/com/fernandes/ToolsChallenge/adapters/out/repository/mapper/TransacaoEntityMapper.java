package com.fernandes.ToolsChallenge.adapters.out.repository.mapper;

import com.fernandes.ToolsChallenge.adapters.out.repository.entity.TransacaoEntity;
import com.fernandes.ToolsChallenge.application.core.domain.Transacao;

public interface TransacaoEntityMapper {

    TransacaoEntity toTransacaoEntity(Transacao transacao);

    Transacao toTransacao(TransacaoEntity transacaoEntity);
}
