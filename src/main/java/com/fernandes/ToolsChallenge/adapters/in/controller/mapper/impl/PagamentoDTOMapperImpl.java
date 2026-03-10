package com.fernandes.ToolsChallenge.adapters.in.controller.mapper.impl;

import com.fernandes.ToolsChallenge.adapters.in.controller.dto.DescricaoDTO;
import com.fernandes.ToolsChallenge.adapters.in.controller.dto.FormaPagamentoDTO;
import com.fernandes.ToolsChallenge.adapters.in.controller.dto.PagamentoDTO;
import com.fernandes.ToolsChallenge.adapters.in.controller.dto.TransacaoDTO;
import com.fernandes.ToolsChallenge.adapters.in.controller.mapper.PagamentoDTOMapper;
import com.fernandes.ToolsChallenge.application.core.domain.Descricao;
import com.fernandes.ToolsChallenge.application.core.domain.FormaPagamento;
import com.fernandes.ToolsChallenge.application.core.domain.Pagamento;
import com.fernandes.ToolsChallenge.application.core.domain.Transacao;
import org.springframework.stereotype.Component;

@Component
public class PagamentoDTOMapperImpl implements PagamentoDTOMapper {


    @Override
    public PagamentoDTO toPagamentoDTO(Pagamento pagamento) {
        FormaPagamentoDTO formaPagamentoDTO = new FormaPagamentoDTO
                (pagamento.getTransacao().getFormaPagamento().getTipo(), pagamento.getTransacao().getFormaPagamento().getParcelas());

        DescricaoDTO descricaoDTO = new DescricaoDTO(
                pagamento.getTransacao().getDescricao().getValor(),
                pagamento.getTransacao().getDescricao().getDataHora(),
                pagamento.getTransacao().getDescricao().getEstabelecimento(),
                pagamento.getTransacao().getDescricao().getNsu(),
                pagamento.getTransacao().getDescricao().getCodigoAutorizacao(),
                pagamento.getTransacao().getDescricao().getStatus()
        );

        TransacaoDTO transacaoDTO = new TransacaoDTO(
                pagamento.getTransacao().getCartao(),
                pagamento.getTransacao().getId(),
                descricaoDTO,
                formaPagamentoDTO
        );

        return new PagamentoDTO(transacaoDTO);
    }

    @Override
    public Pagamento toPagamento(PagamentoDTO pagamentoDTO) {
        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setParcelas(pagamentoDTO.transacao().formaPagamento().parcelas());
        formaPagamento.setTipo(pagamentoDTO.transacao().formaPagamento().tipo());

        Descricao descricao = new Descricao();
        descricao.setValor(pagamentoDTO.transacao().descricao().valor());
        descricao.setDataHora(pagamentoDTO.transacao().descricao().dataHora());
        descricao.setEstabelecimento(pagamentoDTO.transacao().descricao().estabelecimento());


        Transacao transacao = new Transacao();
        transacao.setId(pagamentoDTO.transacao().id());
        transacao.setCartao(pagamentoDTO.transacao().cartao());
        transacao.setDescricao(descricao);
        transacao.setFormaPagamento(formaPagamento);

        return new Pagamento(transacao);
    }
}
