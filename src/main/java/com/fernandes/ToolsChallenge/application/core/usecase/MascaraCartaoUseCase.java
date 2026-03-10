package com.fernandes.ToolsChallenge.application.core.usecase;

import com.fernandes.ToolsChallenge.application.core.domain.Transacao;
import com.fernandes.ToolsChallenge.application.core.exception.ApiException;

public class MascaraCartaoUseCase {

    public void mascararCartao(Transacao transacao) {
        String cartao = transacao.getCartao();

        if(cartao.length() < 16){
            throw new ApiException(400, "Número do cartão não inconsistente.");
        }

        String inicio = cartao.substring(0,4);
        String fim = cartao.substring(12, 16);

        String mascara = "*".repeat(cartao.length() - 8);


        transacao.setCartao(inicio+mascara+fim);
    }

}
