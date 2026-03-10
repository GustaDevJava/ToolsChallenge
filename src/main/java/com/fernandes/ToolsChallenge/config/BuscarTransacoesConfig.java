package com.fernandes.ToolsChallenge.config;

import com.fernandes.ToolsChallenge.adapters.out.BuscarPagamentosAdapter;
import com.fernandes.ToolsChallenge.application.core.usecase.BuscarPagamentosUseCase;
import com.fernandes.ToolsChallenge.application.core.usecase.MascaraCartaoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarTransacoesConfig {

    @Bean
    public BuscarPagamentosUseCase buscarPagamentosUseCase(
            BuscarPagamentosAdapter buscarPagamentosAdapter,
            MascaraCartaoUseCase mascaraCartaoUseCase
    ){
        return new BuscarPagamentosUseCase(buscarPagamentosAdapter, mascaraCartaoUseCase);
    }
}
