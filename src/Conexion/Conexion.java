package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection miconexion;

    public static Connection establecerConexion() {

        String url = "jdbc:mysql://localhost:3306/pruebas";
        String user = "root";
        String password = "";
        try {
            // System.out.println("Conexion exitosa");
            return miconexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            e.printStackTrace();
            return null;
        }

    }

}
