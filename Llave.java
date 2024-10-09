package aventuradelamazmorra;

public class Llave extends Objeto {
    public Llave(boolean k) {
        super(0, 0, 0);
    }

    @Override
    public void usar(Jugador jugador) {
        // Las llaves no tienen un uso específico en este contexto
        System.out.println("Tienes una llave");
    }
}