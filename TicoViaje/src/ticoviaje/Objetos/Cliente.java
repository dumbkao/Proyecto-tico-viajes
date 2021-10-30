package ticoviaje.Objetos;

import ticoviaje.Modelos.Ticket;

public class Cliente {

    private ConjuntoEncomienda encomiendas;
    private String nombre;
    private Ticket tiquete;

    public Cliente() {
        this.encomiendas = new ConjuntoEncomienda();
        this.tiquete = new Ticket();
        this.nombre = "";
    }

    public ConjuntoEncomienda getEncomiendas() {
        return encomiendas;
    }

    public void setEncomiendas(ConjuntoEncomienda encomiendas) {
        this.encomiendas = encomiendas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ticket getTiquete() {
        return tiquete;
    }

    public void setTiquete(Ticket tiquete) {
        this.tiquete = tiquete;
    }
}
