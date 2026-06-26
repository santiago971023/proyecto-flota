package com.flota_service.service;

import com.flota_service.client.CotizacionClient;
import com.flota_service.client.VehiculoClient;
import com.flota_service.model.CotizacionDto;
import com.flota_service.model.VehiculoDto;
import com.flota_service.model.ViajeDetalleResponse;
import org.springframework.stereotype.Service;

@Service
public class FlotaOrchestratorService {

    private final VehiculoClient vehiculoClient;
    private final CotizacionClient cotizacionClient;

    public FlotaOrchestratorService(VehiculoClient vehiculoClient, CotizacionClient cotizacionClient) {
        this.vehiculoClient = vehiculoClient;
        this.cotizacionClient = cotizacionClient;
    }

    public ViajeDetalleResponse armarViaje(Long vehiculoId, Integer kilometros) {
        // 1. Consultar el vehículo
        VehiculoDto vehiculo = vehiculoClient.obtenerVehiculoPorId(vehiculoId);

        // 2. Con el tipo de vehículo obtenido, consultar la cotización
        CotizacionDto cotizacion = cotizacionClient.obtenerCotizacion(kilometros, vehiculo.tipo());

        // 3. Armar y retornar la respuesta final
        return new ViajeDetalleResponse(
                vehiculo,
                kilometros,
                cotizacion.costoTotal()
        );
    }
}
