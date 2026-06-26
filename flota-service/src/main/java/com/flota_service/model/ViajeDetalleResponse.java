package com.flota_service.model;

public record ViajeDetalleResponse(
        VehiculoDto vehiculo,
        Integer kilometrosViaje,
        Double costoEstimado
) {
}
