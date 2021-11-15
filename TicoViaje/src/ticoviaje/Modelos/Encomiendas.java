package ticoviaje.Modelos;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import ticoviaje.Objetos.Chofer;
import ticoviaje.Objetos.Cliente;
import ticoviaje.Objetos.Encomienda;
import ticoviaje.Vista.TicoViajesVista;
import ticoviaje.Vista.VistaClientes;

public class Encomiendas extends Observable {
    
    private ConjuntoViajes conjuntoViaje;
    private Flotilla flotilla;
    private ArrayList<Cliente> clientes;
    
    public Encomiendas() {
        conjuntoViaje = new ConjuntoViajes();
        flotilla = new Flotilla();
        clientes = new ArrayList();
        agregarBuses();
        agregarViajes();
        cargarClientes();
    }
    
    public void ver_clientes() {
        VistaClientes vista = new VistaClientes();
        vista.iniciar();
    }
    
    public void encomienda_viaje() {
        ArrayList<String> listaRuta = conjuntoViaje.getRutas();
        String ruta = (String) JOptionPane.showInputDialog(null, "Elija la ruta que desea", "RUTAS", JOptionPane.QUESTION_MESSAGE, null, listaRuta.toArray(), listaRuta.get(0));
        if (ruta != null) {
            ArrayList<String> listaFecha = conjuntoViaje.getDiasRuta(ruta);
            String fecha = (String) JOptionPane.showInputDialog(null, "Elija la fecha que desea", "FECHAS", JOptionPane.QUESTION_MESSAGE, null, listaFecha.toArray(), listaFecha.get(0));
            if (fecha != null) {
                ArrayList<String> listaHorarios = conjuntoViaje.getHorarioDiaRuta(ruta, fecha);
                String horario = (String) JOptionPane.showInputDialog(null, "Elija el Horario que desea", "HORARIOS", JOptionPane.QUESTION_MESSAGE, null, listaHorarios.toArray(), listaHorarios.get(0));
                if (horario != null) {
                    
                }
            }
        }
    }
    
    public void regresar() {
        TicoViajesVista vista = new TicoViajesVista();
        vista.iniciar();
    }
    
    public void encomienda_codigo() {
        String codigo = JOptionPane.showInputDialog(null, "Digite el codigo:");
        if (codigo != null && !codigo.equals("") && codigo.matches("[-+]?\\d*\\.?\\d+") == true) {
            String informacion = imprimirEncomienda(codigo);
            if (informacion != null) {
                setChanged();
                notifyObservers(informacion);
            }
            else {
                setChanged();
                notifyObservers("No se encontro la encomienda");
            }
        } else {
            setChanged();
            notifyObservers("Debe digitar un codigo valido");
        }
    }
    
    public String imprimirEncomienda(String codigo) {
        int numero_codigo = Integer.parseInt(codigo);
        for (Cliente cliente : clientes) {
            for (Encomienda encomienda : cliente.getEncomiendas().getEncomiendas()) {
                if (encomienda.getCodigo() == numero_codigo) {
                    return toStringEncomienda(encomienda);
                }
            }
        }
        return null;
    }
    
    public String toStringEncomienda(Encomienda encomienda) {
        String informacion = "Cliente: " + encomienda.getPersonaEntrega() + "\n";
        informacion = informacion + "Peso: " + encomienda.getPeso() + "\n";
        informacion = informacion + "Codigo: " + encomienda.getCodigo() + "\n";
        informacion = informacion + "Precio: " + encomienda.getPrecioPorPeso() + "\n";
        informacion = informacion + "Persona que Entrega: " + encomienda.getPersonaEntrega() + "\n";
        informacion = informacion + "Persona que Retira: " + encomienda.getPersonaRetira() + "\n";
        informacion = informacion + "Hora y Fecha: " + encomienda.getHoraFecha() + "\n";
        informacion = informacion + "Estado: " + encomienda.isEstadoViaje() + "\n";
        return informacion;
    }
    
    public final void agregarViajes() {
        agregarViaje("Alajuela - San Jose", "Domingo", "12md - 2pm", 5, 1000, 0);
        agregarViaje("Alajuela - San Jose", "Lunes", "2:30pm - 3:30pm", 5, 1000, 0);
        agregarViaje("San Jose - Alajuela", "Domingo", "6pm - 7pm", 5, 1000, 0);
        agregarViaje("San Jose - Alajuela", "Domingo", "10am - 11am", 5, 1000, 0);
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
    
    public final void cargarClientes() {
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        Cliente cliente3 = new Cliente();
        Cliente cliente4 = new Cliente();
        Cliente cliente5 = new Cliente();
        cliente1.setNombre("Ramses");
        cliente2.setNombre("Hillary");
        cliente3.setNombre("Andres");
        cliente4.setNombre("Pepelefu");
        cliente5.setNombre("Jennifer");
        Encomienda encomienda = new Encomienda();
        encomienda.setCodigo(123);
        encomienda.setEstadoViaje("Omegalol");
        encomienda.setHoraFecha("14-11-2021 06:54pm");
        encomienda.setPersonaEntrega("Ramon");
        encomienda.setPersonaRetira("El Chavo");
        encomienda.setPeso(7);
        encomienda.setPrecioPorPeso(7000);
        cliente4.getEncomiendas().add(encomienda);
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        clientes.add(cliente5);
    }
    
    public ArrayList<Encomienda> obtenerEncomiendasViaje(String ruta, String fecha, String horario) {
        for (Viaje viaje : conjuntoViaje.getViajes()) {
            if (viaje.getRuta().equals(ruta)) {
                if (viaje.getFecha().equals(fecha)) {
                    if (viaje.getHorario().equals(horario)) {
                        return viaje.getEncomiendas().getEncomiendas();
                    }
                }
            }
        }
        return null;
    }
    
    public void agregarObservador(Observer observer) {
        addObserver(observer);
        setChanged();
        notifyObservers();
    }
}