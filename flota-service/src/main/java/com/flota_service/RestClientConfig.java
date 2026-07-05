package com.flota_service;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    public RestClient.Builder restClientBuilder(){
        return RestClient.builder();
    }

}
