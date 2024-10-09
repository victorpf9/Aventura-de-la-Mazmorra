package aventuradelamazmorra;

public class Armadura extends Objeto {
    public Armadura(int def) {
        super(0, 5, 0);
    }

    @Override
    public void usar(Jugador jugador) {
        jugador.aumentarDefensa(addDef);
        System.out.println("Has equipado una armadura que añade " + addDef + " a la defensa.");
    }
}