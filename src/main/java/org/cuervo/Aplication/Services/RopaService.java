package org.cuervo.Aplication.Services;

import org.cuervo.Domain.Ropa;
import org.cuervo.Interface.ropaRepository;

import java.util.List;

public class RopaService {
    private final ropaRepository repository;


    public RopaService(ropaRepository repository) {
        this.repository = repository;
    }


    public void crearRopa(Ropa ropa) {
        repository.save(ropa);
    }

    public List<Ropa> listarRopas() {
        return repository.findAll();
    }

    public Ropa buscarRopaPorId(int id) {
        return repository.findById(id);
    }

    public void actualizarRopa(Ropa ropa) {
        repository.update(ropa);
    }

    public void eliminarRopa(Ropa ropa) {
        repository.delete(ropa);
    }

    public Ropa obtenerRopa(int id) {
        return repository.findById(id);
    }
}
