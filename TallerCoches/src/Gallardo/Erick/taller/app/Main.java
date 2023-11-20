package Gallardo.Erick.taller.app;

import Gallardo.Erick.taller.controller.CocheController;

public class Main {
    public static void main(String[] args) {
        CocheController cocheController = new CocheController();
        
        
        cocheController.altaCoche("ABC1234", "Seat Arona");
        cocheController.altaCoche("XYZ5678", "Ford Fiesta");
        cocheController.altaCoche("DEF4321", "Volkswagen Golf");

        
        cocheController.mostrarCoches();

        
        cocheController.modificarModelo("XYZ5678", "Ford Focus");

        
        cocheController.buscarCochePorMatricula("XYZ5678");

        
        cocheController.eliminarCoche("ABC1234");

        
        cocheController.mostrarCoches();
    }
}
