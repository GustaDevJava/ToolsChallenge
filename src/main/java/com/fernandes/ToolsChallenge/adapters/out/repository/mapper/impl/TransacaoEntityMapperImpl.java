package com.fernandes.ToolsChallenge.adapters.out.repository.mapper.impl;

import com.fernandes.ToolsChallenge.adapters.out.repository.entity.DescricaoEntity;
import com.fernandes.ToolsChallenge.adapters.out.repository.entity.FormaPagamentoEntity;
import com.fernandes.ToolsChallenge.adapters.out.repository.entity.TransacaoEntity;
import com.fernandes.ToolsChallenge.adapters.out.repository.mapper.TransacaoEntityMapper;
import com.fernandes.ToolsChallenge.application.core.domain.Descricao;
import com.fernandes.ToolsChallenge.application.core.domain.FormaPagamento;
import com.fernandes.ToolsChallenge.application.core.domain.Transacao;
import org.springframework.stereotype.Component;

@Component
public class TransacaoEntityMapperImpl implements TransacaoEntityMapper {


    @Override
    public TransacaoEntity toTransacaoEntity(Transacao transacao) {
        FormaPagamentoEntity formaPagamentoEntity = new FormaPagamentoEntity();
        formaPagamentoEntity.setParcelas(transacao.getFormaPagamento().getParcelas());
        formaPagamentoEntity.setTipo(transacao.getFormaPagamento().getTipo());

        DescricaoEntity descricaoEntity = new DescricaoEntity();
        descricaoEntity.setValor(transacao.getDescricao().getValor());
        descricaoEntity.setDataHora(transacao.getDescricao().getDataHora());
        descricaoEntity.setEstabelecimento(transacao.getDescricao().getEstabelecimento());
        descricaoEntity.setNsu(transacao.getDescricao().getNsu());
        descricaoEntity.setCodigoAutorizacao(transacao.getDescricao().getCodigoAutorizacao());
        descricaoEntity.setStatus(transacao.getDescricao().getStatus());

        TransacaoEntity transacaoEntity = new TransacaoEntity();
        transacaoEntity.setId(transacao.getId());
        transacaoEntity.setCartao(transacao.getCartao());
        transacaoEntity.setDescricao(descricaoEntity);
        transacaoEntity.setFormaPagamento(formaPagamentoEntity);

        return transacaoEntity;
    }

    @Override
    public Transacao toTransacao(TransacaoEntity transacaoEntity) {
        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setParcelas(transacaoEntity.getFormaPagamento().getParcelas());
        formaPagamento.setTipo(transacaoEntity.getFormaPagamento().getTipo());

        Descricao descricao = new Descricao();
        descricao.setValor(transacaoEntity.getDescricao().getValor());
        descricao.setDataHora(transacaoEntity.getDescricao().getDataHora());
        descricao.setEstabelecimento(transacaoEntity.getDescricao().getEstabelecimento());
        descricao.setNsu(transacaoEntity.getDescricao().getNsu());
        descricao.setCodigoAutorizacao(transacaoEntity.getDescricao().getCodigoAutorizacao());
        descricao.setStatus(transacaoEntity.getDescricao().getStatus());

        Transacao transacao = new Transacao();
        transacao.setId(transacaoEntity.getId());
        transacao.setCartao(transacaoEntity.getCartao());
        transacao.setDescricao(descricao);
        transacao.setFormaPagamento(formaPagamento);

        return transacao;
    }
}
