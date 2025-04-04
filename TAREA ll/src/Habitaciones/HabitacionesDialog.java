
package Habitaciones;

import java.awt.Point;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

 
public class HabitacionesDialog extends javax.swing.JDialog {
     private final HabitacionesDAO habitacionDAO;

    public HabitacionesDialog(JFrame parent) {
        super(parent, "Gestion de Habitaciones", true);
        initComponents();
 HabitacionVista habitacionVista = new HabitacionVista();
habitacionVista.cargarEstadosEnComboBox(cbxestado);
  habitacionDAO = new HabitacionesDAO(); // Inicializar el DAO

}
   // Metodo para cargar los datos en los campos
public void cargarDatos(String codigo, String nombre, String tipo, String precio, String estado) {
    // Asignar el codigo al campo de texto correspondiente
    lblcodigo.setText(codigo);  // Asegurate de tener un campo de texto para el codigo

    // Asignar los otros valores a los campos correspondientes
    txtnombre.setText(nombre);
    txtTipo.setText(tipo);
    txtprecio.setText(precio);
    cbxestado.setSelectedItem(estado);
}
   private final List<String> tiposHabitacion = new ArrayList<>(List.of("Individual", "Doble", "Suite", "Familiar"));   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        ppmtipo = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        txtnombre = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        cbxestado = new javax.swing.JComboBox<>();
        lblcodigo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btteditar = new javax.swing.JButton();
        bttlimpiar = new javax.swing.JButton();
        bttagregar = new javax.swing.JButton();
        btteliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(682, 268));

        jPanel1.setBackground(java.awt.SystemColor.inactiveCaption);
        jPanel1.setPreferredSize(new java.awt.Dimension(670, 207));

        txtprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioActionPerformed(evt);
            }
        });

        cbxestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblcodigo.setText("---");

        txtTipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTipoFocusLost(evt);
            }
        });
        txtTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTipoMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtTipoMouseReleased(evt);
            }
        });
        txtTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTipoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTipoKeyReleased(evt);
            }
        });

        jLabel1.setText("Codigo");

        btteditar.setBackground(new java.awt.Color(153, 153, 255));
        btteditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btteditar.setText("Editar");
        btteditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btteditarActionPerformed(evt);
            }
        });

        bttlimpiar.setBackground(new java.awt.Color(255, 255, 204));
        bttlimpiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bttlimpiar.setText("Limpiar");
        bttlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttlimpiarActionPerformed(evt);
            }
        });

        bttagregar.setBackground(new java.awt.Color(204, 255, 204));
        bttagregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bttagregar.setText("Agregar Huesped");
        bttagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttagregarActionPerformed(evt);
            }
        });

        btteliminar.setBackground(new java.awt.Color(255, 102, 102));
        btteliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btteliminar.setText("Eliminar");
        btteliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btteliminarActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo");

        jLabel3.setText("Estado");

        jLabel4.setText("Nombre");

        jLabel5.setText("Precio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtnombre)
                                        .addGap(25, 25, 25)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbxestado, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bttagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btteliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btteditar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bttlimpiar)
                        .addGap(56, 190, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbxestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblcodigo)))))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btteliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(bttagregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btteditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttlimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoKeyReleased
  String text = txtTipo.getText().trim();

    // Si el campo esta vacío, ocultamos el popup
    if (text.isEmpty()) {
        ppmtipo.setVisible(false);
        return;
    }

    // Limpiar el popup para añadir nuevos elementos si se escribe
    ppmtipo.removeAll();

    // Filtrar las opciones que empiezan con el texto escrito
    for (String tipo : tiposHabitacion) {
        if (tipo.toLowerCase().startsWith(text.toLowerCase())) {
            JMenuItem item = new JMenuItem(tipo);
            item.addActionListener(e -> {
                txtTipo.setText(tipo);  // Coloca el tipo seleccionado en el campo de texto
                ppmtipo.setVisible(false);  // Oculta el popup despues de seleccionar
            });
            ppmtipo.add(item);  // Añadir el item al popup
        }
    }

    // Mostrar el popup si tiene elementos
    if (ppmtipo.getComponentCount() > 0) {
        ppmtipo.show(txtTipo, 0, txtTipo.getHeight());  // Muestra el popup debajo del campo
    } else {
        ppmtipo.setVisible(false);  // Oculta el popup si no hay coincidencias
    }
    }//GEN-LAST:event_txtTipoKeyReleased

    private void txtTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoKeyPressed
   
    }//GEN-LAST:event_txtTipoKeyPressed

    private void txtTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTipoMouseClicked
        
    }//GEN-LAST:event_txtTipoMouseClicked

    private void txtTipoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTipoMouseReleased
     
    }//GEN-LAST:event_txtTipoMouseReleased

    private void txtTipoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTipoFocusLost
     String text = txtTipo.getText().trim();
    
    // Lista de opciones validas debe ser una lista global para que se mantenga
    if (!tiposHabitacion.contains(text) && !text.isEmpty()) {
        tiposHabitacion.add(text);  // Agregar el nuevo tipo si no existe en la lista
    }
    }//GEN-LAST:event_txtTipoFocusLost

    private void btteditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btteditarActionPerformed
       // 1. Validar que halla un codigo de habitacion seleccionado
    String codigoTexto = lblcodigo.getText().trim();
    if (codigoTexto.isEmpty() || codigoTexto.equals("---")) {
        JOptionPane.showMessageDialog(this, "No hay una habitacion seleccionada para editar.", 
            "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 2. Obtener los nuevos valores del formulario
    String nombre = txtnombre.getText().trim();
    String tipo = txtTipo.getText().trim();
    String precioTexto = txtprecio.getText().trim();
    String estado = (String) cbxestado.getSelectedItem();

    // 3. Validar que los campos no estén vacios y que el precio sea valido
    if (nombre.isEmpty() || tipo.isEmpty() || precioTexto.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Nombre, Tipo y Precio son campos obligatorios.", 
            "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 4. Valida formato del precio
    double precio;
    try {
        precio = Double.parseDouble(precioTexto);
        if (precio <= 0) {
            JOptionPane.showMessageDialog(this, "El precio debe ser mayor que cero.", 
                "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El precio debe ser un numero válido.", 
            "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 5. Crea el objeto HabitacionesModelo con los datos actualizados
    HabitacionesModelo habitacion = new HabitacionesModelo();
    habitacion.setId(Integer.parseInt(codigoTexto));
    habitacion.setNombre(nombre);
    habitacion.setTipo(tipo);
    habitacion.setPrecio(precio);
    habitacion.setEstado(estado);

    // 6. Valida que la habitación sea valida
    if (!habitacion.esValido()) {
        JOptionPane.showMessageDialog(this, "Los datos de la habitación no son válidos.", 
            "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 7. Confirma la edicion
    int confirmacion = JOptionPane.showConfirmDialog(this, 
        "¿Está seguro que desea actualizar esta habitacion?", 
        "Confirmar actualizacion", JOptionPane.YES_NO_OPTION);
    
    if (confirmacion != JOptionPane.YES_OPTION) {
        return;
    }

    // 8. Llamar al DAO para actualizar
    boolean exito = habitacionDAO.actualizarHabitacion(habitacion);
    if (exito) {
        JOptionPane.showMessageDialog(this, "Habitacion actualizada correctamente.",
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        // Cerrar el diálogo
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo actualizar la habitación.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btteditarActionPerformed

    private void bttlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttlimpiarActionPerformed
        lblcodigo.setText("");
        txtnombre.setText("");
        txtTipo.setText("");
        txtprecio.setText("");
    }//GEN-LAST:event_bttlimpiarActionPerformed

    private void bttagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttagregarActionPerformed
     // Obtener los valores de los campos del formulario
    String nombre = txtnombre.getText();  
    String tipo = txtTipo.getText();      
    double precio;
    
    try {
        precio = Double.parseDouble(txtprecio.getText());  
        if (precio <= 0) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un numero mayor que cero.");
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El precio debe ser un numero valido.");
        return;
    }

    String estado = (String) cbxestado.getSelectedItem();  
    
    // Validación básica
    if (nombre.isEmpty() || tipo.isEmpty() || estado == null) {
        JOptionPane.showMessageDialog(this, "Por favor ingrese todos los datos correctamente.");
        return;
    }

    // Crea el modelo de habitaciin con los datos obtenidos
    HabitacionesModelo habitacion = new HabitacionesModelo(nombre, tipo, precio, estado);

  
    boolean exito = habitacionDAO.agregarHabitacion(habitacion); 
    if (exito) {
        JOptionPane.showMessageDialog(this, "Habitacion agregada correctamente.");
        
        // Limpia los campos despues de agregar
        txtnombre.setText("");
        txtTipo.setText("");
        txtprecio.setText("");
        cbxestado.setSelectedIndex(0);  // Resetea el JComboBox al primer valor

        this.dispose();  // Cierra el dialogo
    } else {
        JOptionPane.showMessageDialog(this, "Error al agregar la habitacion.");
    }
    }//GEN-LAST:event_bttagregarActionPerformed

    private void btteliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btteliminarActionPerformed
     // Obtener el código de la habitación desde el campo de texto (asumiendo que se ingresa en lblcodigo)
        String codigoTexto = lblcodigo.getText().trim(); // El código debe estar en un campo como lblcodigo
        
        if (codigoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un codigo para eliminar.");
            return;
        }

        // Convertir a numero entero el código de la habitación
        int id;
        try {
            id = Integer.parseInt(codigoTexto); // Intentamos convertir el código a número entero
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código inválido. Debe ser un numero.");
            return;
        }

        // Confirmar la eliminacion
        int confirmacion = JOptionPane.showConfirmDialog(this, 
            "¿Está seguro de eliminar esta habitacion?", "Confirmar eliminacion", 
            JOptionPane.YES_NO_OPTION);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            // Llamar al metodo de eliminar en HabitacionesDAO
            boolean eliminado = habitacionDAO.eliminarHabitacion(id);
            if (eliminado) {
                JOptionPane.showMessageDialog(this, "Habitacion eliminada con exito.");
             
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro la habitacion con ese codigo.");
            }
        }
    }//GEN-LAST:event_btteliminarActionPerformed

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioActionPerformed

 
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
            java.util.logging.Logger.getLogger(HabitacionesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HabitacionesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HabitacionesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HabitacionesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            HabitacionesDialog dialog = new HabitacionesDialog(new javax.swing.JFrame());
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttagregar;
    private javax.swing.JButton btteditar;
    private javax.swing.JButton btteliminar;
    private javax.swing.JButton bttlimpiar;
    private javax.swing.JComboBox<String> cbxestado;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JPopupMenu ppmtipo;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
