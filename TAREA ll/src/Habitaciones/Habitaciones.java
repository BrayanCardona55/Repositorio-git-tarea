
package Habitaciones;
import BD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public final class Habitaciones extends javax.swing.JFrame {

    /**
     * Creates new form Habitacion
     */
    public Habitaciones() {
        initComponents();
         // Establece el tamaño del jframe
         setSize(790, 620);
         //Cierra la aplicacion totalmente al cerrar la ventana
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //Centra la ventana en la pantalla
        setLocationRelativeTo(null);
        cargarDatos();
           
    }
    
public void cargarDatos() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
        modelo.addColumn("Precio");
        modelo.addColumn("Estado");

        try {
            ConexionBD conexionBD = new ConexionBD();
            if (conexionBD.conectar()) {
                Connection con = conexionBD.getConexion();
                String consulta = "SELECT * FROM habitaciones";

                try ( // Asegurar que se usa el Statement correcto
                        java.sql.Statement st = con.createStatement(); 
                        ResultSet rs = st.executeQuery(consulta)) {
                    
                    while (rs.next()) {
                        Object[] fila = {
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("tipo"),
                            rs.getDouble("precio"),
                            rs.getString("estado")
                        };
                        modelo.addRow(fila);
                    }
                    
                }
                conexionBD.cerrarConexion();
            } else {
                System.out.println("Error: No se pudo conectar a la base de datos.");
            }
        } catch (SQLException e) {
        }

        TablaHabitacion.setModel(modelo);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaHabitacion = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        bttprocesar4 = new javax.swing.JButton();
        txtbusqueda = new javax.swing.JTextField();
        bttbuscar4 = new javax.swing.JButton();
        bttactualizar4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Habitaciones");
        setName("Habitaciones"); // NOI18N

        TablaHabitacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TablaHabitacion);

        jPanel5.setBackground(java.awt.SystemColor.inactiveCaption);
        jPanel5.setForeground(java.awt.SystemColor.inactiveCaption);

        bttprocesar4.setText("Procesar Huesped");
        bttprocesar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttprocesar4ActionPerformed(evt);
            }
        });

        bttbuscar4.setText("Buscar");
        bttbuscar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttbuscar4ActionPerformed(evt);
            }
        });

        bttactualizar4.setText("Actualizar");
        bttactualizar4.setToolTipText("");
        bttactualizar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttactualizar4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bttbuscar4)
                .addGap(18, 18, 18)
                .addComponent(bttactualizar4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bttprocesar4)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttbuscar4)
                    .addComponent(bttprocesar4)
                    .addComponent(bttactualizar4))
                .addGap(20, 20, 20))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Lista de Habitaciones");

        jMenu1.setText("Menu");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttprocesar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttprocesar4ActionPerformed
        // Obtener la fila seleccionada en la tabla
        int row = TablaHabitacion.getSelectedRow();  // Obtener la fila seleccionada

        if (row != -1) {
            // Obtener los datos de la fila seleccionada
            int codigo = Integer.parseInt(TablaHabitacion.getValueAt(row, 0).toString());
            String nombre = TablaHabitacion.getValueAt(row, 1).toString();
            String tipo = TablaHabitacion.getValueAt(row, 2).toString();
            String precio = String.valueOf(TablaHabitacion.getValueAt(row, 3));
            String estado = TablaHabitacion.getValueAt(row, 4).toString();

            // Formatear el código con ceros a la izquierda
            String codigoFormateado = String.format("%05d", codigo);  // Asegurándonos de que el código tiene 5 dígitos

            java.awt.Frame parentFrame = (java.awt.Frame) SwingUtilities.getWindowAncestor(this);

// Crear la instancia del JDialog
HabitacionesDialog dialog = new HabitacionesDialog((JFrame) parentFrame); // Convertimos a JFrame


            // Llamar al método cargarDatos del JDialog, pasando el código formateado
            dialog.cargarDatos(codigoFormateado, nombre, tipo, precio, estado);
dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila de la tabla.");
        }
    }//GEN-LAST:event_bttprocesar4ActionPerformed

    private void bttbuscar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttbuscar4ActionPerformed
       String criterio = txtbusqueda.getText().trim();  // Obtener el texto del campo de búsqueda
    
    // Verificar que no esté vacío
    if (criterio.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un código, nombre o tipo para buscar.");
        return;
    }

    // Crear el modelo de la tabla
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Id");
    model.addColumn("Nombre");
    model.addColumn("Tipo");
    model.addColumn("Precio");
    model.addColumn("Estado");

    ConexionBD conexionBD = new ConexionBD();

    if (conexionBD.conectar()) {
        Connection conn = conexionBD.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String query = "";

        // Si el criterio es un número, buscar por 'id', si es texto, buscar por 'nombre' o 'tipo'
        if (criterio.matches("\\d+")) { 
            // Si el criterio es un número, buscar por 'id' exacto
            query = "SELECT * FROM habitaciones WHERE id = ?"; 
        } else {  
            // Si el criterio es texto, buscar por 'nombre' o 'tipo' (usando LIKE para coincidencias parciales)
            query = "SELECT * FROM habitaciones WHERE nombre LIKE ? OR tipo LIKE ?"; 
        }

        try {
            pst = conn.prepareStatement(query);
            
            // Establecer los parámetros de la consulta
            if (criterio.matches("\\d+")) {
                pst.setInt(1, Integer.parseInt(criterio));  // Si es numérico, buscar por 'id'
            } else {
                pst.setString(1, "%" + criterio + "%");  // Si es texto, buscar por 'nombre' con comodines
                pst.setString(2, "%" + criterio + "%");  // También buscar por 'tipo' con comodines
            }

            rs = pst.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[5];  // La tabla tiene 5 columnas
                fila[0] = rs.getInt("id");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("tipo");
                fila[3] = rs.getDouble("precio");
                fila[4] = rs.getString("estado");
                model.addRow(fila);
            }

            // Asignar el modelo a la tabla
            TablaHabitacion.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al ejecutar la consulta: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }

        conexionBD.cerrarConexion();
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos.");
    }
    }//GEN-LAST:event_bttbuscar4ActionPerformed

    private void bttactualizar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttactualizar4ActionPerformed
        cargarDatos();
    }//GEN-LAST:event_bttactualizar4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Habitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Habitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Habitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Habitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Habitaciones().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaHabitacion;
    private javax.swing.JButton bttactualizar4;
    private javax.swing.JButton bttbuscar4;
    private javax.swing.JButton bttprocesar4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtbusqueda;
    // End of variables declaration//GEN-END:variables
}
