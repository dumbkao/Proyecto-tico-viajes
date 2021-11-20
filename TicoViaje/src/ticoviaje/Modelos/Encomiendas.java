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
import ticoviaje.Objetos.Chofer;
import ticoviaje.Objetos.Cliente;
import ticoviaje.Objetos.Encomienda;
import ticoviaje.Vista.EncomiendasViajeVista;
import ticoviaje.Vista.TicoViajesVista;
import ticoviaje.Vista.VistaClientes;

public class Encomiendas extends Observable {

    private Conexion cn;
    private ConjuntoViajes conjuntoViaje;
    private Flotilla flotilla;
    private ArrayList<Cliente> clientes;

    public Encomiendas() {
        this.cn = new Conexion();
        conjuntoViaje = new ConjuntoViajes();
        flotilla = new Flotilla();
        clientes = new ArrayList();
        agregarViajes();
    }

    public void ver_clientes() {
        VistaClientes vista = new VistaClientes();
        vista.iniciar();
    }

    public boolean encomienda_viaje() {
        ArrayList<String> listaRuta = conjuntoViaje.getRutas();
        String ruta = (String) JOptionPane.showInputDialog(null, "Elija la ruta que desea", "RUTAS", JOptionPane.QUESTION_MESSAGE, null, listaRuta.toArray(), listaRuta.get(0));
        if (ruta != null) {
            ArrayList<String> listaFecha = conjuntoViaje.getDiasRuta(ruta);
            String fecha = (String) JOptionPane.showInputDialog(null, "Elija la fecha que desea", "FECHAS", JOptionPane.QUESTION_MESSAGE, null, listaFecha.toArray(), listaFecha.get(0));
            if (fecha != null) {
                ArrayList<String> listaHorarios = conjuntoViaje.getHorarioDiaRuta(ruta, fecha);
                String horario = (String) JOptionPane.showInputDialog(null, "Elija el Horario que desea", "HORARIOS", JOptionPane.QUESTION_MESSAGE, null, listaHorarios.toArray(), listaHorarios.get(0));
                if (horario != null) {
                    EncomiendasViajeVista vista = new EncomiendasViajeVista(conjuntoViaje.obtenerViaje(ruta, fecha, horario));
                    vista.iniciar();
                    return true;
                }
            }
        }
        return false;
    }

    public void regresar() {
        TicoViajesVista vista = new TicoViajesVista();
        vista.iniciar();
        cn.cerrar();
    }

    public void encomienda_codigo() {
        String codigo = JOptionPane.showInputDialog(null, "Digite el codigo:");
        if (codigo != null && !codigo.equals("") && codigo.matches("[-+]?\\d*\\.?\\d+") == true) {
            String informacion = imprimirEncomienda(Integer.parseInt(codigo));
            if (informacion != null) {
                setChanged();
                notifyObservers(informacion);
            } else {
                setChanged();
                notifyObservers("No se encontro la encomienda");
            }
        } else {
            setChanged();
            notifyObservers("Debe digitar un codigo valido");
        }
    }

    public String imprimirEncomienda(int codigo) {
        Statement st;
        ResultSet rs;

        try {
            st = cn.getConexion().createStatement();
            rs = st.executeQuery("SELECT * FROM encomiendas WHERE (codigo = " + codigo + ")");

            while (rs.next()) {
                Encomienda nuevaE = new Encomienda();
                nuevaE.setPeso(rs.getInt("peso"));
                nuevaE.setCodigo(rs.getInt("codigo"));
                nuevaE.setPrecioPorPeso(rs.getInt("precio"));
                nuevaE.setPersonaEntrega(rs.getString("persona_entrega"));
                nuevaE.setPersonaRetira(rs.getString("persona_retira"));
                nuevaE.setHoraFecha(rs.getString("hora_fecha"));
                nuevaE.setEstadoViaje(rs.getString("estado"));
                return toStringEncomienda(nuevaE);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        setChanged();
        notifyObservers();
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
        cargarBD();
    }


    public void agregarObservador(Observer observer) {
        addObserver(observer);
        setChanged();
        notifyObservers();
    }

    public void cargarBD() {
        Statement st;
        ResultSet rs; // Es que poseera el resultado de la consulta de la base de datos

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

        } catch (SQLException e) {
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

        } catch (SQLException e) {
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
}
