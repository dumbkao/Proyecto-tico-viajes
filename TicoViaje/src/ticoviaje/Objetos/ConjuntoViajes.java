
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
}
