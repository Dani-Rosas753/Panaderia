
package Ventanas.Alta;

import Clases.Categoria;
import DAO.DAOException;
import DAO.DAOManager;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Alta extends javax.swing.JDialog {
    Categoria newCategoria;
    private DAOManager manager;
    
    public Alta(DAOManager manager, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
        this.manager = manager;
    }
    
    public Alta(String nombre, DAOManager manager, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.manager = manager;
        nombreCP.setText(nombre);
        nombreCP.setEditable(false);
    }
    
    private void limpiarCajas() {
        nombreCP.setText("");
        precio.setText("");
        nombreCP.requestFocus();
    }
    
    private void saveData() throws DAOException {
        if (newCategoria == null) {
            newCategoria = new Categoria();
        }
        newCategoria.setNombreCategoria(nombreCP.getText());
        newCategoria.setPrecio(Double.parseDouble(precio.getText()));
        
        manager.getCategoriaDAO().insertar(newCategoria);
        limpiarCajas();
        JOptionPane.showMessageDialog(null, "Producto Generado con Exito "+newCategoria.getNombreCategoria());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreCP = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        precio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta Producto / Categoria");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/image-add-regular-240.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 198, 203));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Precio");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 150, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre Categoria o Producto");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 210, 20));

        nombreCP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombreCP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreCPKeyPressed(evt);
            }
        });
        getContentPane().add(nombreCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 180, -1));

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrar.setText("Registrar");
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

        precio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioKeyTyped(evt);
            }
        });
        getContentPane().add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 180, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registro.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreCPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreCPKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (nombreCP.getText().equals("")) {
                nombreCP.requestFocus();
            }
        }
    }//GEN-LAST:event_nombreCPKeyPressed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (nombreCP.getText().equals("") || precio.getText().equals("")) {
            if (precio.getText().equals("")) {
                precio.requestFocus();
            }
            if (nombreCP.getText().equals("")) {
                nombreCP.requestFocus();
            }
        }else{
            try {
                //Guardar
                saveData();
            } catch (DAOException ex) {
                Logger.getLogger(Alta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnRegistrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRegistrarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (nombreCP.getText().equals("") || precio.getText().equals("")) {
                if (precio.getText().equals("")) {
                    precio.requestFocus();
                }
                if (nombreCP.getText().equals("")) {
                    nombreCP.requestFocus();
                }
            }else{
                try {
                    //Guardar
                    saveData();
                } catch (DAOException ex) {
                    Logger.getLogger(Alta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnRegistrarKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioKeyTyped
        if (!Character.isDigit(evt.getKeyChar())&&evt.getKeyChar()!='.') {
            evt.consume();
        }
        if (evt.getKeyChar()=='.' && precio.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_precioKeyTyped

    private void precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (precio.getText().equals("")) {
                btnRegistrar.requestFocus();
            }
        }
    }//GEN-LAST:event_precioKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nombreCP;
    private javax.swing.JTextField precio;
    // End of variables declaration//GEN-END:variables
}
