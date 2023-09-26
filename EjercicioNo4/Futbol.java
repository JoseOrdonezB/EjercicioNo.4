/**
 * @author Jose Ordoñez
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Futbol {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Jugador> jugadores = new ArrayList<>();
        Boolean correr = true;
        while (correr == true) {
            System.out.println("=== Selecciona una opción: ===");
            System.out.println("1. Ingresar un jugador.");
            System.out.println("2. Ver jugadores registrados.");
            System.out.println("3. Los 3 mejores porteros en función de su efectividad.");
            System.out.println("4. La cantidad de extremos con más de un 85% de efectividad.");
            System.out.println("5. salir.");
            int opcion = scanner.nextInt();
            String skip = scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese los datos del jugador: ");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("País: ");
                    String pais = scanner.nextLine();
                    System.out.print("Faltas: ");
                    int faltas = Integer.parseInt(scanner.nextLine());
                    System.out.print("Goles Directos: ");
                    int goles = Integer.parseInt(scanner.nextLine());
                    System.out.print("Total de Lanzamientos: ");
                    int lanzamientos = Integer.parseInt(scanner.nextLine());
                    System.out.print("Tipo de Jugador (Portero o Extremo): ");
                    String tipoJugador = scanner.nextLine();

                    if (tipoJugador.equalsIgnoreCase("Portero")) {
                        System.out.print("Paradas Efectivas: ");
                        int paradas = Integer.parseInt(scanner.nextLine());
                        System.out.print("Goles Recibidos: ");
                        int recibido = Integer.parseInt(scanner.nextLine());
                        jugadores.add(new Portero(nombre, pais, faltas, goles, lanzamientos,
                                paradas, recibido));
                    } else if (tipoJugador.equalsIgnoreCase("Extremo")) {
                        System.out.print("Pases: ");
                        int pases = Integer.parseInt(scanner.nextLine());
                        System.out.print("Asistencias Efectivas: ");
                        int asistencias = Integer.parseInt(scanner.nextLine());
                        jugadores.add(new Extremo(nombre, pais, faltas, goles, lanzamientos,
                                pases, asistencias));
                    }
                    break;

                case 2:
                    System.out.println("\nJugadores registrados:");
                    for (Jugador jugador : jugadores) {
                        System.out.println("Nombre: " + jugador.nombre + ", País: " + jugador.pais);
                    }
                    break;

                case 3:
                    List<Portero> porteros = new ArrayList<>();
                    for (Jugador jugador : jugadores) {
                        if (jugador instanceof Portero) {
                            porteros.add((Portero) jugador);
                        }
                    }

                    Collections.sort(porteros, Comparator.comparingDouble(Portero::calcularEfectividad).reversed());

                    System.out.println("\nLos 3 mejores porteros:");
                    int topPorteros = Math.min(3, porteros.size());
                    for (int i = 0; i < topPorteros; i++) {
                        Portero portero = porteros.get(i);
                        System.out.println(
                                (i + 1) + ". Nombre: " + portero.nombre + ", Efectividad: "
                                        + portero.calcularEfectividad());
                    }
                    break;

                case 4:
                    int extremosEfectivos = 0;
                    for (Jugador jugador : jugadores) {
                        if (jugador instanceof Extremo) {
                            Extremo extremo = (Extremo) jugador;
                            if (extremo.calcularEfectividad() > 85.0) {
                                extremosEfectivos++;
                            }
                        }
                    }

                    System.out.println("\nCantidad de extremos con más de un 85% de efectividad: " + extremosEfectivos);
                    break;

                case 5:
                    System.out.println("Programa finalizado.");
                    correr = false;

            }
        }

    }
}