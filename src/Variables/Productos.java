package Variables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import Conexion.Conexion;

public class Productos {
    private int id_producto;
    private String nombre_producto;
    private double precio;

    public Productos() {
    }

    public Productos(int id_producto, String nombre_producto, double precio) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.precio = precio;

    }

    public int getId_producto() {
        return id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    Connection connection = Conexion.establecerConexion();

    public void insertarDatos(int id_producto, String nombre_producto, Double precio) {

        if (connection != null) {
            String insert = "INSERT INTO productos (id_producto, nombre_producto, precio) VALUES (?, ?, ?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(insert);
                preparedStatement.setInt(1, id_producto);
                preparedStatement.setString(2, nombre_producto);
                preparedStatement.setDouble(3, precio);
                preparedStatement.executeUpdate();
                // System.out.println(rowsAffected + " fila(s) afectada(s)");
                preparedStatement.close();

            } catch (Exception e) {
                System.out.println("no se pude realizar la insercion del producto");
                e.printStackTrace();
            }

        }

    }

    public void listarProductos() {
        if (connection != null) {
            String listar = "select * from productos";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(listar);
                ResultSet miresultSet = preparedStatement.executeQuery();
                while (miresultSet.next()) {
                    System.out.println(
                            miresultSet.getString("id_producto") + " " + miresultSet.getString("nombre_producto"));

                }

            } catch (Exception e) {
                System.out.println("no se pude realizar el listado de productos");
                e.printStackTrace();
            }

        }
    }

    public boolean buscarProducto() {
        String buscar = "select id_producto from productos  WHERE id_producto = ?";
        if (connection != null) {

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(buscar);
                preparedStatement.setInt(1, id_producto);
                ResultSet resultSet = preparedStatement.executeQuery();
                boolean exists = resultSet.next();
                if (exists) {
                    System.out.println("El producto existe");

                } else {
                    System.out.println("El producto NO existe");

                }
                resultSet.close();
                preparedStatement.close();
                connection.close();

                return exists;

            } catch (SQLException e) {
                System.out.println("No hubo conexion con la base de datos");
                e.printStackTrace();
            }

        }
        return false;

    }

    public void eliminarProducto() {
        String delete = "DELETE FROM productos WHERE id_producto = ?";
        if (connection != null) {

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(delete);
                preparedStatement.setInt(1, id_producto);
                preparedStatement.executeUpdate();
                // int rowsAffected = preparedStatement.executeUpdate();
                // System.out.println(rowsAffected + " fila(s) eliminada(s)");
                preparedStatement.close();
                connection.close();

            } catch (SQLException e) {
                System.out.println("no se pude realizar la eliminacion del producto ");
                e.printStackTrace();
            }

        }

    }

    public void ConsultarProducto() {
        String consultar = "select * from productos  WHERE id_producto = ?";
        if (connection != null) {

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(consultar);
                preparedStatement.setInt(1, id_producto);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    System.out.println("el identificador del producto es: " +
                            resultSet.getString("id_producto"));
                    System.out.println("el nombre del producto es: " + resultSet.getString("nombre_producto"));
                    System.out.println("el precio del producto es: " + resultSet.getDouble("precio"));

                } else {
                    System.out.println("producto no encontrado");
                }
                // int rowsAffected = preparedStatement.executeUpdate();
                // System.out.println(rowsAffected + " fila(s) eliminada(s)");
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                System.out.println("no se pude realizar la consulta del producto ");
                e.printStackTrace();
            }

        }

    }

}
