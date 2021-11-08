package ticoviaje.Objetos;

import java.util.ArrayList;
import ticoviaje.Modelos.Viaje;

public class ConjuntoViajes {

    private ArrayList<Viaje> viajes;

    public ConjuntoViajes() {
        viajes = new ArrayList();
    }

    public ArrayList<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(ArrayList<Viaje> viajes) {
        this.viajes = viajes;
    }

    public void add(Viaje viaje) {
        viajes.add(viaje);
    }

    public Viaje obtenerEspecifico(int index) {
        return viajes.get(index);
    }

    public ArrayList<String> getRutas() {
        ArrayList<String> rutas = new ArrayList();
        for (Viaje viaje : viajes) {
            if (!rutas.contains(viaje.getRuta())) {
                rutas.add(viaje.getRuta());
            }
        }
        return rutas;
    }

    public ArrayList<String> getDiasRuta(String ruta) {
        ArrayList<String> dias = new ArrayList();
        for (Viaje viaje : viajes) {
            if (viaje.getRuta().equals(ruta)) {
                if (!dias.contains(viaje.getFecha())) {
                    dias.add(viaje.getFecha());
                }
            }
        }
        return dias;
    }

    public ArrayList<String> getHorarioDiaRuta(String ruta, String dia) {
        ArrayList<String> horarios = new ArrayList();
        for (Viaje viaje : viajes) {
            if (viaje.getRuta().equals(ruta)) {
                if (viaje.getFecha().equals(dia)) {
                    if (!horarios.contains(viaje.getHorario())) {
                        horarios.add(viaje.getHorario());
                    }
                }
            }
        }
        return horarios;
    }
}
