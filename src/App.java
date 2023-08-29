import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Conexion.Conexion;
import Variables.Productos;

import java.sql.ResultSet;

//import com.mysql.cj.xdevapi.PreparableStatement;

public class App {
    public static void main(String[] args) throws Exception {
        Productos miproducto = new Productos();
        // Conexion miconexion = new Conexion();
        Conexion.establecerConexion();
        // ----metodo insertar producto en la tabla de la base de datos
        // miproducto.insertarDatos(2, "canela", 50.00);

        // ----- imprimir el listado de productos
        // miproducto.listarProductos();

        // -- eliminar un producto
        // miproducto.setId_producto(1);
        // miproducto.eliminarProducto();
        // -------Buscar producto
        // miproducto.setId_producto(5);
        // miproducto.buscarProducto();
        miproducto.setId_producto(5);
        miproducto.ConsultarProducto();

    }
}
