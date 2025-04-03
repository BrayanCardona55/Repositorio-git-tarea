package Huesped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HuespedDAO {
    private final Connection connection;

    // Constructor para recibir la conexión
    public HuespedDAO(Connection connection) {
        this.connection = connection;
    }
   // Método para editar un huésped en la base de datos
    public boolean editarHuesped(HuespedModelo huesped) {
        String sql = "UPDATE huespedes SET nombre = ?, correo = ?, telefono = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // Usar los getters del modelo para obtener los valores
            stmt.setString(1, huesped.getNombre());
            stmt.setString(2, huesped.getCorreo());
            stmt.setString(3, huesped.getTelefono());
            stmt.setInt(4, huesped.getCodigo()); // Asumimos que el 'codigo' en el modelo es el 'id' en la base de datos

            // Ejecutar la actualización
            int filasActualizadas = stmt.executeUpdate();

            // Retornar si se actualizó al menos una fila
            return filasActualizadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al editar el huésped: " + e.getMessage());
            return false;
        }
    }

public boolean eliminarHuesped(int id) {
     String query = "DELETE FROM huespedes WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar huésped: " + e.getMessage());
            return false;
        }
}

   public boolean agregarHuesped(HuespedModelo huesped) {
    String sql = "INSERT INTO huespedes (nombre, correo, telefono) VALUES (?, ?, ?)";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        // Asignamos los valores de los campos al PreparedStatement
        stmt.setString(1, huesped.getNombre());  // Seteamos el nombre
        stmt.setString(2, huesped.getCorreo());  // Seteamos el correo
        stmt.setString(3, huesped.getTelefono());  // Seteamos el teléfono

        // Ejecutamos la actualización en la base de datos
        int filasAfectadas = stmt.executeUpdate();  

        if (filasAfectadas > 0) {
            System.out.println("Huésped agregado con éxito.");
            return true;  // Si la inserción fue exitosa, retornamos true
        } else {
            System.out.println("No se pudo agregar el huésped.");
            return false;  // Si no se agregó, retornamos false
        }
    } catch (SQLException e) {
        System.out.println("Error al agregar huésped: " + e.getMessage());
        return false;  // Si ocurre un error, retornamos false
    }
}
}
