
package ticoviaje.Modelos;

import java.util.Observable;
import java.util.Observer;
import ticoviaje.Vista.VistaEncomiendas;

public class EncomiendasViaje extends Observable {
    
    public EncomiendasViaje() {
    }
    
    public void agregarObservador(Observer observer) {
        addObserver(observer);
        setChanged();
        notifyObservers();
    }
    
    public void regresar() {
        VistaEncomiendas vista = new VistaEncomiendas();
        vista.iniciar();
    }
}
