package com.fernandes.ToolsChallenge.config;

import com.fernandes.ToolsChallenge.application.core.usecase.MascaraCartaoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MascaraCartaoConfig {

    @Bean
    public MascaraCartaoUseCase mascaraCartaoUseCase(

    ){
        return new MascaraCartaoUseCase();
    }
}
