package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Connection conexion;

    // Metodo para conectar a la base de datos
    public boolean conectar() {
        try {
            // Carga el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establece la conexión a la base de datos
            String url = "jdbc:mysql://localhost:3306/Hotel_reservas";  // Ajusta la URL si es necesario
            String usuario = "root";  // Ajusta el usuario si es necesario
            String contraseña = "";   // Ajusta la contraseña si es necesario

            // Crea la conexión
            conexion = DriverManager.getConnection(url, usuario, contraseña);

            // Verifica si la conexión fue exitosa
            if (conexion != null) {
                System.out.println("Conexión establecida con éxito.");
                return true;
            } else {
                System.out.println("Conexión fallida.");
                return false;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            // En caso de error muestra un mensaje
            System.out.println("Error al conectar: " + ex.getMessage());
            return false;
        }
    }

    // Metodo para cerrar la conexión
    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }

    // Metodo para obtener la conexión asegurándose que esté establecida
    public Connection getConexion() {
        if (conexion == null) {
            System.out.println("Error: la conexión no está establecida.");
            return null; // Retorna null si la conexión no está establecida
        }
        return conexion;  // Retorna la conexión si está establecida correctamente
    }
}