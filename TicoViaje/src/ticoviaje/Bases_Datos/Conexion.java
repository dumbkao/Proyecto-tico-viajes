package ticoviaje.Bases_Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection conexion;

    public Conexion() {
        try {
            // Referencia a la libreria que funciona para la conexion con mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "12345");
        } catch (ClassNotFoundException | SQLException e) {
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
        } catch (SQLException exc) {
        } finally {
            conexion = null;
        }
    }
}
