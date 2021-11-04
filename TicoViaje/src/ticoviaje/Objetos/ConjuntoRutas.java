
package ticoviaje.Objetos;

import java.util.ArrayList;

public class ConjuntoRutas {
    private ArrayList<Ruta> rutas;
    
    public ConjuntoRutas() {
        rutas = new ArrayList();
    }

    public ArrayList<Ruta> getRutas() {
        return rutas;
    }

    public void setRutas(ArrayList<Ruta> rutas) {
        this.rutas = rutas;
    }
    
    public void add(Ruta ruta) {
        rutas.add(ruta);
    }
}
