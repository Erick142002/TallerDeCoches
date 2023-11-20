package Gallardo.Erick.taller.modelo.service;

import Gallardo.Erick.taller.modelo.domain.Coche;
import Gallardo.Erick.taller.modelo.repository.CocheRepository;

import java.util.List;

public class CocheService {
    private CocheRepository cocheRepository;

    public CocheService(CocheRepository cocheRepository) {
        this.cocheRepository = cocheRepository;
    }

    public void altaCoche(String matricula, String modelo) {
        Coche coche = new Coche(matricula, modelo);
        cocheRepository.altaCoche(coche);
    }

    public void eliminarCoche(String matricula) {
        cocheRepository.eliminarCoche(matricula);
    }

    public Coche buscarCochePorMatricula(String matricula) {
        return cocheRepository.buscarCochePorMatricula(matricula);
    }

    public List<Coche> obtenerTodosLosCoches() {
        return cocheRepository.obtenerTodosLosCoches();
    }

    public void modificarModelo(String matricula, String nuevoModelo) {
        cocheRepository.modificarModelo(matricula, nuevoModelo);
    }
}
