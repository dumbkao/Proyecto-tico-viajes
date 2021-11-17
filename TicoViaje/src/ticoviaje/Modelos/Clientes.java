
package ticoviaje.Modelos;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ticoviaje.Objetos.Cliente;
import ticoviaje.Vista.VistaEncomiendas;
import ticoviaje.Vista.VistaEncomiendasCliente;

public class Clientes extends Observable {
    
    private ArrayList<Cliente> clientes;
    
    public Clientes() {
        clientes = new ArrayList();
    }
    
    public void agregarClientes(JTable tabla) {
        String nombre = JOptionPane.showInputDialog(null, "Digite su nombre");
        if (nombre != null && !nombre.equals("")) {
            Cliente nuevo = new Cliente();
            nuevo.setNombre(nombre);
            clientes.add(nuevo);
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            model.addRow(new Object[]{nuevo.getNombre()});
        }
    }
    
    public boolean verClientes(JTable tabla) {
        int fila = tabla.getSelectedRow();
        if (fila != -1) {
            VistaEncomiendasCliente vista = new VistaEncomiendasCliente(clientes.get(fila), new ConjuntoViajes());
            vista.iniciar();
            return true;
        }
        return false;
    }
    
    public void regresar() {
        VistaEncomiendas vista = new VistaEncomiendas();
        vista.iniciar();
    }
    
    public void agregarObservador(Observer observer) {        
        addObserver(observer);
        setChanged();
        notifyObservers();
    }
}
