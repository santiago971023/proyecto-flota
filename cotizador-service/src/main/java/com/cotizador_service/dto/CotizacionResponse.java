package com.cotizador_service.dto;

import java.time.LocalDateTime;

public record CotizacionResponse(
        String tipoVehiculo,
        Integer kilometros,
        Double costoTotal,
        LocalDateTime fechaCotizacion
) {
}
