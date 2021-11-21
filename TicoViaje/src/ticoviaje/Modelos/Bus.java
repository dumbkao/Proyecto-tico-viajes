package ticoviaje.Modelos;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javax.swing.JOptionPane;
import ticoviaje.Bases_Datos.Conexion;
import ticoviaje.Objetos.Asiento;
import ticoviaje.Objetos.Chofer;
import ticoviaje.Vista.TicketVista;
import ticoviaje.Vista.TicoViajesVista;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Bus extends Observable {

    private String estado, placa;
    private int capacidad;
    private ArrayList<Asiento> asientos;
    private Chofer chofer;
    private String propietario;
    private Conexion conexion;

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public Bus() {
        this.estado = "Disponible";
        this.placa = placaAleatoria();
        this.capacidad = 11;
        this.chofer = new Chofer();
        this.asientos = new ArrayList();
        this.propietario = "";
        for (int i = 0; i < 11; i++) {
            Asiento asiento = new Asiento();
            asiento.setIdAsiento(i + 1);
            asientos.add(asiento);
        }
        conexion = new Conexion();
    }

    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(ArrayList<Asiento> asientos) {
        this.asientos = asientos;
        setChanged();
        notifyObservers();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
        setChanged();
        notifyObservers();
    }

    public String getPlaca() {
        return placa;
    }

    public static String placaAleatoria() {

        char[] chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            buffer.append(chars[random.nextInt(charsLength)]);
        }

        return (buffer.toString());
    }

    public void setPlaca(String placa) {
        this.placa = placa;
        setChanged();
        notifyObservers();
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
        setChanged();
        notifyObservers();
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
        setChanged();
        notifyObservers();
    }

    public void agregarObservador(Observer observador) {
        addObserver(observador);
        setChanged();
        notifyObservers();
    }

    public void aceptarAsientos(Viaje viaje) {
        String informacion = asientos_propietario();
        if (!informacion.equals("")) {
            JOptionPane.showMessageDialog(null, "Los asientos han sido seleccionados");
            TicketVista vista = new TicketVista();
            vista.iniciar(viaje, propietario, informacion);
            guardarAsientos();
        }
        else {
            setChanged();
            notifyObservers("No se pueden aceptar asientos, no hay asientos seleccionados");
        }
    }

    public void regresar() {
        TicoViajesVista vista = new TicoViajesVista();
        vista.iniciar();
        conexion.cerrar();
    }

    public String asientos_propietario() {
        String informacion = "";
        for (Asiento asiento : asientos) {
            if (asiento.getPropetario().equals(propietario)) {
                informacion = informacion + asiento.getIdAsiento() + ", ";
            }
        }
        return informacion;
    }

    public void guardarAsientos() {
        try {
            PreparedStatement statement = conexion.getConexion().prepareStatement("UPDATE asientos SET propietario = ?, disponible = ? WHERE idBus = ? and numero = ?");
            for (Asiento asiento : asientos) {
                if (asiento.getPropetario().equals(propietario)) {
                    statement.setString(1, propietario);
                    statement.setBoolean(2, false);
                    statement.setInt(3, obtenerLlaveBus(placa));
                    statement.setInt(4, asiento.getIdAsiento());
                    if (statement.executeUpdate() != 1) {
                        throw new SQLException();
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public int obtenerLlaveBus(String placa) {
        try {
            Statement statement = conexion.getConexion().createStatement();
            ResultSet query = statement.executeQuery("SELECT * FROM buses WHERE placa = \"" + placa + "\";");
            if (query.next()) {
                return query.getInt("idbuses");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return 0;
    }
}
