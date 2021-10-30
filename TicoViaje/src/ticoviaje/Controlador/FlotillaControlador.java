
package ticoviaje.Controlador;
import java.util.Observer;
import ticoviaje.Modelos.Bus;
import ticoviaje.Modelos.Flotilla;

public class FlotillaControlador {
    private final Flotilla modelo;
    
    public FlotillaControlador() {
        modelo = new Flotilla();
    }
    
    public void add(Bus bus) {
        modelo.add(bus);
    }
    
    public int size() {
        return modelo.size();
    }
    
    public void agregarObservador(Observer observer) {
        modelo.agregarObservador(observer);
    }
}
