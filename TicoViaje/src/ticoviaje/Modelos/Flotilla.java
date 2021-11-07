
package ticoviaje.Modelos;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Flotilla extends Observable {
    private final ArrayList<Bus> flotilla;
    
    public Flotilla() {
        flotilla = new ArrayList();
    }
    
    public void add(Bus bus) {
        if (flotilla.size() < 20) {
            flotilla.add(bus);
            setChanged();
            notifyObservers("Actualizando Flotilla");
        }
    }
    
    public int size() {
        return flotilla.size();
    }
    
    public void agregarObservador(Observer observer) {
        addObserver(observer);
        setChanged();
        notifyObservers("Se Agrego un Observador en la Flotilla");
    }
    public Bus getEspecifico(int index){
        return flotilla.get(index);
    }
}
