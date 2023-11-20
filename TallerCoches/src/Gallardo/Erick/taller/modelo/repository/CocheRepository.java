package Gallardo.Erick.taller.modelo.repository;

import Gallardo.Erick.taller.modelo.domain.Coche;
import java.util.ArrayList;
import java.util.List;

public class CocheRepository {
    private List<Coche> coches = new ArrayList<>();

    public void altaCoche(Coche coche) {
        coches.add(coche);
    }

    public void eliminarCoche(String matricula) {
        coches.removeIf(coche -> coche.getMatricula().equals(matricula));
    }

    public Coche buscarCochePorMatricula(String matricula) {
        for (Coche coche : coches) {
            if (coche.getMatricula().equals(matricula)) {
                return coche;
            }
        }
        return null;
    }

    public List<Coche> obtenerTodosLosCoches() {
        return coches;
    }

    public void modificarModelo(String matricula, String nuevoModelo) {
        for (Coche coche : coches) {
            if (coche.getMatricula().equals(matricula)) {
                coche.setModelo(nuevoModelo);
                break;
            }
        }
    }
}
