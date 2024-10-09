package aventuradelamazmorra;

public abstract class Objeto {
	int cura;
	public int addDef;
	int addAtaque;
    public Objeto(int cura, int def, int addAtaque) {
        this.cura = cura;
        this.addDef = def;
        this.addAtaque = addAtaque;
    }

    public abstract void usar(Jugador jugador);

//GETTERS Y SETTERS
    public int getCura() {
		return cura;
	}

	public int getDef() {
		return addDef;
	}

	public int getAddAtaque() {
		return addAtaque;
	}

	public void setCura(int cura) {
		this.cura = cura;
	}

	public void setDef(int def) {
		this.addDef = def;
	}

	public void setAddAtaque(int addAtaque) {
		this.addAtaque = addAtaque;
	}
}


