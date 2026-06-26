package com.flota_service.client;

import com.flota_service.model.CotizacionDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class CotizacionClient {

    private final RestClient restClient;

    public CotizacionClient(@Value("${cotizacion.service.url}") String baseUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public CotizacionDto obtenerCotizacion(Integer kilometros, String tipoVehiculo) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/v1/cotizaciones/calcular")
                        .queryParam("kilometros", kilometros)
                        .queryParam("tipoVehiculo", tipoVehiculo)
                        .build())
                .retrieve()
                .body(CotizacionDto.class);
    }
}
