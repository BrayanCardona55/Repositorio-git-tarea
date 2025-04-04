package Principal;


import Login.SesionUsuarios;
import Reservas.Reservas;
import BD.ConexionBD;
import Habitaciones.Habitaciones;
import Huesped.HuespedI;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;


public final class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
               
         // Establece el tamaño del jframe
         setSize(790, 620);
         //Evita cerrar el jframe de manera predeterminada
         setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         //Centra la ventana en la pantalla.
        setLocationRelativeTo(null);
        
        cargarTablaInicio();
        
          String usuario = SesionUsuarios.getInstancia().getUsuario();
        String rol = SesionUsuarios.getInstancia().getRol();

        // Mostrar el nombre del usuario en la etiqueta
        lblusuario.setText("Sesión activa: " + usuario + " (" + rol + ")");  // Suponiendo que tienes un JLabel llamado lblUsuario

        // Restringir botones según el rol
        if (rol.equals("recepcionista")) {
            btthabitacion.setEnabled(false);  // Suponiendo que tienes un botón llamado btnAdministrarUsuarios
            mniCrearUsuario.setEnabled(false);
        }
    
    }

    public void cargarTablaInicio() {
   // Crea el modelo para la tabla
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID Habitacion");
    model.addColumn("Habitacion");
    model.addColumn("Tipo");
    model.addColumn("Precio");
    model.addColumn("Huesped");
    model.addColumn("Fecha de Inicio");
    model.addColumn("Fecha de Fin");
    model.addColumn("Estado");

    ConexionBD conexionBD = new ConexionBD();
    
    if (conexionBD.conectar()) {
        // Obtiene la conexion a la base de datos
        Connection conn = conexionBD.getConexion();
        
        // Consulta sql para obtener las habitaciones y sus reservas
        String query = "SELECT ha.id AS id_habitacion, ha.nombre AS nombre_habitacion, ha.tipo AS tipo_habitacion, " +
                       "ha.precio, h.nombre AS huesped, r.fecha_inicio, r.fecha_fin, ha.estado " +
                       "FROM habitaciones ha " +
                       "LEFT JOIN reservas r ON ha.id = r.habitacion_id " +
                       "LEFT JOIN huespedes h ON r.huesped_id = h.id " +
                       "ORDER BY ha.id";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            // Agrega los datos a la tabla.
            while (rs.next()) {
                Object[] fila = new Object[8];

                // Llena la fila con los datos
                fila[0] = rs.getInt("id_habitacion");  
                fila[1] = rs.getString("nombre_habitacion");
                fila[2] = rs.getString("tipo_habitacion");  
                fila[3] = rs.getDouble("precio"); 

                // Si el huEsped es NULL, muestra Disponible de lo contrario mostrara el nombre del huesped
                String huesped = rs.getString("huesped");
                fila[4] = (huesped != null) ? huesped : "Disponible"; // aqui muestra disponible si no hay huesped

                // muestra la fecha de inicio de la reserva solo si aplica
                fila[5] = rs.getDate("fecha_inicio") != null ? rs.getDate("fecha_inicio") : "No aplica";

                // muestra a fecha de fin de la reserva solo si aplica
                fila[6] = rs.getDate("fecha_fin") != null ? rs.getDate("fecha_fin") : "No aplica";

                // muestra el estado de la habitacion disponible ocupada o en mantenimiento
                fila[7] = rs.getString("estado");

                // los Añade ala fila de la tabla
                model.addRow(fila);
            }

            // Establece el modelo de la tabla con los datos cargados
            tablaPrincipal.setModel(model);

        } catch (SQLException e) {
            // Mostra mensaje de error si ocurre una excepcion
            JOptionPane.showMessageDialog(this, "Error al cargar las habitaciones: " + e.getMessage());
        }

        // Cierra la conexion
        conexionBD.cerrarConexion();
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos.");
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPrincipal = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btthuesped = new javax.swing.JButton();
        bttreserva = new javax.swing.JButton();
        btthabitacion = new javax.swing.JButton();
        lblusuario = new javax.swing.JLabel();
        bttactualizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mniCrearUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");

        tablaPrincipal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaPrincipal);

        jPanel1.setBackground(java.awt.Color.white);

        btthuesped.setBackground(java.awt.SystemColor.textHighlight);
        btthuesped.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btthuesped.setForeground(new java.awt.Color(255, 255, 255));
        btthuesped.setText("Registrar Huesped");
        btthuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthuespedActionPerformed(evt);
            }
        });

        bttreserva.setBackground(java.awt.SystemColor.textHighlight);
        bttreserva.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bttreserva.setForeground(new java.awt.Color(255, 255, 255));
        bttreserva.setText("Generar Reserva");
        bttreserva.setActionCommand("");
        bttreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttreservaActionPerformed(evt);
            }
        });

        btthabitacion.setBackground(java.awt.SystemColor.textHighlight);
        btthabitacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btthabitacion.setForeground(new java.awt.Color(255, 255, 255));
        btthabitacion.setText("Ingresar Habitacion");
        btthabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthabitacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btthuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bttreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btthabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btthuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btthabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        lblusuario.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblusuario.setText("---");

        bttactualizar.setBackground(java.awt.SystemColor.textHighlight);
        bttactualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bttactualizar.setForeground(new java.awt.Color(255, 255, 255));
        bttactualizar.setText("Actualizar");
        bttactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttactualizarActionPerformed(evt);
            }
        });

        jMenu1.setText("Menu");

        jMenuItem1.setText("Cerrar sesión");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        mniCrearUsuario.setText("Crear usuario");
        mniCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCrearUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(mniCrearUsuario);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bttactualizar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblusuario)
                    .addComponent(bttactualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btthuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthuespedActionPerformed
        // Crea y mostra el jframe principal
        HuespedI huesped = new HuespedI();  
        huesped.setVisible(true);  // Hace visible el jframe
        dispose();  // cierra el jframe
    }//GEN-LAST:event_btthuespedActionPerformed

    private void bttreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttreservaActionPerformed

    Reservas dReservas = new Reservas(this,true); 
   dReservas.setVisible(true);
    }//GEN-LAST:event_bttreservaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // Cerrara la aplicación cuando se haga clic 
                System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btthabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthabitacionActionPerformed
         // Crea y mostra el jframe principal
        Habitaciones habitacion = new Habitaciones();  
        habitacion.setVisible(true);  // Hace visible el jframe
        dispose();  // cierra el jframe
    }//GEN-LAST:event_btthabitacionActionPerformed

    private void mniCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCrearUsuarioActionPerformed
        
         Crearusuario ventana = new Crearusuario(this, true); // 'true' lo hace modal
    ventana.setVisible(true);
        dispose();  // cierra el jframe
    }//GEN-LAST:event_mniCrearUsuarioActionPerformed

    private void bttactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttactualizarActionPerformed
        cargarTablaInicio();
    }//GEN-LAST:event_bttactualizarActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttactualizar;
    private javax.swing.JButton btthabitacion;
    private javax.swing.JButton btthuesped;
    private javax.swing.JButton bttreserva;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblusuario;
    private javax.swing.JMenuItem mniCrearUsuario;
    private javax.swing.JTable tablaPrincipal;
    // End of variables declaration//GEN-END:variables
}
