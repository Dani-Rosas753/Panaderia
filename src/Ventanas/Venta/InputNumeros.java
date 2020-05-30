
package Ventanas.Venta;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class InputNumeros extends javax.swing.JDialog {
    
    private int cantidadProductos;
    private boolean bandera;
    
    public InputNumeros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
        bandera=false;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputNum = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Input");
        setMinimumSize(new java.awt.Dimension(255, 135));
        setResizable(false);

        inputNum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        inputNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputNumKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputNumKeyTyped(evt);
            }
        });

        guardar.setBackground(new java.awt.Color(153, 255, 153));
        guardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        guardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                guardarKeyPressed(evt);
            }
        });

        cancelar.setBackground(new java.awt.Color(255, 102, 102));
        cancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Introduzca el Numero de Productos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelar))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(inputNum))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNum, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(cancelar))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNumKeyTyped
        String caracter = String.valueOf(evt.getKeyChar());
        if (!caracter.matches("[1-9]")) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_inputNumKeyTyped

    private void obtener() {
        if (inputNum.getText().equals("")) {
            cantidadProductos = 1;
            bandera=true;
        }else{
            cantidadProductos = Integer.parseInt(inputNum.getText());
            bandera=true;
        }
        this.dispose();
    }
    
    private void inputNumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNumKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            obtener();
        }
    }//GEN-LAST:event_inputNumKeyPressed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        obtener();
    }//GEN-LAST:event_guardarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void guardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_guardarKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            obtener();
        }
    }//GEN-LAST:event_guardarKeyPressed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton guardar;
    private javax.swing.JTextField inputNum;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
