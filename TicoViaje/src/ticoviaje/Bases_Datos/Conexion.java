package ticoviaje.Bases_Datos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private Connection conexion;

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "12345");
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public void cerrar() {
        try {
            conexion.close();
        } catch (Exception exc) {
        } finally {
            conexion = null;
        }
    }
}
