package com.flota_service.client;


import com.flota_service.model.VehiculoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class VehiculoClient {

    private final RestClient restClient;

    public VehiculoClient(@Value("${vehiculo.service.url}") String baseUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public VehiculoDto obtenerVehiculoPorId(Long id) {
        return restClient.get()
                .uri("/api/v1/vehiculos/{id}", id)
                .retrieve()
                .body(VehiculoDto.class);
    }
}
