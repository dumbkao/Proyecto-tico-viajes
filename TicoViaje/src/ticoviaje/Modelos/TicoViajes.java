/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticoviaje.Modelos;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import ticoviaje.Vista.BusVista;
import ticoviaje.Vista.VistaEncomiendas;
import ticoviaje.Objetos.Chofer;

/**
 *
 * @author hilla
 */
public class TicoViajes extends Observable {

    private ConjuntoViajes conjuntoViaje;
    private Flotilla flotilla;

    public TicoViajes() {
        this.conjuntoViaje = new ConjuntoViajes();
        this.flotilla = new Flotilla();
        agregarBuses();
        agregarViajes();
    }

    public final void agregarViajes() {
        agregarViaje("Alajuela-San Jose", "Domingo", "12md - 2pm", 5, 1000, 0);
        agregarViaje("Alajuela-San Jose", "Lunes", "2:30pm - 3:30pm", 5, 1000, 0);
        agregarViaje("San Jose-Alajuela", "Domingo", "6pm - 7pm", 5, 1000, 0);
        agregarViaje("San Jose-Alajuela", "Domingo", "10am - 11am", 5, 1000, 0);
    }

    public void agregarViaje(String ruta, String fecha, String horario, int kilometros, int costo, int bus) {
        Viaje viaje = new Viaje();
        viaje.setRuta(ruta);
        viaje.setFecha(fecha);
        viaje.setHorario(horario);
        viaje.setKilometros(kilometros);
        viaje.setCosto(costo);
        viaje.setUnidad(flotilla.getEspecifico(bus));
        conjuntoViaje.add(viaje);
    }

    public final void agregarBuses() {
        String nombres[] = {"Juanito", "Andres", "Ramses", "Hillary", "Rosa", "Pedrito", "Sofia", "Eduardo", "Jaime", "Jose", "Maria", "Marco", "Lucia", "Jair", "Noel", "Rachel", "Emanuel", "Abigail", "Gerardo", "Wilson"};
        for (int i = 0; i < 20; i++) {
            Chofer chofer = new Chofer();
            chofer.setNombre(nombres[i]);
            Bus bus = new Bus();
            bus.setChofer(chofer);
            flotilla.add(bus);
        }
    }

    public void agregarObservador(Observer o) {
        addObserver(o);
        setChanged();
        notifyObservers();
    }

    public void abrirEncomiendas() {
        setChanged();
        notifyObservers();
        VistaEncomiendas vista = new VistaEncomiendas();
        vista.iniciar();
    }

    public boolean abrirTiquetes() {
        setChanged();
        notifyObservers();
        String nombre = JOptionPane.showInputDialog(null, "Digite su nombre:", "Nombre", JOptionPane.QUESTION_MESSAGE);
        if (nombre != null && !nombre.equals("")) {
            ArrayList<String> listaRuta = conjuntoViaje.getRutas();
            String ruta = (String) JOptionPane.showInputDialog(null, "Elija la ruta que desea", "RUTAS", JOptionPane.QUESTION_MESSAGE, null, listaRuta.toArray(), listaRuta.get(0));

            if (ruta != null) {
                ArrayList<String> listaFecha = conjuntoViaje.getDiasRuta(ruta);
                String fecha = (String) JOptionPane.showInputDialog(null, "Elija la fecha que desea", "FECHAS", JOptionPane.QUESTION_MESSAGE, null, listaFecha.toArray(), listaFecha.get(0));

                if (fecha != null) {
                    ArrayList<String> listaHorarios = conjuntoViaje.getHorarioDiaRuta(ruta, fecha);
                    String horario = (String) JOptionPane.showInputDialog(null, "Elija el Horario que desea", "HORARIOS", JOptionPane.QUESTION_MESSAGE, null, listaHorarios.toArray(), listaHorarios.get(0));

                    if (horario != null) {
                        BusVista vista = new BusVista(nombre);

                        vista.getControlador().setDatos(flotilla.getEspecifico(0));
                         vista.iniciar(ruta, fecha, horario);
                        return true;          
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe digitar un nombre valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

}
