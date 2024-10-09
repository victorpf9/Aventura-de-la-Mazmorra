package aventuradelamazmorra;

import java.util.Scanner;


public class Game0wo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // funcion para entrada de datos
	int menu = 0;	
	Mazmorra mazmora = new Mazmorra();
    Jugador jugador = new Jugador(8,1,100,20,10);
    
//======================================MENU [RINCIPAL===============
do {
	System.out.println("\n==================================\n	ENTER THE SOULGEON\n==================================\n   <Menu principal>");
	System.out.println("1- Nuevo juego\n"+"2- Instrucciones\n"+"3- Salir del juego\n"+"(Introduce un numero)");
	
	 menu = scanner.nextInt();

	
//=====================================Seleccion de pciones==========
switch (menu) {
case 1:
	
	iniciarJuego(scanner, mazmora, jugador);
	break;
	
case 2:
	System.out.println("\n\n= = = = = = = = = = = = = = = = = = = =INSTRUCCIONES= = = = = = = = = = = = = = = = = = =\n"
			+ 			"Bienvenido a la aventura. Tu objetivo es derrotar a cada enemmigo (E) que encuentres\n"
			+ 			"y hacerte mas fuerte que todos. En tu camino encontraras objetos como Posion (P),\n"
			+ 			"Espadas (L) o armaduras (A) que te ayudaran en tu viaje.\nPara desplazarte inserta las\n"
			+ 			"siguientes letras:\nArriba (w)\tAbajo(s)\tizqierda(a)\tDerecha(d)\n\n\tInserta cualquirt numero para regrezar");
	
	int exit = scanner.nextInt();
	System.out.println("\n\n\n");
	break;
	
	
case 3:
	System.out.println("Gracias por jugar :D");
	break;
default:
    System.out.println("Opción no válida. Elige una opción del menú  >:(");
    break;
	
}
	
} while (menu != 3);
	scanner.close();
	}  
//===============================INICIALIZACION DEL JUEGO=========================
	private static void iniciarJuego(Scanner scanner, Mazmorra mazmora, Jugador jugador) {
        char movimiento;
       
        while (true) {
            mazmora.mostrarMapa(jugador);
            System.out.println("Introduce 'q' para salir):\n\n\n");
            movimiento = scanner.next().charAt(0);
            if (movimiento == 'q') {
                break; // Salir del juego
            }
            mazmora.moverJugador(jugador, movimiento);
        }

    }
}
