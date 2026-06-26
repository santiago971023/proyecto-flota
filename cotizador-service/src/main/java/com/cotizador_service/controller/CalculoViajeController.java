package com.cotizador_service.controller;

import com.cotizador_service.service.CalculoViajeService;
import com.cotizador_service.dto.CotizacionResponse;
import com.cotizador_service.model.TipoVehiculo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cotizaciones")
public class CalculoViajeController {

    private final CalculoViajeService calculoViajeService;

    // Inyección de dependencias por constructor (buena práctica)
    public CalculoViajeController(CalculoViajeService calculoViajeService) {
        this.calculoViajeService = calculoViajeService;
    }

    @GetMapping("/calcular")
    public ResponseEntity<CotizacionResponse> obtenerCotizacion(
            @RequestParam Integer kilometros,
            @RequestParam TipoVehiculo tipoVehiculo) {

        CotizacionResponse respuesta = calculoViajeService.calcularCoste(kilometros, tipoVehiculo);
        return ResponseEntity.ok(respuesta);
    }
}
