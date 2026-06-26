package com.crud_vehiculos.service;

import com.crud_vehiculos.model.VehiculoElectrico;
import com.crud_vehiculos.repository.VehiculoMockRepository;
import com.crud_vehiculos.repository.VehiculoMockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {

    private final VehiculoMockRepository vehiculoRepository;

    @Autowired
    public VehiculoService(VehiculoMockRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public List<VehiculoElectrico> obtenerTodos() {
        return vehiculoRepository.findAll();
    }

    public Optional<VehiculoElectrico> obtenerPorId(Long id) {
        return vehiculoRepository.findById(id);
    }

    public VehiculoElectrico guardar(VehiculoElectrico vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public VehiculoElectrico actualizar(Long id, VehiculoElectrico vehiculoActualizado) {
        return vehiculoRepository.findById(id)
                .map(vehiculoExistente -> {
                    vehiculoExistente.setMarca(vehiculoActualizado.getMarca());
                    vehiculoExistente.setModelo(vehiculoActualizado.getModelo());
                    vehiculoExistente.setTipo(vehiculoActualizado.getTipo());
                    return vehiculoRepository.save(vehiculoExistente);
                })
                .orElseThrow(() -> new IllegalArgumentException("Vehículo con ID " + id + " no encontrado."));
    }

    public void eliminar(Long id) {
        if (!vehiculoRepository.existsById(id)) {
            throw new IllegalArgumentException("Vehículo con ID " + id + " no encontrado.");
        }
        vehiculoRepository.deleteById(id);
    }
}
