package com.fernandes.ToolsChallenge.adapters.out.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "transacao")
public class TransacaoEntity {

    private String cartao;

    @Id
    private String id;
    private DescricaoEntity descricao;
    private FormaPagamentoEntity formaPagamento;
}
