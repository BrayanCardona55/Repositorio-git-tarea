package Reservas;

import BD.ConexionBD;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author braya
 */
public class Reservas extends javax.swing.JDialog {

    /**
     * Creates new form Reservas
     * @param parent
     * @param modal
     */
    public Reservas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
     
        setSize(990, 720);
        setLocationRelativeTo(null);
        cargarDatos();
        cargarHabitacionesDisponibles();
         
       
         setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public void cargarDatos() {
       DefaultTableModel model = new DefaultTableModel();

    
    model.addColumn("ID Reserva");
    model.addColumn("ID Huesped");
    model.addColumn("Huésped");
    model.addColumn("ID Habitación");
    model.addColumn("Habitación");
    model.addColumn("Tipo de Habitación");
    model.addColumn("Fecha de Inicio");
    model.addColumn("Fecha de Fin");


    ConexionBD conexionBD = new ConexionBD();
    
    if (conexionBD.conectar()) {
  
        Connection conn = conexionBD.getConexion();
        
   
        String query = "SELECT r.id, h.id AS ID_Huesped, h.nombre AS huesped, ha.id AS ID_Habitacion, ha.nombre AS habitacion_nombre, ha.tipo AS habitacion_tipo, r.fecha_inicio, r.fecha_fin " +
                       "FROM reservas r " +
                       "JOIN huespedes h ON r.huesped_id = h.id " +
                       "JOIN habitaciones ha ON r.habitacion_id = ha.id";
        
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
         
            while (rs.next()) {
                Object[] fila = new Object[8];  

           
                fila[0] = rs.getInt("id");
                fila[1] = rs.getInt("id_huesped");
                fila[2] = rs.getString("huesped");  
                fila[3] = rs.getInt("ID_Habitacion"); 
                fila[4] = rs.getString("habitacion_nombre"); 
                fila[5] = rs.getString("habitacion_tipo");  
                fila[6] = rs.getDate("fecha_inicio");
                fila[7] = rs.getDate("fecha_fin"); 

                // Añadir la fila a la tabla
                model.addRow(fila);
            }
           
            tablareservas.setModel(model);
            
             tablareservas.getColumnModel().getColumn(1).setMinWidth(0);
            tablareservas.getColumnModel().getColumn(1).setMaxWidth(0);
            tablareservas.getColumnModel().getColumn(1).setWidth(0);
              tablareservas.getColumnModel().getColumn(3).setMinWidth(0);
            tablareservas.getColumnModel().getColumn(3).setMaxWidth(0);
            tablareservas.getColumnModel().getColumn(3).setWidth(0);
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la base de datos: " + e.getMessage());
        }

  
        conexionBD.cerrarConexion();
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos.");
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField1 = new java.awt.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablareservas = new javax.swing.JTable();
        txtIdhuesped = new javax.swing.JTextField();
        lblIdhuesped = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxhab_disponible = new javax.swing.JComboBox<>();
        lblIdhabitacion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtfecha_inicio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtfecha_fin = new javax.swing.JTextField();
        bttagregar = new javax.swing.JButton();
        btteliminar = new javax.swing.JButton();
        txtIdreserva = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuSalir = new javax.swing.JMenuItem();

        textField1.setText("textField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablareservas.setModel(new javax.swing.table.DefaultTableModel(
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
        tablareservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablareservasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablareservas);

        txtIdhuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdhuespedActionPerformed(evt);
            }
        });
        txtIdhuesped.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdhuespedKeyReleased(evt);
            }
        });

        lblIdhuesped.setText("---");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Reservas");

        jLabel2.setText("Codigo de huesped");

        cbxhab_disponible.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxhab_disponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxhab_disponibleActionPerformed(evt);
            }
        });

        lblIdhabitacion.setText("---");

        jLabel3.setText("Habitaciones disponibles");

        jLabel4.setText("Fecha de entrada");

        jLabel5.setText("Fecha de salida");

        bttagregar.setText("Guardar");
        bttagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttagregarActionPerformed(evt);
            }
        });

        btteliminar.setText("Eliminar");
        btteliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btteliminarActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");

        jMenu1.setText("Menu");

        MenuSalir.setText("Cerrar sesión ");
        MenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(MenuSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIdhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxhab_disponible, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtIdreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtIdhuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblIdhuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtfecha_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfecha_inicio)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bttagregar)
                            .addComponent(btteliminar))
                        .addGap(276, 276, 276))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(bttagregar))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfecha_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btteliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfecha_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdhuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdhuesped))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIdhabitacion)
                            .addComponent(cbxhab_disponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdhuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdhuespedActionPerformed
     
    }//GEN-LAST:event_txtIdhuespedActionPerformed

    private void txtIdhuespedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdhuespedKeyReleased
          // Acción cuando el usuario presiona "Enter" en el campo txtIdhuesped
        String idHuesped = txtIdhuesped.getText().trim();

        if (!idHuesped.isEmpty()) {
            // Realizamos la consulta en la base de datos para obtener el nombre del huésped
            ConexionBD conexionBD = new ConexionBD();
            if (conexionBD.conectar()) {
                try (Connection conn = conexionBD.getConexion()) {
                    // Preparamos la consulta SQL para buscar el nombre del huésped por su ID
                    String query = "SELECT nombre FROM huespedes WHERE id = ?";
                    try (PreparedStatement stmt = conn.prepareStatement(query)) {
                        stmt.setInt(1, Integer.parseInt(idHuesped));  // Usamos el ID proporcionado por el usuario

                        // Ejecutamos la consulta
                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                            // Si el huésped se encuentra en la base de datos, mostramos su nombre
                            String nombreHuesped = rs.getString("nombre");
                            lblIdhuesped.setText(nombreHuesped);
                        } else {
                            // Si no encontramos el huésped, mostramos un mensaje
                            lblIdhuesped.setText("No aparece en la base de datos.");
                        }
                    }
                } catch (SQLException e) {
                    // En caso de error con la base de datos, mostramos un mensaje de error
                    lblIdhuesped.setText("Error al consultar la base de datos.");
                } catch (NumberFormatException e) {
                    // Si el ID no es un número válido, mostramos un mensaje
                    lblIdhuesped.setText("Por favor ingrese un ID válido.");
                }
            } else {
                lblIdhuesped.setText("No se pudo conectar a la base de datos.");
            }
        } else {
            lblIdhuesped.setText("Por favor ingrese un ID.");
        }
    }//GEN-LAST:event_txtIdhuespedKeyReleased

    private void cbxhab_disponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxhab_disponibleActionPerformed
        // Obtener la habitación seleccionada
    String seleccionada = (String) cbxhab_disponible.getSelectedItem();
    
    // Verificar si hay una selección válida
    if (seleccionada != null && !seleccionada.isEmpty()) {
        // Intentar dividir el texto de la selección
        String[] datos = seleccionada.split(" - ");
        
        if (datos.length == 2) {  // Verificar que haya tanto nombre como tipo
            String nombreHabitacion = datos[0];  // Nombre de la habitación
            String tipoHabitacion = datos[1];    // Tipo de la habitación
            
            // Conectar a la base de datos usando ConexionBD
            ConexionBD conexionBD = new ConexionBD();
            
            if (conexionBD.conectar()) {
                try (Connection conn = conexionBD.getConexion()) {
                    // Consulta para obtener el ID de la habitación por nombre y tipo
                    String query = "SELECT id FROM habitaciones WHERE nombre = ? AND tipo = ? AND estado = 'Disponible'";
                    
                    try (PreparedStatement stmt = conn.prepareStatement(query)) {
                        stmt.setString(1, nombreHabitacion);
                        stmt.setString(2, tipoHabitacion);
                        
                        try (ResultSet rs = stmt.executeQuery()) {
                            if (rs.next()) {
                                int idHabitacion = rs.getInt("id");
                                
                                // Ahora mostramos el ID de la habitación en el JLabel
                                lblIdhabitacion.setText(String.format("%05d",idHabitacion));
                            } else {
                                JOptionPane.showMessageDialog(this, "No se encontró la habitación disponible con el nombre y tipo especificados.");
                            }
                        }
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error al obtener el ID de la habitación: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos.");
            }
        } else {
            // Mostrar un mensaje si el formato de la habitación seleccionada no es correcto
            JOptionPane.showMessageDialog(this, "El formato de la selección es incorrecto. Verifique que tenga 'Nombre - Tipo'.");
        }
    }
    }//GEN-LAST:event_cbxhab_disponibleActionPerformed

    private void bttagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttagregarActionPerformed
    // Obtener los valores de los campos de texto
    String idHuespedStr = txtIdhuesped.getText();  // ID del huésped
    String idHabitacionStr = lblIdhabitacion.getText();  // ID de la habitación
    String fechaInicioStr = txtfecha_inicio.getText();  // Fecha de inicio
    String fechaFinStr = txtfecha_fin.getText();  // Fecha de fin

    // Validar que todos los campos tienen datos válidos
    if (idHuespedStr.isEmpty() || idHabitacionStr.isEmpty() || fechaInicioStr.isEmpty() || fechaFinStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.");
        return;
    }

    // Verificar que las fechas estén en el formato correcto (yyyy-MM-dd)
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    formatoFecha.setLenient(false);  // Esto evita que fechas inválidas como 2025-02-30 sean aceptadas

    try {
        // Intentamos analizar la fecha de inicio y fin
        java.util.Date fechaInicio = formatoFecha.parse(fechaInicioStr);
        java.util.Date fechaFin = formatoFecha.parse(fechaFinStr);

        // Verificar que la fecha de inicio no sea posterior a la fecha de fin
        if (fechaInicio.after(fechaFin)) {
            JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser posterior a la fecha de fin.");
            return;
        }

        // Convertir las fechas a java.sql.Date para insertarlas en la base de datos
        java.sql.Date sqlFechaInicio = new java.sql.Date(fechaInicio.getTime());
        java.sql.Date sqlFechaFin = new java.sql.Date(fechaFin.getTime());

        // Conectar a la base de datos para guardar la reserva
        ConexionBD conexionBD = new ConexionBD();

        if (conexionBD.conectar()) {
            try (Connection conn = conexionBD.getConexion()) {
                // Iniciar transacción para asegurar que ambos procesos (insertar y actualizar) se realicen correctamente
                conn.setAutoCommit(false); // Desactivar el auto-commit para controlar la transacción

                try {
                    // Preparar la consulta SQL para insertar la reserva
                    String queryInsert = "INSERT INTO reservas (huesped_id, habitacion_id, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement stmt = conn.prepareStatement(queryInsert)) {
                        // Asignar los valores a la consulta
                        stmt.setInt(1, Integer.parseInt(idHuespedStr));  // ID del huésped
                        stmt.setInt(2, Integer.parseInt(idHabitacionStr));  // ID de la habitación
                        stmt.setDate(3, sqlFechaInicio);  // Fecha de inicio
                        stmt.setDate(4, sqlFechaFin);  // Fecha de fin

                        // Ejecutar la inserción de la reserva
                        int filasInsertadas = stmt.executeUpdate();

                        if (filasInsertadas > 0) {
                            // Ahora actualizamos el estado de la habitación a "Ocupado"
                            String queryUpdate = "UPDATE habitaciones SET estado = 'Ocupada' WHERE id = ?";
                            try (PreparedStatement stmtUpdate = conn.prepareStatement(queryUpdate)) {
                                stmtUpdate.setInt(1, Integer.parseInt(idHabitacionStr));  // ID de la habitación
                                int filasActualizadas = stmtUpdate.executeUpdate();

                                if (filasActualizadas > 0) {
                                    // Commit de la transacción si ambas operaciones fueron exitosas
                                    conn.commit();
                                    cargarHabitacionesDisponibles();
                                     cargarDatos();
                                    JOptionPane.showMessageDialog(this, "Reserva agregada correctamente y habitación marcada como Ocupada.");
                                } else {
                                    // Si la actualización no afecta ninguna fila, hacemos un rollback
                                    conn.rollback();
                                    JOptionPane.showMessageDialog(this, "Error al actualizar el estado de la habitación.");
                                }
                            }
                        } else {
                            // Si la inserción no se realizó correctamente, hacemos un rollback
                            conn.rollback();
                            JOptionPane.showMessageDialog(this, "Error al agregar la reserva.");
                        }
                    }
                } catch (SQLException e) {
                    conn.rollback();  // Si ocurre un error, hacemos rollback
                    JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + e.getMessage());
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos.");
        }
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Por favor ingrese las fechas en formato 'yyyy-MM-dd'.");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor ingrese un ID válido para el huésped y la habitación.");
    }
    }//GEN-LAST:event_bttagregarActionPerformed

    private void btteliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btteliminarActionPerformed
       // Obtener los valores de los campos de texto
    String idReservaStr = txtIdreserva.getText();  // ID de la reserva
    String idHabitacionStr = lblIdhabitacion.getText();  // ID de la habitación

    // Validar que el ID de la reserva no esté vacío
    if (idReservaStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor seleccione una reserva para eliminar.");
        return;
    }

    // Verificar si el ID de la habitación es válido
    if (idHabitacionStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor seleccione una habitación.");
        return;
    }

    try {
        // Conectar a la base de datos para eliminar la reserva
        ConexionBD conexionBD = new ConexionBD();

        if (conexionBD.conectar()) {
            try (Connection conn = conexionBD.getConexion()) {
                // Iniciar transacción para asegurar que ambos procesos (eliminar y actualizar) se realicen correctamente
                conn.setAutoCommit(false);  // Desactivar el auto-commit para controlar la transacción

                try {
                    // Preparar la consulta SQL para eliminar la reserva
                    String queryDelete = "DELETE FROM reservas WHERE id = ?";
                    try (PreparedStatement stmtDelete = conn.prepareStatement(queryDelete)) {
                        stmtDelete.setInt(1, Integer.parseInt(idReservaStr));  // ID de la reserva
                        int filasEliminadas = stmtDelete.executeUpdate();

                        if (filasEliminadas > 0) {
                            // Si la reserva fue eliminada correctamente, actualizamos el estado de la habitación
                            String queryUpdate = "UPDATE habitaciones SET estado = 'Disponible' WHERE id = ?";
                            try (PreparedStatement stmtUpdate = conn.prepareStatement(queryUpdate)) {
                                stmtUpdate.setInt(1, Integer.parseInt(idHabitacionStr));  // ID de la habitación
                                int filasActualizadas = stmtUpdate.executeUpdate();

                                if (filasActualizadas > 0) {
                                    // Commit de la transacción si ambas operaciones fueron exitosas
                                    conn.commit();
                                    cargarHabitacionesDisponibles();
                                    cargarDatos(); // Recargar los datos en la interfaz
                                    JOptionPane.showMessageDialog(this, "Reserva eliminada y habitación marcada como Disponible.");
                                } else {
                                    // Si la actualización no afecta ninguna fila, hacemos un rollback
                                    conn.rollback();
                                    JOptionPane.showMessageDialog(this, "Error al actualizar el estado de la habitación.");
                                }
                            }
                        } else {
                            // Si la eliminación no se realizó correctamente, hacemos un rollback
                            conn.rollback();
                            JOptionPane.showMessageDialog(this, "Error al eliminar la reserva.");
                        }
                    }
                } catch (SQLException e) {
                    conn.rollback();  // Si ocurre un error, hacemos rollback
                    JOptionPane.showMessageDialog(this, "Error al eliminar la reserva: " + e.getMessage());
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor ingrese un ID válido para la reserva y la habitación.");
    }
    }//GEN-LAST:event_btteliminarActionPerformed

    private void tablareservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablareservasMouseClicked
        // Obtener la fila seleccionada
    int row = tablareservas.rowAtPoint(evt.getPoint());  // Obtiene la fila en la que se hizo clic
    
    // Verificar si la fila seleccionada es válida
    if (row >= 0) {
        // Obtener los valores de la fila seleccionada
        String idReserva = tablareservas.getValueAt(row, 0).toString();  // Suponiendo que el ID de la reserva está en la columna 0
        String idHuesped = tablareservas.getValueAt(row, 1).toString();  // Suponiendo que el ID del huésped está en la columna 1
        String idHabitacion = tablareservas.getValueAt(row, 3).toString();  // Suponiendo que el ID de la habitación está en la columna 2
        String fechaInicio = tablareservas.getValueAt(row, 6).toString();  // Suponiendo que la fecha de inicio está en la columna 3
        String fechaFin = tablareservas.getValueAt(row, 7).toString();  // Suponiendo que la fecha de fin está en la columna 4

        // Ahora actualizamos los campos de texto y etiquetas con los valores obtenidos
        txtIdreserva.setText(idReserva);  // Asumiendo que tienes un JTextField para el ID de la reserva
        txtIdhuesped.setText(idHuesped);  // Asumiendo que tienes un JTextField para el ID del huésped
        lblIdhabitacion.setText(idHabitacion);
        txtfecha_inicio.setText(fechaInicio);  // Asumiendo que tienes un JTextField para la fecha de inicio
        txtfecha_fin.setText(fechaFin);  // Asumiendo que tienes un JTextField para la fecha de fin
    }
    }//GEN-LAST:event_tablareservasMouseClicked

    private void MenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSalirActionPerformed
      // Cerrar solo el JDialog (no todo el programa)
    this.dispose();
        
    }//GEN-LAST:event_MenuSalirActionPerformed

    public void cargarHabitacionesDisponibles() {
    // Crear el modelo del JComboBox
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
    
    // Conectar a la base de datos
    ConexionBD conexionBD = new ConexionBD();
    
    if (conexionBD.conectar()) {
        Connection conn = conexionBD.getConexion();
        // Consulta para obtener habitaciones disponibles
        String query = "SELECT id, nombre, tipo FROM habitaciones WHERE estado = 'Disponible'";
        
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                
                // Crear un string que combine el nombre y tipo de habitación
                String habitacionInfo = nombre + " - " + tipo;
                
                // Agregar la información al modelo del JComboBox
                model.addElement(habitacionInfo);
            }
            
            // Establecer el modelo al JComboBox
            cbxhab_disponible.setModel(model);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las habitaciones disponibles: " + e.getMessage());
        }
        
        // Cerrar la conexión
        conexionBD.cerrarConexion();
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos.");
    }
}
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
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Reservas dialog = new Reservas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuSalir;
    private javax.swing.JButton bttagregar;
    private javax.swing.JButton btteliminar;
    private javax.swing.JComboBox<String> cbxhab_disponible;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdhabitacion;
    private javax.swing.JLabel lblIdhuesped;
    private javax.swing.JTable tablareservas;
    private java.awt.TextField textField1;
    private javax.swing.JTextField txtIdhuesped;
    private javax.swing.JTextField txtIdreserva;
    private javax.swing.JTextField txtfecha_fin;
    private javax.swing.JTextField txtfecha_inicio;
    // End of variables declaration//GEN-END:variables
}
