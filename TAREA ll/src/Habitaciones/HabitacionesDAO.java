
package Habitaciones;
import BD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabitacionesDAO {
    private final ConexionBD conexionBD;

    public HabitacionesDAO() {
        this.conexionBD = new ConexionBD();
    }


 // Metodo para obtener los valores posibles del ENUM eestado
    public List<String> obtenerEstados() {
        List<String> estados = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            if (conexionBD.conectar()) {
                conn = conexionBD.getConexion();
                
                // Consulta para obtener los valores posibles del  estado
                String query = "SHOW COLUMNS FROM habitaciones LIKE 'estado'";
                stmt = conn.prepareStatement(query);
                rs = stmt.executeQuery();

                if (rs.next()) {
                    String enumValues = rs.getString("Type"); // Obtiene la cadena del tipo ENUM
                    // Extraemos los valores del ENUM de la cadena recibida
                    enumValues = enumValues.substring(enumValues.indexOf('(') + 1, enumValues.indexOf(')'));
                    String[] valores = enumValues.split(",");
                    for (String valor : valores) {
                        estados.add(valor.replace("'", "").trim()); // Limpia y agrega a la lista
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los valores del ENUM: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                conexionBD.cerrarConexion();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return estados;
    }
    public boolean agregarHabitacion(HabitacionesModelo habitacion) {
        // Obtiene la conexion de la clase ConexionBD
        
        if (!conexionBD.conectar()) {
            System.out.println("Error: No se pudo establecer la conexión.");
            return false;
        }

        // Obtener la conexion despues de que se halla establecido correctamente
        Connection conn = conexionBD.getConexion();
        if (conn == null) {
            System.out.println("Error: la conexión no está establecida.");
            return false;
        }

        try {
            // Sentencia sql para insertar la habitación
            String sql = "INSERT INTO habitaciones (nombre, tipo, precio, estado) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Establecer los parametros en el PreparedStatement
            stmt.setString(1, habitacion.getNombre());
            stmt.setString(2, habitacion.getTipo());
            stmt.setDouble(3, habitacion.getPrecio());
            stmt.setString(4, habitacion.getEstado());

            // Ejecutar la sentencia sql
            int filas = stmt.executeUpdate();

            // Verificar si se agregaron filas correctamente
            return filas > 0; // Se agregó la habitación correctamente
            
            // No se pudo agregar la habitación
        } catch (SQLException e) {
            System.out.println("Error al agregar la habitacion: " + e.getMessage());
            return false;
        } finally {
            // Cerrar la conexion después de realizar la operacion
            conexionBD.cerrarConexion();
        }
    }
// Metodo para eliminar una habitacion por id
    public boolean eliminarHabitacion(int id) {
        if (!conexionBD.conectar()) {
            System.out.println("No se pudo establecer conexión con la base de datos.");
            return false;
        }

        String sql = "DELETE FROM habitaciones WHERE id = ?";
        try (Connection conn = conexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int filasAfectadas = stmt.executeUpdate();

            return filasAfectadas > 0; // Retorna true si al menos una fila fue eliminada
        } catch (SQLException e) {
            System.out.println("Error al eliminar la habitación: " + e.getMessage());
            return false;
        } finally {
            conexionBD.cerrarConexion(); // Cierra la conexion despues de la operacion
        }
    }
    
    public boolean actualizarHabitacion(HabitacionesModelo habitacion) {
        if (!conexionBD.conectar()) {
            System.err.println("Error de conexion");
            return false;
        }

        String sql = "UPDATE habitaciones SET nombre=?, tipo=?, precio=?, estado=? WHERE id=?";
        
        try (Connection conn = conexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, habitacion.getNombre());
            stmt.setString(2, habitacion.getTipo());
            stmt.setDouble(3, habitacion.getPrecio());
            stmt.setString(4, habitacion.getEstado());
            stmt.setInt(5, habitacion.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar habitacion: " + e.getMessage());
            return false;
        } finally {
            conexionBD.cerrarConexion();
        }
    }
}