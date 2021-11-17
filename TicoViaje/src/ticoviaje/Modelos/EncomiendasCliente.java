package ticoviaje.Modelos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import ticoviaje.Objetos.Chofer;
import ticoviaje.Objetos.Cliente;
import ticoviaje.Objetos.Encomienda;
import ticoviaje.Vista.VistaClientes;

import ticoviaje.Bases_Datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EncomiendasCliente extends Observable {

    private static final String COMANDO_INSERTAR = "INSERT INTO encomiendas " + "(peso, codigo, precio, persona_entrega, persona_retira, hora_fecha, estado, idcliente) " + "VALUES(?,?,?,?,?,?,?,?);";
    private static final String COMANDO_ACTUALIZAR = "UPDATE encomiendas SET estado =? WHERE codigo=?;";

    private Conexion cn;
    private static Cliente cliente;
    private ConjuntoViajes viajes;
    private Flotilla flotilla;
    private int posicion;

    public EncomiendasCliente(Cliente c, ConjuntoViajes viajes, int posicion) {
        this.cn = new Conexion();
        this.posicion = posicion;
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
        cn.cerrar();
    }

    public void cambiar_estado(JTable tabla) throws SQLException, Exception {
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
            String opc = (String) JOptionPane.showInputDialog(null, "Elija el nuevo estado de la encomienda", "ESTADOS", JOptionPane.QUESTION_MESSAGE, null, opciones.toArray(), opciones.get(0));
            cliente.getEncomiendas().getEncomiendas().get(fila).setEstadoViaje(opc);

            Statement st;
            st = cn.getConexion().createStatement();
            PreparedStatement stm = cn.getConexion().prepareStatement(COMANDO_ACTUALIZAR);

            stm.setString(1, opc);
            stm.setInt(2, cliente.getEncomiendas().getEncomiendas().get(fila).getCodigo());

            if (stm.executeUpdate() != 1) {
                throw new Exception();
            }

            if (opc.equals("En Viaje")) {
                agregar_encomienda_a_viaje(tabla, fila);
            }

            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            model.setValueAt(opc, fila, 6);
        }
    }

    public void agregar_encomienda(JTable tabla) {
        Statement st;

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
                    try {
                        st = cn.getConexion().createStatement();
                        PreparedStatement stm = cn.getConexion().prepareStatement(COMANDO_INSERTAR);

                        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                        model.addRow(new Object[]{peso, (int) aux, 1000 * Integer.parseInt(peso), personaEntrega, personaRetira, timeStamp, estadoViaje});

                        stm.setInt(1, Integer.parseInt(peso));
                        stm.setInt(2, (int) aux);
                        stm.setInt(3, 1000 * Integer.parseInt(peso));
                        stm.setString(4, personaEntrega);
                        stm.setString(5, personaRetira);
                        stm.setString(6, timeStamp);
                        stm.setString(7, estadoViaje);
                        stm.setInt(8, posicion);

                        if (stm.executeUpdate() != 1) {
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
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

    public void cargarBD(JTable tabla) {
        Statement st;
        ResultSet rs;

        try {
            st = cn.getConexion().createStatement();
            rs = st.executeQuery("SELECT * FROM encomiendas where (idcliente = " + posicion + ");");

            while (rs.next()) {
                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                modelo.addRow(new Object[]{rs.getInt("peso"), rs.getInt("codigo"), rs.getInt("precio"), rs.getString("persona_entrega"), rs.getString("persona_retira"), rs.getString("hora_fecha"), rs.getString("estado")});
                Encomienda nuevaE = new Encomienda();
                nuevaE.setPeso(rs.getInt("peso"));
                nuevaE.setCodigo(rs.getInt("codigo"));
                nuevaE.setPrecioPorPeso(rs.getInt("precio"));
                nuevaE.setPersonaEntrega(rs.getString("persona_entrega"));
                nuevaE.setPersonaRetira(rs.getString("persona_retira"));
                nuevaE.setHoraFecha(rs.getString("hora_fecha"));
                nuevaE.setEstadoViaje(rs.getString("estado"));
                cliente.getEncomiendas().add(nuevaE);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        setChanged();
        notifyObservers();
    }
}
