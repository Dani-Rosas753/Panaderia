
package Ventanas.Login;

import Clases.Usuarios;
import DAO.DAOException;
import DAO.DAOManager;
import Ventanas.MenuPrincipal.MenuPrincipal;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    private DAOManager manager;
    
    private Usuarios user;
    
    private boolean bandera = false;
    
    public Login(DAOManager manager) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
        this.manager = manager;
    }
    
    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
    
    private void vaciarCajas(){
        idUsuario.setText("");
        usuario.setText("");
        passwordUsuaro.setText("");
    }
    
    private boolean comprobar(String a, String b) {
        boolean ok = false;
        if (a.length() == b.length()) {
            int j = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(1) == b.charAt(1)) {
                    j++;
                }
            }
            if (a.length() == j) {
                return ok = true;
            }
        }else{
            return ok = false;
        }
        return ok;
    }
    
    private void saveData() throws DAOException {
        if (user == null) {
            user = new Usuarios();
        }
        user.setId(Long.parseLong(idUsuario.getText()));
        user.setUser(usuario.getText());
        user.setPassword(passwordUsuaro.getText());
        
        List<Usuarios> obtenerTodos = manager.getUsuariosDAO().obtenerTodos();
        
        for (int i = 0; i < obtenerTodos.size(); i++) {
            Long id1 = obtenerTodos.get(i).getId();
            Long id2 = user.getId();
            System.out.println(id1);
            System.out.println(id2);
            if (id1 == id2) {
                bandera = true;
            }
        }
        if (bandera) {
            Usuarios uBuscado = manager.getUsuariosDAO().obtener(user.getId());
            if (comprobar(user.getUser(), uBuscado.getUser())) {
                System.out.println("Usuaro ok");
                bandera = true;
            }else{
                bandera = false;
            }
            if (bandera) {
                if (comprobar(user.getPassword(), uBuscado.getPassword())) {
                    System.out.println("Password ok");
                    bandera = true;
                }else{
                    bandera = false;
                }
            }
        }
        vaciarCajas();
        System.out.println(bandera);
        if (bandera) {
            MenuPrincipal menu = new MenuPrincipal(user,manager);
            menu.setLocationRelativeTo(menu);
            menu.setVisible(true);
            this.dispose();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idUsuario = new javax.swing.JTextField();
        btnEntrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        iconoUsuario = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        iconoEmpresa = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        passwordUsuaro = new javax.swing.JPasswordField();
        registrar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idUsuarioKeyTyped(evt);
            }
        });
        getContentPane().add(idUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 310, 260, 30));

        btnEntrar.setBackground(new java.awt.Color(153, 204, 255));
        btnEntrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        btnEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEntrarKeyPressed(evt);
            }
        });
        getContentPane().add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 480, 260, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contraseña");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 410, 250, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Diseñado por NOVA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 484, 370, 60));

        iconoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario final.png"))); // NOI18N
        getContentPane().add(iconoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, 190, 170));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("IDUsuario");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 288, 250, -1));

        iconoEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NOVASYS.png"))); // NOI18N
        getContentPane().add(iconoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 390, 370));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre Usuario");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 350, 250, -1));

        usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usuarioKeyPressed(evt);
            }
        });
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 370, 260, 30));

        passwordUsuaro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordUsuaro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordUsuaroKeyPressed(evt);
            }
        });
        getContentPane().add(passwordUsuaro, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 430, 260, 30));

        registrar.setBackground(new java.awt.Color(153, 255, 153));
        registrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        registrar.setText("Registrar Usuario");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        getContentPane().add(registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 520, 260, 30));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N
        fondo.setText("fo");
        fondo.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1125, 639));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            usuario.requestFocus();
        }
    }//GEN-LAST:event_idUsuarioKeyPressed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        if (idUsuario.getText().equals("") || usuario.getText().equals("") || passwordUsuaro.getText().equals("")) {
                if (passwordUsuaro.getText().equals("")) {
                    passwordUsuaro.requestFocus();
                }
                if (passwordUsuaro.getText().length() <=4) {
                    JOptionPane.showMessageDialog(null, "La Contraseña tiene que ser mayor o igual a 4 digitos");
                    passwordUsuaro.requestFocus();
                }
                if (usuario.getText().equals("")) {
                    usuario.requestFocus();
                }
                if (usuario.getText().length() <= 4) {
                    JOptionPane.showMessageDialog(null, "El nombre tiene que ser mayor o igual a 4 digitos");
                    usuario.requestFocus();
                }
                if (idUsuario.getText().equals("")) {
                    idUsuario.requestFocus();
                }
            }else{
                try {
                //ObtenerUsuario
                saveData();
                } catch (DAOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEntrarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (idUsuario.getText().equals("") && usuario.getText().equals("") && passwordUsuaro.getText().equals("")) {
                if (passwordUsuaro.getText().equals("")) {
                    passwordUsuaro.requestFocus();
                }
                if (usuario.getText().equals("")) {
                    usuario.requestFocus();
                }
                if (idUsuario.getText().equals("")) {
                    idUsuario.requestFocus();
                }
            }else{
                try {
                //ObtenerUsuario
                saveData();
                } catch (DAOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnEntrarKeyPressed

    private void usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            passwordUsuaro.requestFocus();
        }
    }//GEN-LAST:event_usuarioKeyPressed

    private void passwordUsuaroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordUsuaroKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnEntrar.requestFocus();
        }
    }//GEN-LAST:event_passwordUsuaroKeyPressed

    private void idUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idUsuarioKeyTyped
        String caracter = String.valueOf(evt.getKeyChar());
        if (!caracter.matches("[1-9]")) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_idUsuarioKeyTyped

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        Registro nv = new Registro(manager, this, true);
        nv.setLocationRelativeTo(this);
        nv.setVisible(true);
    }//GEN-LAST:event_registrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel iconoEmpresa;
    private javax.swing.JLabel iconoUsuario;
    private javax.swing.JTextField idUsuario;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField passwordUsuaro;
    private javax.swing.JButton registrar;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
