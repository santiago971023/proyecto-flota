package com.crud_vehiculos.repository;

import com.crud_vehiculos.model.VehiculoElectrico;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Repository
public class VehiculoMockRepository {

    private final List<VehiculoElectrico> vehiculos = new ArrayList<>();

    public VehiculoMockRepository() {
        vehiculos.add(VehiculoElectrico.builder()
                .id(1L)
                .marca("BYD")
                .modelo("Yuan Plus")
                .tipo("CARRO")
                .build());

        vehiculos.add(VehiculoElectrico.builder()
                .id(2L)
                .marca("Stark")
                .modelo("E-Bike")
                .tipo("MOTO")
                .build());

        vehiculos.add(VehiculoElectrico.builder()
                .id(3L)
                .marca("Yutong")
                .modelo("E12")
                .tipo("BUSETA")
                .build());
    }

    public List<VehiculoElectrico> findAll() {
        return vehiculos;
    }

    public Optional<VehiculoElectrico> findById(Long id) {
        return vehiculos.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
    }

    public VehiculoElectrico save(VehiculoElectrico vehiculo) {
        // Simulación simple de autoincremento para el ID si es nuevo
        if (vehiculo.getId() == null) {
            long nuevoId = vehiculos.size() + 1;
            vehiculo.setId(nuevoId);
        }
        vehiculos.add(vehiculo);
        return vehiculo;
    }

    public boolean existsById(Long id) {
        // anyMatch revisa si algún elemento cumple la condición y devuelve true o false
        return vehiculos.stream()
                .anyMatch(v -> v.getId().equals(id));
    }

    public void deleteById(Long id) {
        // removeIf elimina de la lista todo lo que cumpla con la condición
        vehiculos.removeIf(v -> v.getId().equals(id));
    }
}
