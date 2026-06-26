package com.crud_vehiculos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehiculoElectrico {
    private Long id;
    private String marca;
    private String modelo;
    private String tipo; // ej. "carro", "moto", "buseta"


}
