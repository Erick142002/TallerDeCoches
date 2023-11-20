package Gallardo.Erick.taller.view;
import Gallardo.Erick.taller.modelo.domain.Coche;
import Gallardo.Erick.taller.modelo.service.CocheService;

import java.util.List;
import java.util.Scanner;

public class CocheConsoleView {
    private CocheService cocheService;
    private Scanner scanner;

    public CocheConsoleView(CocheService cocheService) {
        this.cocheService = cocheService;
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("===== Menú =====");
            System.out.println("1. Alta de coche");
            System.out.println("2. Mostrar todos los coches");
            System.out.println("3. Modificar modelo de coche");
            System.out.println("4. Buscar coche por matrícula");
            System.out.println("5. Eliminar coche");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    altaCoche();
                    break;
                case 2:
                    mostrarCoches(null);
                    break;
                case 3:
                    modificarModelo();
                    break;
                case 4:
                    buscarCochePorMatricula();
                    break;
                case 5:
                    eliminarCoche();
                    break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 6);
    }

    public void mostrarCoches(List<Coche> coches) {
        if (coches.isEmpty()) {
            System.out.println("No hay coches registrados.");
        } else {
            System.out.println("===== Listado de Coches =====");
            for (Coche coche : coches) {
                System.out.println("Matrícula: " + coche.getMatricula());
                System.out.println("Modelo: " + coche.getModelo());
                System.out.println("===============");
            }
        }
    }

    private void altaCoche() {
        System.out.print("Introduce la matrícula del coche: ");
        String matricula = scanner.nextLine();
        System.out.print("Introduce el modelo del coche: ");
        String modelo = scanner.nextLine();

        cocheService.altaCoche(matricula, modelo);
        System.out.println("Coche dado de alta exitosamente.");
    }

    private void modificarModelo() {
        System.out.print("Introduce la matrícula del coche a modificar: ");
        String matricula = scanner.nextLine();
        System.out.print("Introduce el nuevo modelo: ");
        String nuevoModelo = scanner.nextLine();

        cocheService.modificarModelo(matricula, nuevoModelo);
        System.out.println("Modelo del coche modificado exitosamente.");
    }

    private void buscarCochePorMatricula() {
        System.out.print("Introduce la matrícula del coche a buscar: ");
        String matricula = scanner.nextLine();

        Coche coche = cocheService.buscarCochePorMatricula(matricula);
        if (coche != null) {
            System.out.println("Coche encontrado:");
            System.out.println("Matrícula: " + coche.getMatricula());
            System.out.println("Modelo: " + coche.getModelo());
        } else {
            System.out.println("No se encontró el coche con matrícula " + matricula);
        }
    }

    private void eliminarCoche() {
        System.out.print("Introduce la matrícula del coche a eliminar: ");
        String matricula = scanner.nextLine();

        cocheService.eliminarCoche(matricula);
        System.out.println("Coche eliminado exitosamente.");
    }
}
