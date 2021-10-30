package ticoviaje.Modelos;

import java.util.Observable;
import java.util.Observer;
import ticoviaje.Objetos.Asiento;

public class Ticket extends Observable {

    private Viaje viajeUsuario;
    private Asiento asientoUsuario;
    private String nombreCliente;

    public Ticket() {
        this.viajeUsuario = new Viaje();
        this.asientoUsuario = new Asiento();
        this.nombreCliente = "";
    }

    public Viaje getViajeUsuario() {
        return viajeUsuario;
    }

    public void setViajeUsuario(Viaje viajeUsuario) {
        this.viajeUsuario = viajeUsuario;
        setChanged();
        notifyObservers("Actualizando Ticket");
    }

    public Asiento getAsientoUsuario() {
        return asientoUsuario;
    }

    public void setAsientoUsuario(Asiento asientoUsuario) {
        this.asientoUsuario = asientoUsuario;
        setChanged();
        notifyObservers("Actualizando Ticket");
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        setChanged();
        notifyObservers("Actualizando Ticket");
    }

    public void agregarObservador(Observer observador) {
        addObserver(observador);
        setChanged();
        notifyObservers("Actualizando Ticket");
    }
}
