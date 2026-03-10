package com.fernandes.ToolsChallenge.config;

import com.fernandes.ToolsChallenge.adapters.out.BuscarSolicitacaoPagamentoAdapter;
import com.fernandes.ToolsChallenge.adapters.out.SolicitacaoPagamentoAdapter;
import com.fernandes.ToolsChallenge.application.core.usecase.MascaraCartaoUseCase;
import com.fernandes.ToolsChallenge.application.core.usecase.SolicitacaoEstornoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SolicitacaoEstornoConfig {

    @Bean
    public SolicitacaoEstornoUseCase solicitacaoEstornoUseCase(
            BuscarSolicitacaoPagamentoAdapter buscarSolicitacaoPagamentoAdapter,
            SolicitacaoPagamentoAdapter solicitacaoPagamentoAdapter,
            MascaraCartaoUseCase mascaraCartaoUseCase
    ){
        return new SolicitacaoEstornoUseCase(buscarSolicitacaoPagamentoAdapter, solicitacaoPagamentoAdapter, mascaraCartaoUseCase);
    }
}
