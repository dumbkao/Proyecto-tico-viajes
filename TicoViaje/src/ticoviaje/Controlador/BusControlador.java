package ticoviaje.Controlador;

import java.util.Observer;
import ticoviaje.Modelos.Bus;
import ticoviaje.Objetos.Chofer;

public class BusControlador {

    private final Bus datos;

    public BusControlador() {
        datos = new Bus();
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
}
