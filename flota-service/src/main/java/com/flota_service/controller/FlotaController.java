package com.flota_service.controller;

import com.flota_service.model.ViajeDetalleResponse;
import com.flota_service.service.FlotaOrchestratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/flota")
public class FlotaController {

    private final FlotaOrchestratorService orchestratorService;

    public FlotaController(FlotaOrchestratorService orchestratorService) {
        this.orchestratorService = orchestratorService;
    }

    @GetMapping("/planear-viaje")
    public ResponseEntity<ViajeDetalleResponse> planearViaje(
            @RequestParam Long vehiculoId,
            @RequestParam Integer kilometros) {

        ViajeDetalleResponse respuesta = orchestratorService.armarViaje(vehiculoId, kilometros);
        return ResponseEntity.ok(respuesta);
    }
}
