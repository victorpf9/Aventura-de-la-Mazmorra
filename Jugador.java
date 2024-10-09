package aventuradelamazmorra;

import java.util.ArrayList;

public class Jugador {
//=======================ATRIBUTOS====================================

	int salud;		int ataque; int def;	//Caracteristicas
	int xE;			int yE;					// POSICION
	private ArrayList<Objeto> inventario;
	

//=======================CONSTRUCTOR ====================================
	
	public Jugador(int x, int y, int salud, int danio, int def) {
	this.salud = salud;
	this.ataque = danio;
	this.def = def;
	this.xE = x;
	this.yE = y;
	this.inventario = new ArrayList<>(); 
	}
	
//===============================GETTERS/SETTERS========================
	public int getX() {
		return xE;
	}
	
	public int getY() {
		return yE;
	}

	public int getSalud() {
		return salud;
	}
	public int getAtaque() {
		return ataque;
	}
	public int getDef() {
		return def;
	}

	public void setPosicion(int x, int y) {
		this.xE = x;
		this.yE = y;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}
	public void setAtaque(int danio) {
		this.ataque = danio;
	}
	public void setDef(int def) {
		this.def = def;
	}
//================================METODOS================
	public void recibirDanio(int danio) {
        this.salud -= danio;
        if (this.salud < 0) {
            this.salud = 0; // 
        }
    }
	public int ataque() {
        return ataque;
    }
	public void aumentarSalud(int cantidad) {
		 for (int i=0;i<inventario.size();i++) {;
			if(inventario.get(i).getClass() == Pocion.class) {
				Pocion pocion = (Pocion) inventario.get(i);
				pocion.usar(this);
				
				inventario.remove(i);
				break;
			}
		}
		 System.out.println("Salud actual: " + salud);
	}
	
    public void aumentarDefensa(int cantidad) {
        def += cantidad;
    }
    public void aumentarAtaque(int cantidad) {
        ataque += cantidad;
    }
    
    public void agregarObjeto(Objeto objeto) {
        inventario.add(objeto);
        System.out.println("Has agregado un objeto al inventario.");

        // Usar automáticamente armas y armaduras
        if (objeto instanceof Espada) {
            ((Espada) objeto).usar(this); // Pasa el jugador correspondiente
        } else if (objeto instanceof Armadura) {
            ((Armadura) objeto).usar(this); // Pasa el jugador correspondiente
        }
    }
    
    public void mostrarInventario() {
        System.out.println("Inventario:");
        for (Objeto objeto : inventario) {
            System.out.println("- " + objeto.getClass().getSimpleName());
        }
    }
}