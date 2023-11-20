package Gallardo.Erick.taller.controller;
import Gallardo.Erick.taller.modelo.repository.CocheRepository;
import Gallardo.Erick.taller.modelo.service.CocheService;
import Gallardo.Erick.taller.view.CocheConsoleView;
import Gallardo.Erick.taller.modelo.domain.Coche;

import java.util.List;

public class CocheController {
    private CocheService cocheService;
    private CocheConsoleView cocheConsoleView;

    public CocheController() {
        cocheService = new CocheService(new CocheRepository());
        cocheConsoleView = new CocheConsoleView(cocheService);
    }

    public void altaCoche(String matricula, String modelo) {
        cocheService.altaCoche(matricula, modelo);
        System.out.println("Coche dado de alta exitosamente.");
    }

    public void mostrarCoches() {
        List<Coche> coches = cocheService.obtenerTodosLosCoches();
        cocheConsoleView.mostrarCoches(coches);
    }

    public void modificarModelo(String matricula, String nuevoModelo) {
        cocheService.modificarModelo(matricula, nuevoModelo);
        System.out.println("Modelo del coche modificado exitosamente.");
    }

    public void buscarCochePorMatricula(String matricula) {
        Coche coche = cocheService.buscarCochePorMatricula(matricula);
        if (coche != null) {
            System.out.println("Coche encontrado:");
            System.out.println("Matrícula: " + coche.getMatricula());
            System.out.println("Modelo: " + coche.getModelo());
        } else {
            System.out.println("No se encontró el coche con matrícula " + matricula);
        }
    }

    public void eliminarCoche(String matricula) {
        cocheService.eliminarCoche(matricula);
        System.out.println("Coche eliminado exitosamente.");
    }
}
