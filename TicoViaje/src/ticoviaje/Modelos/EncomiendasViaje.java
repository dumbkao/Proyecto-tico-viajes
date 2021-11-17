
package ticoviaje.Modelos;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ticoviaje.Objetos.Encomienda;
import ticoviaje.Vista.VistaEncomiendas;

public class EncomiendasViaje extends Observable {
    
    private Viaje viaje;
    
    public EncomiendasViaje(Viaje viaje) {
        this.viaje = viaje;
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
    
    public void generar_tabla(JTable tabla) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        for (Encomienda encomienda : viaje.getEncomiendas().getEncomiendas()) {
            model.addRow(new Object[]{encomienda.getPeso(), encomienda.getCodigo(), encomienda.getPrecioPorPeso(), encomienda.getPersonaEntrega(), encomienda.getPersonaRetira(), encomienda.getHoraFecha(), encomienda.isEstadoViaje()});
        }
    }
}
