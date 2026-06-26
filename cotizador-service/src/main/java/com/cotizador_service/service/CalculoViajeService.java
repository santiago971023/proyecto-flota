package com.cotizador_service.service;



import com.cotizador_service.dto.CotizacionResponse;
import com.cotizador_service.model.TipoVehiculo;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class CalculoViajeService {

    // Tarifas fijas por kilómetro (valores de ejemplo)
    private static final double TARIFA_MOTO = 800.0;
    private static final double TARIFA_CARRO = 1500.0;
    private static final double TARIFA_BUSETA = 2800.0;

    public CotizacionResponse calcularCoste(Integer kilometros, TipoVehiculo tipo) {

        double tarifaPorKilometro = switch (tipo) {
            case MOTO -> TARIFA_MOTO;
            case CARRO -> TARIFA_CARRO;
            case BUSETA -> TARIFA_BUSETA;
        };

        double costoTotal = kilometros * tarifaPorKilometro;

        return new CotizacionResponse(
                tipo.name(),
                kilometros,
                costoTotal,
                LocalDateTime.now()
        );
    }
}