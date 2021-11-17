
package ticoviaje.Modelos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ticoviaje.Objetos.Chofer;
import ticoviaje.Objetos.Cliente;
import ticoviaje.Objetos.Encomienda;
import ticoviaje.Vista.VistaClientes;

public class EncomiendasCliente extends Observable {
    private static Cliente cliente;
    private ConjuntoViajes viajes;
    private Flotilla flotilla;
    
    public EncomiendasCliente(Cliente c, ConjuntoViajes viajes) {
        cliente = c;
        this.viajes = viajes;
        this.flotilla = new Flotilla();
        agregarBuses();
        agregarViajes();
    }
    
    public void generarTabla(JTable tabla) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        for (Encomienda encomienda : cliente.getEncomiendas().getEncomiendas()) {
            model.addRow(new Object[]{encomienda.getPeso(), encomienda.getCodigo(), encomienda.getPrecioPorPeso(), encomienda.getPersonaEntrega(), encomienda.getPersonaRetira(), encomienda.getHoraFecha(), encomienda.isEstadoViaje()});
        }
    }
    
    public final void agregarViajes() {
        agregarViaje("Alajuela - San Jose", "Domingo", "12:00md - 02:00pm", 5, 1000, 0);
        agregarViaje("Alajuela - San Jose", "Lunes", "02:30pm - 3:30pm", 5, 1000, 1);
        agregarViaje("San Jose - Alajuela", "Domingo", "06:00pm - 07:00pm", 5, 1000, 2);
        agregarViaje("San Jose - Alajuela", "Domingo", "10:00am - 11:00am", 5, 1000, 3);
    }

    public void agregarViaje(String ruta, String fecha, String horario, int kilometros, int costo, int bus) {
        Viaje viaje = new Viaje();
        viaje.setRuta(ruta);
        viaje.setFecha(fecha);
        viaje.setHorario(horario);
        viaje.setKilometros(kilometros);
        viaje.setCosto(costo);
        viaje.setUnidad(flotilla.getEspecifico(bus));
        viajes.add(viaje);
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
    
    public void regresar() {
        VistaClientes vista = new VistaClientes();
        vista.iniciar();
    }
    
    public void cambiar_estado(JTable tabla) {
        ArrayList<String> opciones = new ArrayList();
        opciones.add("En Espera de Salida");
        opciones.add("En Viaje");
        opciones.add("Pendiente de Retiro");
        opciones.add("Retirado");
        int fila = tabla.getSelectedRow();
        if (fila != -1) {
            for (int i = 0; i < 4; i++) {
                if (opciones.get(i).equals(cliente.getEncomiendas().getEncomiendas().get(fila).isEstadoViaje())) {//es un get
                    opciones.remove(i);
                    break;
                }
            }
            String opc = (String) JOptionPane.showInputDialog(null, "Eliga el nuevo estado de la encomienda", "ESTADOS", JOptionPane.QUESTION_MESSAGE, null, opciones.toArray(), opciones.get(0));
            cliente.getEncomiendas().getEncomiendas().get(fila).setEstadoViaje(opc);
            if (opc.equals("En Viaje")) {
                agregar_encomienda_a_viaje(tabla, fila);
            }
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            model.setValueAt(opc, fila, 6);
        }
    }
    
    public void agregar_encomienda(JTable tabla) {
        Encomienda encomienda = new Encomienda();
        String peso = JOptionPane.showInputDialog(null, "Digite el peso de la encomienda");
        if (peso != null && !peso.equals("")) {
            double aux = Math.floor(Math.random() * (1000 - 0 + 1) + 0);
            String personaEntrega = cliente.getNombre();
            if (personaEntrega != null && !personaEntrega.equals("")) {
                String personaRetira = JOptionPane.showInputDialog(null, "Digite la persona que va a retirar");
                if (personaRetira != null && !personaRetira.equals("")) {
                    String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
                    String estadoViaje = "En Espera de Salida";
                    encomienda.setCodigo((int) aux);
                    encomienda.setEstadoViaje(estadoViaje);
                    encomienda.setPeso(Integer.parseInt(peso));
                    encomienda.setPrecioPorPeso(1000 * Integer.parseInt(peso));
                    encomienda.setPersonaEntrega(personaEntrega);
                    encomienda.setPersonaRetira(personaRetira);
                    encomienda.setHoraFecha(timeStamp);
                    cliente.getEncomiendas().add(encomienda);
                    DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                    model.addRow(new Object[]{peso, (int) aux, 1000 * Integer.parseInt(peso), personaEntrega, personaRetira, timeStamp, estadoViaje});
                }
            }
        }
    }
    
    public void agregar_encomienda_a_viaje(JTable tabla, int fila) {
        ArrayList<String> listaRuta = viajes.getRutas();
            String ruta = (String) JOptionPane.showInputDialog(null, "Elija la ruta del viaje al que desea agregar la encomienda: ", "RUTAS", JOptionPane.QUESTION_MESSAGE, null, listaRuta.toArray(), listaRuta.get(0));
            if (ruta != null) {
                ArrayList<String> listaFecha = viajes.getDiasRuta(ruta);
                String dia = (String) JOptionPane.showInputDialog(null, "Elija el dia del viaje al que desea agregar la encomienda: ", "DIAS", JOptionPane.QUESTION_MESSAGE, null, listaFecha.toArray(), listaFecha.get(0));
                if (dia != null) {
                    ArrayList<String> listaHorarios = viajes.getHorarioDiaRuta(ruta, dia);
                    String horario = (String) JOptionPane.showInputDialog(null, "Elija el horario del viaje al que desea agregar la encomienda: ", "HORARIOS", JOptionPane.QUESTION_MESSAGE, null, listaHorarios.toArray(), listaHorarios.get(0));
                    if (horario != null) {
                        Viaje viaje = viajes.obtenerViaje(ruta, dia, horario);
                        viaje.agregarEncomienda(cliente.getEncomiendas().getEncomiendas().get(fila));
                        setChanged();
                        notifyObservers("Se ha agregado la encomienda al viaje");
                    }
                }
            }
    }
    
    public void agregarObservador(Observer observer) {
        addObserver(observer);
        setChanged();
        notifyObservers();
    }
}
