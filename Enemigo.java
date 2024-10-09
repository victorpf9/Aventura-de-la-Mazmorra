package aventuradelamazmorra;

public class Enemigo {
    //================ATRIBUTOS============
    private String nombre;
    private int salud;
    private int ataque;
    private int defensa;
    public int x; // Posición en el mapa
    public int y; // Posición en el mapa

    //================CONSTRUCTOR==============
    public Enemigo(String nombre, int salud, int ataque, int defensa, int x, int y) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
        this.x = x;
        this.y = y;
    }

    //================GETTERS================
    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //================MÉTODOS================
    public void recibirDanio(int danio) {
        this.salud -= danio;
        if (this.salud < 0) {
            this.salud = 0; // Asegurarse de que la salud no sea negativa
        }
    }

    public int atacar() {
        return ataque; // Devolver el valor de ataque del enemigo
    }

    public void setPosicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean estaVivo() {
        return salud > 0; // Verificar si el enemigo sigue vivo
    }
}
     


