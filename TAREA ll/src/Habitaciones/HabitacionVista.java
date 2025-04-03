package Habitaciones;  // Asegúrate de que el paquete es correcto

import javax.swing.JComboBox;
import java.util.List;

public class HabitacionVista {
    private final HabitacionesDAO habitacionDAO;

    public HabitacionVista() {
        habitacionDAO = new HabitacionesDAO();
    }

    public void cargarEstadosEnComboBox(JComboBox<String> comboBox) {
        List<String> estados = habitacionDAO.obtenerEstados();
        comboBox.removeAllItems();
        for (String estado : estados) {
            comboBox.addItem(estado);
        }
    }
}
