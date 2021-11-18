package ticoviaje.Modelos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ticoviaje.Bases_Datos.Conexion;
import ticoviaje.Objetos.Encomienda;
import ticoviaje.Vista.VistaEncomiendas;

public class EncomiendasViaje extends Observable {

    private Viaje viaje;
    private Conexion cn;

    public EncomiendasViaje(Viaje viaje) {
        this.viaje = viaje;
        this.cn = new Conexion();
    }

    public void agregarObservador(Observer observer) {
        addObserver(observer);
        setChanged();
        notifyObservers();
    }

    public void regresar() {
        VistaEncomiendas vista = new VistaEncomiendas();
        vista.iniciar();
    }

    public void generar_tabla(JTable tabla) {
        Statement st;
        ResultSet rs;

        try {
            st = cn.getConexion().createStatement();
            rs = st.executeQuery("SELECT * FROM encomiendas WHERE (idviaje = " + obtener_llave() + ")");

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
                viaje.getEncomiendas().add(nuevaE);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        setChanged();
        notifyObservers();
    }

    public int obtener_llave() {
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
