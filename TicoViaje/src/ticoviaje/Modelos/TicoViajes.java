package ticoviaje.Modelos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import ticoviaje.Bases_Datos.Conexion;
import ticoviaje.Objetos.Asiento;
import ticoviaje.Vista.BusVista;
import ticoviaje.Vista.VistaEncomiendas;
import ticoviaje.Objetos.Chofer;
import ticoviaje.Vista.MantenimientoVista;

public class TicoViajes extends Observable {

    private ConjuntoViajes conjuntoViaje;
    private Flotilla flotilla;
    private ArrayList<Chofer> choferes;
    private Conexion conexion;

    public TicoViajes() {
        conexion = new Conexion();
        this.conjuntoViaje = new ConjuntoViajes();
        this.flotilla = new Flotilla();
        this.choferes = new ArrayList();
        cargarViajes();
        cargarFlotilla();
        cargarListaChoferes();
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
                        BusVista vista = new BusVista(nombre, conjuntoViaje.obtenerViaje(ruta, fecha, horario));
                        vista.getControlador().setDatos(flotilla.getEspecifico(0));
                        vista.iniciar();
                        return true;
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe digitar un nombre valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public void mantenimiento() {
        MantenimientoVista vista = new MantenimientoVista(conjuntoViaje, choferes, flotilla);
        vista.iniciar();
    }
    
    public final void cargarViajes() {
        Statement st;
        ResultSet rs;

        try {
            st = conexion.getConexion().createStatement();
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
                conjuntoViaje.add(viaje);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        setChanged();
        notifyObservers();
    }

    public Bus cargarBus(int key) {
        Statement st;
        ResultSet rs;

        try {
            st = conexion.getConexion().createStatement();
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

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Chofer cargarChofer(int key) {

        Statement st;
        ResultSet rs;

        try {
            st = conexion.getConexion().createStatement();
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

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public ArrayList<Asiento> cargarAsientos(int key) {
        Statement st;
        ResultSet rs;

        try {
            st = conexion.getConexion().createStatement();
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

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }
    
     public final void cargarFlotilla() {
        Statement st;
        ResultSet rs;

        try {
            st = conexion.getConexion().createStatement();
            rs = st.executeQuery("SELECT * FROM buses");

            while (rs.next()) {
                Bus unidad = new Bus();
                unidad.setEstado(rs.getString("estado"));
                unidad.setPlaca(rs.getString("placa"));
                unidad.setCapacidad(rs.getInt("capacidad"));
                unidad.setChofer(cargarChofer(rs.getInt("idchofer")));
                unidad.setAsientos(cargarAsientos(rs.getInt("idbuses")));
                flotilla.add(unidad);
                setChanged();
                notifyObservers();
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        setChanged();
        notifyObservers();
    }
     
     public final void cargarListaChoferes() {
        Statement st;
        ResultSet rs;

        try {
            st = conexion.getConexion().createStatement();
            rs = st.executeQuery("SELECT * FROM choferes");

            while (rs.next()) {
                Chofer chofer = new Chofer();
                chofer.setNombre(rs.getString("nombre"));
                chofer.setLicencia(rs.getString("licencia"));
                chofer.setEdad(rs.getInt("edad"));
                choferes.add(chofer);
                setChanged();
                notifyObservers();
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        setChanged();
        notifyObservers();
    }

}
