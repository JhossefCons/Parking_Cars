import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parking parking = new Parking("Parking Centro", 10);

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Entrada de coche");
            System.out.println("2. Salida de coche");
            System.out.println("3. Mostrar parking");
            System.out.println("4. Salir del programa");
            System.out.print("Elija una opción: ");
            
            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida. Introduzca un número entre 1 y 4.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Introduzca la matrícula del coche: ");
                    String matriculaEntrada = scanner.nextLine();
                    System.out.print("Introduzca la plaza: ");
                    int plazaEntrada;
                    try {
                        plazaEntrada = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Plaza no válida.");
                        continue;
                    }

                    try {
                        parking.entrada(matriculaEntrada, plazaEntrada);
                        System.out.println("Coche aparcado correctamente.");
                    } catch (ParkingException e) {
                        System.out.println("Error: " + e.getMessage() + " - Matrícula: " + e.getMatricula());
                    }
                    break;

                case 2:
                    System.out.print("Introduzca la matrícula del coche: ");
                    String matriculaSalida = scanner.nextLine();
                    try {
                        int plazaSalida = parking.salida(matriculaSalida);
                        System.out.println("Coche retirado de la plaza: " + plazaSalida);
                    } catch (ParkingException e) {
                        System.out.println("Error: " + e.getMessage() + " - Matrícula: " + e.getMatricula());
                    }
                    break;

                case 3:
                    System.out.println(parking);
                    break;

                case 4:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Introduzca un número entre 1 y 4.");
            }

            System.out.println("Plazas totales: " + parking.getPlazasTotales());
            System.out.println("Plazas ocupadas: " + parking.getPlazasOcupadas());
            System.out.println("Plazas libres: " + parking.getPlazasLibres());
        }
    }
}
