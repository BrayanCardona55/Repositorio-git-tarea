package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
private Connection conexion;  // Declara la variable para la conexion

// Metodo para conectar a la base de datos
public boolean conectar() {
    try {
        // Carga el driver de MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establece la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/Hotel_reservas";  
        String usuario = "root";  
        String contraseña = "";   

        // Crea la conexión
        conexion = DriverManager.getConnection(url, usuario, contraseña);

        // Verifica si la conexión fue exitosa
        if (conexion != null) {
            System.out.println("Conexion establecida con exito.");
            return true;  // Retorna verdadero si la conexión fue exitosa
        } else {
            System.out.println("Conexion fallida.");
            return false;  // Retorna falso si la conexión no fue exitosa
        }
    } catch (ClassNotFoundException | SQLException ex) {
        // En caso de error muestra un mensaje
        System.out.println("Error al conectar: " + ex.getMessage());
        return false;  // Retorna falso si hubo un error
    }
}

// Metodo para cerrar la conexión
public void cerrarConexion() {
    try {
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
            System.out.println("Conexion cerrada");
        }
    } catch (SQLException ex) {
        System.out.println("Error al cerrar la conexion: " + ex.getMessage());
    }
}

// Metodo para obtener la conexion asegurandose que este establecida
public Connection getConexion() {
    if (conexion == null) {
        System.out.println("Error: la conexion no esta establecida.");
        return null; // Retorna null si la conexion no está establecida
    }
    return conexion;  // Retorna la conexion si está establecida correctamente
}
}

















