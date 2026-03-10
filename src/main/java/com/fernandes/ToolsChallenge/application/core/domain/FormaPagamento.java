package com.fernandes.ToolsChallenge.application.core.domain;

import com.fernandes.ToolsChallenge.application.core.domain.enums.TipoPagamento;

public class FormaPagamento {

    private TipoPagamento tipo;
    private  String parcelas;

    public FormaPagamento(){}

    public FormaPagamento(TipoPagamento tipo, String parcelas) {
        this.tipo = tipo;
        this.parcelas = parcelas;
    }

    public TipoPagamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoPagamento tipo) {
        this.tipo = tipo;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }
}
