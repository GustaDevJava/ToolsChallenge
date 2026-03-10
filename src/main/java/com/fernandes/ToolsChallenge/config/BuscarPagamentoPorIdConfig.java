package com.fernandes.ToolsChallenge.config;

import com.fernandes.ToolsChallenge.adapters.out.BuscarSolicitacaoPagamentoAdapter;
import com.fernandes.ToolsChallenge.application.core.usecase.BuscarPagamentoPorIdUseCase;
import com.fernandes.ToolsChallenge.application.core.usecase.MascaraCartaoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarPagamentoPorIdConfig {

    @Bean
    public BuscarPagamentoPorIdUseCase buscarPagamentoPorIdUseCase(
            BuscarSolicitacaoPagamentoAdapter solicitacaoPagamentoAdapter,
            MascaraCartaoUseCase mascaraCartaoUseCase
    ){
        return new BuscarPagamentoPorIdUseCase(solicitacaoPagamentoAdapter, mascaraCartaoUseCase);
    }
}
