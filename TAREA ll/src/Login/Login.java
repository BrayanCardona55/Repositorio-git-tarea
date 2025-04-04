/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Login;
import Principal.Principal;
import BD.ConexionBD;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JFrame;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class Login extends javax.swing.JFrame {
   // Declaración del JPasswordField
    

    public Login() {
        initComponents();
    // se ajusta el tamaño de la ventana
    setSize(456, 344);
    // cuando se cierra la ventana se cierra toda la aplicacion
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // pone la ventana en el centro de la pantalla
    setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtusuario = new javax.swing.JTextField();
        bttentrar = new javax.swing.JButton();
        txtcontrasena = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(496, 274));

        bttentrar.setBackground(java.awt.SystemColor.textHighlight);
        bttentrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bttentrar.setForeground(new java.awt.Color(255, 255, 255));
        bttentrar.setText("Entrar");
        bttentrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttentrarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(java.awt.SystemColor.textHighlight);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hotel Login");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(31, 31, 31))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Usuario_________________________________");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Contraseña_____________________________");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcontrasena)
                    .addComponent(txtusuario)
                    .addComponent(bttentrar, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(bttentrar)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttentrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttentrarActionPerformed
String usuario = txtusuario.getText();  
char[] contrasena = txtcontrasena.getPassword();  
String contrasenaString = new String(contrasena);

// Verifica si el usuario o la contraseña estan vacios
if (usuario.isEmpty() || contrasenaString.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Por favor ingrese usuario y contraseña.");
    return;
}

// Consulta para verificar la contraseña
String query = "SELECT password_hash, rol FROM usuarios WHERE username = ?";

try {
    // Crea instancia de la clase ConexionBD
    ConexionBD conexionBD = new ConexionBD();

    // Intenta conectar a la base de datos
    if (conexionBD.conectar()) {
        Connection conn = conexionBD.getConexion();

        // Verifica si la conexion es nula
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Error: No se pudo conectar a la base de datos.");
            return;
        }

        // Prepara la consulta SQL
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, usuario);

        // Ejecuta la consulta
        ResultSet rs = pst.executeQuery();

        // Verifica si se encontro el usuario
        if (rs.next()) {
            String passwordHash = rs.getString("password_hash");
            String rol = rs.getString("rol");  // Obtiene el rol del usuario

            // Imprime el hash de la base de datos y la contraseña ingresada para depuracion
            System.out.println("Hash en BD: " + passwordHash);
            System.out.println("Contraseña ingresada: " + contrasenaString);

            // Verifica la contraseña usando BCrypt
            if (BCrypt.checkpw(contrasenaString, passwordHash)) {
                // Inicia sesion guardando el usuario y el rol
                SesionUsuarios.getInstancia().iniciarSesion(usuario, rol);

                // Muestra mensaje de bienvenida
                JOptionPane.showMessageDialog(this, "¡Bienvenido!");

                // Abre la ventana principal
                Principal principal = new Principal();
                principal.setVisible(true);

                // Cierra la ventana de login
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Contraseña incorrecta.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado.");
        }

        // Cierra recursos
        rs.close();
        pst.close();
        conn.close();
    } else {
        JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.");
    }
} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Error al ejecutar la consulta: " + e.getMessage());
} catch (HeadlessException e) {
    JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage());
}
    }//GEN-LAST:event_bttentrarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttentrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtcontrasena;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
