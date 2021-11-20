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
import ticoviaje.Objetos.Asiento;

public class EncomiendasCliente extends Observable {

    private static final String COMANDO_INSERTAR = "INSERT INTO encomiendas " + "(peso, codigo, precio, persona_entrega, persona_retira, hora_fecha, estado, idcliente) " + "VALUES(?,?,?,?,?,?,?,?);";
    private static final String COMANDO_ACTUALIZAR = "UPDATE encomiendas SET estado =? WHERE codigo=?;";
    private static final String COMANDO_ACTUALIZAR_2 = "UPDATE encomiendas SET idviaje =? WHERE codigo=?;";

    private Conexion cn;
    private static Cliente cliente;
    private ConjuntoViajes viajes;
    private int posicion;

    public EncomiendasCliente(Cliente c, int posicion) {
        this.cn = new Conexion();
        this.posicion = posicion;
        cliente = c;
        viajes = new ConjuntoViajes();
        cargarViajes();
    }

    public void generarTabla(JTable tabla) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        for (Encomienda encomienda : cliente.getEncomiendas().getEncomiendas()) {
            model.addRow(new Object[]{encomienda.getPeso(), encomienda.getCodigo(), encomienda.getPrecioPorPeso(), encomienda.getPersonaEntrega(), encomienda.getPersonaRetira(), encomienda.getHoraFecha(), encomienda.isEstadoViaje()});
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
            if (opc != null) {
                if (opc.equals("En Viaje")) {
                    if (agregar_encomienda_a_viaje(tabla, fila) == false) {
                        opc = cliente.getEncomiendas().getEncomiendas().get(fila).isEstadoViaje();
                    }
                }
                Statement st;
                st = cn.getConexion().createStatement();
                PreparedStatement stm = cn.getConexion().prepareStatement(COMANDO_ACTUALIZAR);

                stm.setString(1, opc);
                stm.setInt(2, cliente.getEncomiendas().getEncomiendas().get(fila).getCodigo());

                if (stm.executeUpdate() != 1) {
                    throw new Exception();
                }
                cliente.getEncomiendas().getEncomiendas().get(fila).setEstadoViaje(opc);
                DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                model.setValueAt(opc, fila, 6);
            }
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
                        
                        // Se verifica si se logra insertar correctamente en la base de datos y una unica vez
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

    public boolean agregar_encomienda_a_viaje(JTable tabla, int fila) throws SQLException, Exception {
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
                    Statement st;
                    st = cn.getConexion().createStatement();
                    PreparedStatement stm = cn.getConexion().prepareStatement(COMANDO_ACTUALIZAR_2);
                    stm.setInt(1, obtener_llave(viaje));
                    stm.setInt(2, viaje.getEncomiendas().getEncomiendas().get(fila).getCodigo());

                    if (stm.executeUpdate() != 1) {
                        throw new Exception();
                    }
                    setChanged();
                    notifyObservers("Se ha agregado la encomienda al viaje");
                    return true;
                }
            }
        }
        return false;
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

    public final void cargarViajes() {
        Statement st;
        ResultSet rs;

        try {
            st = cn.getConexion().createStatement();
            rs = st.executeQuery("SELECT * FROM viajes");

            while (rs.next()) {
                Viaje viaje = new Viaje();
                viaje.setRuta(rs.getString("ruta"));
                viaje.setFecha(rs.getString("fecha"));
                viaje.setHorario(rs.getString("horario"));
                viaje.setKilometros(rs.getInt("kilometros"));
                viaje.setCosto(rs.getInt("costo"));
                Bus unidad = cargarBus(rs.getInt("idbuses"));
                viaje.setUnidad(unidad);
                viajes.add(viaje);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        setChanged();
        notifyObservers();
    }

    public Bus cargarBus(int key) {
        Statement st;
        ResultSet rs;

        try {
            st = cn.getConexion().createStatement();
            rs = st.executeQuery("SELECT * FROM buses where (idbuses = " + key + ");");

            while (rs.next()) {
                Bus unidad = new Bus();
                unidad.setEstado(rs.getString("estado"));
                unidad.setPlaca(rs.getString("placa"));
                unidad.setCapacidad(rs.getInt("capacidad"));
                unidad.setChofer(cargarChofer(rs.getInt("idchofer")));
                unidad.setAsientos(cargarAsientos(rs.getInt("idbuses")));
                setChanged();
                notifyObservers();
                return unidad;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Chofer cargarChofer(int key) {

        Statement st;
        ResultSet rs;

        try {
            st = cn.getConexion().createStatement();
            rs = st.executeQuery("SELECT * FROM choferes where (idchoferes = " + key + ");");
            Chofer chofer = new Chofer();
            while (rs.next()) {
                chofer.setNombre(rs.getString("nombre"));
                chofer.setLicencia(rs.getString("licencia"));
                chofer.setEdad(rs.getInt("edad"));
                setChanged();
                notifyObservers();
                return chofer;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public ArrayList<Asiento> cargarAsientos(int key) {
        Statement st;
        ResultSet rs;

        try {
            st = cn.getConexion().createStatement();
            rs = st.executeQuery("SELECT * FROM asientos where (idbus = " + key + ");");
            ArrayList<Asiento> asientos = new ArrayList();
            while (rs.next()) {
                Asiento asiento = new Asiento();
                asiento.setDisponible(rs.getBoolean("disponible"));
                asiento.setIdAsiento(rs.getInt("numero"));
                asiento.setPropetario(rs.getString("propietario"));
                asientos.add(asiento);
                setChanged();
                notifyObservers();
            }
            return asientos;

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public int obtener_llave(Viaje viaje) {
        Statement st;
        ResultSet rs;

        try {
            st = cn.getConexion().createStatement();
            rs = st.executeQuery("SELECT * FROM viajes WHERE (ruta = \"" + viaje.getRuta() + "\") AND (fecha = \"" + viaje.getFecha() + "\") AND (horario = \"" + viaje.getHorario() + "\");");

            while (rs.next()) {
                setChanged();
                notifyObservers();
                return rs.getInt("idviajes");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
}
