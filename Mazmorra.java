package aventuradelamazmorra;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Mazmorra {
//================CARACTERISTICA============
    int ancho = 29;
     int alto = 18;
     public int act;
    char[][] mapa = new char[alto][ancho];
    Enemigo enemigo;
    ArrayList<Objeto> objetos;
//================CONSTRUCTOR==============
    public Mazmorra() {
    	objetos = new ArrayList<>();
        crearMapa();
        colocarEnemigos();
        colocarObjetos();
    }
//============================FUNCION DE MAPA==============
    void crearMapa() {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                mapa[i][j] = ' '; 	//Matriz de mapa
            }
        }
        // AGREGAR PAREDES
        for (int j = 1; j < ancho; j++) {
            mapa[0][j] = '#';
            mapa[alto - 1][j] = '#'; 
        }for (int i = 1; i < alto; i++) {
            mapa[i][0] = '#'; 
            mapa[i][ancho - 1] = '#'; 
        }
        
        for(int i = 0; i <= 2; i++) {
        	for(int j = 0; j <= 6; j++) {//1
        		mapa[i][j]='#';
        	}
        }for(int i = 0; i <= 2; i++) {
        	for(int j = 10; j <= 28; j++) {//2
        		mapa[i][j]='#';
        	}
        }for(int i = 2; i <= 6; i++) {
        	for(int j = 24; j <= 28; j++) {//3
        		mapa[i][j]='#';
        	}
        }for(int i = 4; i <= 6; i++) {
        	for(int j = 4; j <= 20; j++) {//4
        		mapa[i][j]='#';
        	}
        }for(int i = 6; i <= 7; i++) {
        	for(int j = 4; j <= 8; j++) {//5
        		mapa[i][j]='#';
        	}
        }for(int i = 6; i <= 7; i++) {
        	for(int j = 12; j <= 16; j++) {//6
        		mapa[i][j]='#';
        	}
        }for(int i = 9; i <= 10; i++) {
        	for(int j = 0; j <= 24; j++) {//7
        		mapa[i][j]='#';
        	}
        }for(int i = 10; i <= 13; i++) {
        	for(int j = 20; j <= 24; j++) {//8
        		mapa[i][j]='#';
        	}
        }for(int i = 12; i <= 16; i++) {
        	for(int j = 4; j <= 8; j++) {//9
        		mapa[i][j]='#';
        	}
        }for(int i = 12; i <= 16; i++) {
        	for(int j = 12; j <= 16; j++) {//10
        		mapa[i][j]='#';
        	}
        }for(int i = 15; i <= 16; i++) {
        	for(int j = 20; j <= 24; j++) {//11
        		mapa[i][j]='#';
        	}
        }
    }
//===============MOSTRAR OBJETOS==============
    void colocarObjetos() {
        mapa[7][18] = 'P';
        mapa[16][18] = 'A'; 
        mapa[16][10] = 'L';
        mapa[8][2] = 'k';
        mapa[17][26]= 's';
    }
//================MOSTRAR ENEMIGOS=============
    void colocarEnemigos() {
        Random rand = new Random();
        int numEnemigos = 3; //---------------- Número de enemigos a colocar

        for (int i = 0; i < numEnemigos; i++) {
            int x, y;
            do {
                x = 2*(rand.nextInt( 14)) ; 
                y = rand.nextInt(alto - 2) + 1; 
            } while (mapa[y][x] != ' '); 

            mapa[y][x] = 'E'; 
        }
    }
    
    
    
//========================MOSTRAR AL JUGADOR==================
    public void mostrarMapa(Jugador jugador) {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (i == jugador.getY() && j == jugador.getX()) {
                    System.out.print('O'); 
                } else {
                    System.out.print(mapa[i][j]);
                }
            }
            System.out.println();
        }
        jugador.mostrarInventario();
    }
   
//===========================DESPLAZAMIENTOS DEL JUGADOR====================
    public boolean moverJugador(Jugador jugador, char movimiento) {
        int moverX = jugador.getX();
        int moverY = jugador.getY();

        switch (movimiento) {
            case 'w': 	
                moverY--;
                break;
            case 's': 	
                moverY++;
                break;
            case 'a': 	
                moverX = moverX-2;
                break;
            case 'd': 	
                moverX = moverX+2;
                break;
            case 'f':
            	jugador.aumentarSalud(10);
            default:
                System.out.println("Movimiento no válido.");
                return false;
        }
        // ==============DETECTAR LIMITES, OBJETOS Y ENEMIGOS
        if (moverX >= 0 && moverX < ancho && moverY >= 0 && moverY < alto) {
            // Comprobar si hay un enemigo en la nueva posición
            if (mapa[moverY][moverX] == 'E') {
                Enemigo enemigo = new Enemigo("Alma maldita", 20, 20, 2, moverX, moverY); // Crear un enemigo (puedes hacerlo dinámico)
                iniciarCombate(jugador, enemigo);
                return true; 
            } else if (mapa[moverY][moverX] == 'P') {
                Objeto pocion = new Pocion(20);
                jugador.agregarObjeto(pocion);
                mapa[moverY][moverX] = ' '; 
            }else if (mapa[moverY][moverX] == 'L') {
                Objeto Espada = new Espada(30);
                jugador.agregarObjeto(Espada);
                mapa[moverY][moverX] = ' '; 
                jugador.aumentarAtaque(30);
            }else if (mapa[moverY][moverX] == 'A') {
                Objeto Armadura = new Armadura(10);
                jugador.agregarObjeto(Armadura);
                mapa[moverY][moverX] = ' '; 
                jugador.aumentarDefensa(10);
            }else if (mapa[moverY][moverX] == 'k') {
                Objeto Llave = new Llave(true);
                jugador.agregarObjeto(Llave);
                mapa[moverY][moverX] = ' '; 
       
            }else if (mapa[moverY][moverX] == 's') { // Salida
                System.out.println("¡Has encontrado la salida fin del juego! ¡Gracias por jugar!");
                System.exit(0);
            
            }if (mapa[moverY][moverX] != '#') {
                jugador.setPosicion(moverX, moverY);
                return true;
            } else {
                System.out.println("Movimiento inválido. Hay una pared u obstáculo.");
                return false;
            }
        } else {
            System.out.println("Movimiento inválido. Fuera de límites.");
            return false;
        }
    }
//======================COMBATES=================================================
        public void iniciarCombate(Jugador jugador, Enemigo enemigo) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("¡Te has encontrado con un enemigo: " + enemigo.getNombre() + "!");

            while (jugador.getSalud() > 0 && enemigo.getSalud() > 0) {
                // Turno del jugador
            	System.out.println("Tu salud: " + jugador.getSalud() + " | Salud del enemigo: " + enemigo.getSalud());
            	System.out.println("¡Es tu turno! Presiona 'f' para atacar.");
            	char accion = scanner.next().charAt(0);
            	if (accion == 'f') {
            		// Calcular daño
            		int danio = jugador.ataque() - enemigo.getDefensa();
            		if (danio < 0) danio = 0; // No se puede hacer daño negativo
            		enemigo.recibirDanio(danio);
            		System.out.println("Has atacado a " + enemigo.getNombre() + " y le has hecho " + danio + " de daño.");
                }
                // Verificar si el enemigo ha sido derrotado
                if (enemigo.getSalud() <= 0) {
                    System.out.println("¡Has derrotado a " + enemigo.getNombre() + "!");
                    mapa[enemigo.getY()][enemigo.getX()] = ' ';// Limpiar la celda
                    return; // Salir del combate
                }
                // Turno del enemigo
                int danioEnemigo = enemigo.atacar() - jugador.getDef();
                if (danioEnemigo < 0) danioEnemigo = 0; // No se puede hacer daño negativo
                jugador.recibirDanio(danioEnemigo);
                System.out.println(enemigo.getNombre() + " te ha atacado y te ha hecho " + danioEnemigo + " de daño.");

                // Verificar si el jugador ha sido derrotado
                if (jugador.getSalud() <= 0) {
                    System.out.println("¡Has sido derrotado!");
                    System.out.println("GAME OVER. ¡Gracias por jugar!");
                    System.exit(0); // Termina el programa
                }
            }
    }
        
        
}





