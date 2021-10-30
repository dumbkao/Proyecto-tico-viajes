package ticoviaje.Objetos;

import java.util.ArrayList;

public class ConjuntoEncomienda {

    ArrayList<Encomienda> encomiendas;

    public ConjuntoEncomienda() {
        encomiendas = new ArrayList();
    }

    public void add(Encomienda encomienda) {
        encomiendas.add(encomienda);
    }
    
    public int size(){
        return encomiendas.size();
    }

    public Encomienda getEspecifica(int index) {
        return encomiendas.get(index);
    }

    public ArrayList<Encomienda> getEncomiendas() {
        return encomiendas;
    }

    public Encomienda getPorCodigo(int codigo) {
        for (Encomienda encomienda : encomiendas) {
            if (encomienda.getCodigo() == codigo) {
                return encomienda;
            }
        }
        return null;
    }
}
