package ticoviaje.Controlador;

import java.util.Observer;
import javax.swing.JTable;
import ticoviaje.Modelos.ConjuntoViajes;
import ticoviaje.Modelos.EncomiendasCliente;
import ticoviaje.Objetos.Cliente;

public class EncomiendasClienteControlador {

    private EncomiendasCliente modelo;

    public EncomiendasClienteControlador(Cliente cliente, ConjuntoViajes viajes, int posicion) {
        modelo = new EncomiendasCliente(cliente, viajes, posicion);
    }

    public void generarTabla(JTable tabla) {
        modelo.generarTabla(tabla);
    }

    public void regresar() {
        modelo.regresar();
    }

    public void cambiar_estado(JTable tabla) {
        modelo.cambiar_estado(tabla);
    }

    public void agregar_encomienda(JTable tabla) {
        modelo.agregar_encomienda(tabla);
    }

    public void agregarObservador(Observer observer) {
        modelo.agregarObservador(observer);
    }

    public void cargarBD(JTable tabla) {
        modelo.cargarBD(tabla);
    }
}
