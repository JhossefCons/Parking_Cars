import javax.swing.*;
import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking("Parking Centro", 10);

        while (true) {
            String[] options = {"Entrada de coche", "Salida de coche", "Mostrar parking", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (opcion) {
                case 0:
                    String matriculaEntrada = JOptionPane.showInputDialog("Introduzca la matrícula del coche:");
                    String plazaEntradaStr = JOptionPane.showInputDialog("Introduzca la plaza:");
                    try {
                        int plazaEntrada = Integer.parseInt(plazaEntradaStr);
                        parking.entrada(matriculaEntrada, plazaEntrada);
                        JOptionPane.showMessageDialog(null, "Coche aparcado correctamente.");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Plaza no válida.");
                    } catch (ParkingException e) {
                        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + " - Matrícula: " + e.getMatricula());
                    }
                    break;

                case 1:
                    String matriculaSalida = JOptionPane.showInputDialog("Introduzca la matrícula del coche:");
                    try {
                        int plazaSalida = parking.salida(matriculaSalida);
                        JOptionPane.showMessageDialog(null, "Coche retirado de la plaza: " + plazaSalida);
                    } catch (ParkingException e) {
                        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + " - Matrícula: " + e.getMatricula());
                    }
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, parking.toString());
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Introduzca un número entre 1 y 4.");
            }

            JOptionPane.showMessageDialog(null, "Plazas totales: " + parking.getPlazasTotales() +
                    "\nPlazas ocupadas: " + parking.getPlazasOcupadas() +
                    "\nPlazas libres: " + parking.getPlazasLibres());
        }
    }
}
