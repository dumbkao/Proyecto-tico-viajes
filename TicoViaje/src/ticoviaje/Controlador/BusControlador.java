package ticoviaje.Controlador;

import java.util.ArrayList;
import java.util.Observer;
import javax.swing.JOptionPane;
import ticoviaje.Modelos.Bus;
import ticoviaje.Modelos.Viaje;
import ticoviaje.Objetos.Asiento;
import ticoviaje.Objetos.Chofer;
import ticoviaje.Vista.TicketVista;
import ticoviaje.Vista.TicoViajesVista;

public class BusControlador {

    private Bus datos;

    public BusControlador() {
        datos = new Bus();
    }

    public void setDatos(Bus datos) {
        this.datos = datos;
    }

    public void agregarObservador(Observer observador) {
        datos.agregarObservador(observador);
    }

    public String getEstado() {
        return datos.getEstado();
    }

    public void setEstado(String estado) {
        datos.setEstado(estado);
    }

    public String getPlaca() {
        return datos.getPlaca();
    }

    public void setPlaca(String placa) {
        datos.setPlaca(placa);
    }

    public int getNumeroUnico() {
        return datos.getNumeroUnico();
    }

    public void setNumeroUnico(int numeroUnico) {
        datos.setNumeroUnico(numeroUnico);
    }

    public int getCapacidad() {
        return datos.getCapacidad();
    }

    public void setCapacidad(int capacidad) {
        datos.setCapacidad(capacidad);
    }

    public Chofer getChofer() {
        return datos.getChofer();
    }

    public void setChofer(Chofer chofer) {
        datos.setChofer(chofer);
    }

    public ArrayList<Asiento> getAsientos() {
        return datos.getAsientos();
    }

    public void setAsientos(ArrayList<Asiento> asientos) {
        datos.setAsientos(asientos);
    }

    public void aceptarAsientos() {
        datos.aceptarAsientos();
    }

    public void regresar() {
        datos.regresar();
    }

    public Viaje getViaje() {
        return datos.getViaje();
    }

    public void setViaje(Viaje viaje) {
        datos.setViaje(viaje);
    }
}
