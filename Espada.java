package aventuradelamazmorra;


public class Espada extends Objeto {
    public Espada(int addAtaque) {
        super(0, 0, 15);
    }

    @Override
    public void usar(Jugador jugador) {
        jugador.aumentarAtaque(addAtaque);
        System.out.println("Has equipado un arma que añade " + addAtaque + " al ataque.");
    }
}