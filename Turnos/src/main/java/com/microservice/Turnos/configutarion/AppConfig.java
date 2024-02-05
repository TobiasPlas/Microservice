package com.microservice.Turnos.configutarion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    
    @Bean("apiConsumir")
    public RestTemplate registrarRestTemplate (){
        return new RestTemplate();
    }
    
}
