package com.fernandes.ToolsChallenge.config;

import com.fernandes.ToolsChallenge.adapters.out.BuscarSolicitacaoPagamentoAdapter;
import com.fernandes.ToolsChallenge.adapters.out.SolicitacaoPagamentoAdapter;
import com.fernandes.ToolsChallenge.application.core.usecase.MascaraCartaoUseCase;
import com.fernandes.ToolsChallenge.application.core.usecase.SolicitacaoPagamentoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SolicitacaoPagamentoConfig {

    @Bean
    public SolicitacaoPagamentoUseCase solicitacaoPagamentoUseCase(
            SolicitacaoPagamentoAdapter solicitacaoPagamentoAdapter,
            BuscarSolicitacaoPagamentoAdapter buscarSolicitacaoPagamentoAdapter,
            MascaraCartaoUseCase mascaraCartaoUseCase
    ){
        return new SolicitacaoPagamentoUseCase(solicitacaoPagamentoAdapter, buscarSolicitacaoPagamentoAdapter, mascaraCartaoUseCase);
    }
}
