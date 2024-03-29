package ticoviaje.Modelos;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ConjuntoViajes extends Observable {

    private ArrayList<Viaje> viajes;

    public ConjuntoViajes() {
        viajes = new ArrayList();
    }

    public ArrayList<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(ArrayList<Viaje> viajes) {
        this.viajes = viajes;
        setChanged();
        notifyObservers("Actualizando Bus");
    }

    public void add(Viaje viaje) {
        viajes.add(viaje);
        setChanged();
        notifyObservers("Actualizando Bus");
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
    
    public Viaje obtenerViaje(String ruta, String fecha, String horario) {
        for (Viaje viaje : viajes) {
            if (viaje.getRuta().equals(ruta)) {
                if (viaje.getFecha().equals(fecha)) {
                    if (viaje.getHorario().equals(horario)) {
                        return viaje;
                    }
                }
            }
        }
        return null;
    }
    
    public boolean remover(String ruta, String dia, String horario) {
        for (int i = 0; i < viajes.size(); i++) {
            if (viajes.get(i).getRuta().equals(ruta)) {
                if (viajes.get(i).getFecha().equals(dia)) {
                    if (viajes.get(i).getHorario().equals(horario)) {
                        viajes.remove(i);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void agregarObservador(Observer observador) {
        addObserver(observador);
        setChanged();
        notifyObservers("Actualizando Bus");
    }
}
