package ticoviaje.Controlador;

import java.util.ArrayList;
import java.util.Observer;
import ticoviaje.Modelos.ConjuntoViajes;
import ticoviaje.Modelos.Viaje;

public class ConjuntoViajesControlador {

    private ConjuntoViajes datos;

    public ConjuntoViajesControlador() {
        datos = new ConjuntoViajes();
    }

    public ArrayList<Viaje> getViajes() {
        return datos.getViajes();
    }

    public void setViajes(ArrayList<Viaje> viajes) {
        datos.setViajes(viajes);
    }

    public void add(Viaje viaje) {
        datos.add(viaje);
    }

    public Viaje obtenerEspecifico(int index) {
        return datos.obtenerEspecifico(index);
    }

    public ArrayList<String> getRutas() {
        return datos.getRutas();
    }

    public ArrayList<String> getDiasRuta(String ruta) {
        return datos.getDiasRuta(ruta);
    }

    public ArrayList<String> getHorarioDiaRuta(String ruta, String dia) {
        return datos.getHorarioDiaRuta(ruta, dia);
    }

    public void agregarObservador(Observer observador) {
        datos.agregarObservador(observador);
    }
}
