
package Ventanas.Login;

import Clases.Usuarios;
import DAO.DAOException;
import DAO.DAOManager;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Registro extends javax.swing.JDialog {
    private Usuarios newUsuario;
    private DAOManager manager;
    public Registro(DAOManager manager, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
        this.manager = manager;
    }
    private void vaciarCajas() {
        nombreUsuario1.setText("");
        password.setText("");
    }
    private void saveData() throws DAOException {
        if (newUsuario == null) {
            newUsuario = new Usuarios();
        }
        newUsuario.setUser(nombreUsuario1.getText());
        newUsuario.setPassword(password.getText());
        manager.getUsuariosDAO().insertar(newUsuario);
        JOptionPane.showMessageDialog(null, "Usuario Registrado con Exito\n"
                    + "No pierda este identificador\n"
                    + "ID: .:-     "+ newUsuario.getId()+"     -:.\n"
                    + "Lo Usara para Ingresar a la aplicacion\n"
                    + "Nombre: "+ newUsuario.getUser());
        vaciarCajas();
        this.dispose();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreUsuario1 = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Usuario");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario final.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 198, 203));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 150, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombre Usuario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 150, 20));

        nombreUsuario1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombreUsuario1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreUsuario1KeyPressed(evt);
            }
        });
        getContentPane().add(nombreUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 180, -1));

        password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 180, -1));

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrar.setText("Registrar Usuario");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        btnRegistrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnRegistrarKeyPressed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 180, -1));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 180, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registro.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreUsuario1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreUsuario1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (nombreUsuario1.getText().equals("")) {
                nombreUsuario1.requestFocus();
            }else{
                password.requestFocus();
            }
        }
    }//GEN-LAST:event_nombreUsuario1KeyPressed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (password.getText().equals("")) {
                password.requestFocus();
            }else{
                btnRegistrar.requestFocus();
            }
            if (nombreUsuario1.getText().equals("")) {
                nombreUsuario1.requestFocus();
            }
        }
    }//GEN-LAST:event_passwordKeyPressed

    private void btnRegistrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRegistrarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (nombreUsuario1.getText().equals("") || password.getText().equals("")) {
                if (password.getText().equals("")) {
                    password.requestFocus();
                }
                if (nombreUsuario1.getText().equals("")) {
                    nombreUsuario1.requestFocus();
                }
            }else{
                try {
                    saveData();
                } catch (DAOException ex) {
                    Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnRegistrarKeyPressed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (nombreUsuario1.getText().equals("")||nombreUsuario1.getText().length() <= 4 || password.getText().equals("") || password.getText().length() <=4) {
            if (password.getText().equals("")) {
                password.requestFocus();
            }
            if (password.getText().length() <=4) {
                JOptionPane.showMessageDialog(null, "La Contraseña tiene que ser mayor o igual a 4 digitos");
                password.requestFocus();
            }
            if (nombreUsuario1.getText().equals("")) {
                nombreUsuario1.requestFocus();
            }
            if (nombreUsuario1.getText().length() <= 4) {
                JOptionPane.showMessageDialog(null, "El nombre tiene que ser mayor o igual a 4 digitos");
                nombreUsuario1.requestFocus();
            }
        }else{
            try {
                saveData();
            } catch (DAOException ex) {
                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nombreUsuario1;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
}
