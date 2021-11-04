
package ticoviaje.Objetos;

import java.util.ArrayList;

public class ConjuntoDias {
    private ArrayList<Dia> dias;
    
    public ConjuntoDias() {
        dias = new ArrayList();
    }

    public ArrayList<Dia> getDias() {
        return dias;
    }

    public void setDias(ArrayList<Dia> dias) {
        this.dias = dias;
    }
    
    public void add(Dia dia) {
        dias.add(dia);
    }
}
