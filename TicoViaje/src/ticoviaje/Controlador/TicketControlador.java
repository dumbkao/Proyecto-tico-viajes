package ticoviaje.Controlador;

import java.util.Observer;
import ticoviaje.Modelos.Ticket;
import ticoviaje.Modelos.Viaje;
import ticoviaje.Objetos.Asiento;

public class TicketControlador {

    private final Ticket datos;

    public TicketControlador() {
        this.datos = new Ticket();
    }

    public Viaje getViajeUsuario() {
        return datos.getViajeUsuario();
    }

    public void setViajeUsuario(Viaje viajeUsuario) {
        datos.setViajeUsuario(viajeUsuario);
    }

    public String getAsientoUsuario() {
        return datos.getAsientos();
    }

    public void setAsientoUsuario(String asientos) {
        datos.setAsientos(asientos);
    }

    public String getNombreCliente() {
        return datos.getNombreCliente();
    }

    public void setNombreCliente(String nombreCliente) {
        datos.setNombreCliente(nombreCliente);
    }

    public void agregarObservador(Observer observador) {
        datos.agregarObservador(observador);
    }
}
