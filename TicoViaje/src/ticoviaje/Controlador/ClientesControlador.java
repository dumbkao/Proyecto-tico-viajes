
package ticoviaje.Controlador;

import java.util.Observer;
import javax.swing.JTable;
import ticoviaje.Modelos.Clientes;

public class ClientesControlador {
    
    private Clientes modelo;
    
    public ClientesControlador() {
        modelo = new Clientes();
    }
    
    public void agregarClientes(JTable tabla) {
        modelo.agregarClientes(tabla);
    }
    
    public boolean verClientes(JTable tabla) {
        return modelo.verClientes(tabla);
    }
    
    public void regresar() {
        modelo.regresar();
    }
    
    public void agregarObservador(Observer observer) {        
        modelo.agregarObservador(observer);
    }
}
