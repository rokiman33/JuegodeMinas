package Juego;

import java.util.Scanner;
import java.util.Random;

public class JuegoDeMinas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Bienvenido al juego de minas!");
        System.out.println("Selecciona una dificultad (1: Fácil, 2: Medio, 3: Difícil):");

        int dificultad = scanner.nextInt();
        int numMinas = 10;

        switch (dificultad) {
            case 1:
                numMinas = 5;
                break;
            case 2:
                numMinas = 10;
                break;
            case 3:
                numMinas = 15;
                break;
            default:
                System.out.println("Opción inválida. Se selecciona dificultad media.");
        }

        boolean[][] tablero = new boolean[5][5];
        int minasColocadas = 0;

        while (minasColocadas < numMinas) {
            int x = rand.nextInt(5);
            int y = rand.nextInt(5);

            if (!tablero[x][y]) {
                tablero[x][y] = true;
                minasColocadas++;
            }
        }

        int intentos = 6;
        boolean ganaste = false;

        while (intentos > 0) {
            System.out.println("Ingresa las coordenadas (x, y) separadas por un espacio:");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (x >= 0 && x < 5 && y >= 0 && y < 5) {
                if (tablero[x][y]) {
                    System.out.println("¡Boom! Activaste una mina.");
                    break;
                } else {
                    intentos--;
                    System.out.println("Coordenada segura. Te quedan " + intentos + " intentos.");
                    if (intentos == 0) {
                        ganaste = true;
                    }
                }
            } else {
                System.out.println("Coordenadas inválidas. Inténtalo de nuevo.");
            }
        }

        if (ganaste) {
            System.out.println("¡Felicidades! Ganaste el juego.");
        } else {
            System.out.println("¡Lo siento! Perdiste el juego.");
        }

        System.out.println("Ubicación de las minas en el tablero:");
        mostrarTablero(tablero);
    }

    private static void mostrarTablero(boolean[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j]) {
                    System.out.print("M ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}


