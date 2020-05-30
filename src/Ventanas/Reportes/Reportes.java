
package Ventanas.Reportes;

import Clases.Venta;
import DAO.DAOException;
import DAO.DAOManager;
import Ventanas.modelos.TableModelVentas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Reportes extends javax.swing.JFrame {
    
    private Venta venta;
    private DAOManager manager;
    private TableModelVentas model;
    
    public Reportes(DAOManager manager) throws DAOException {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
        this.manager = manager;
        tablaActualizar();
        tablaV.getSelectionModel().addListSelectionListener( e -> {
            if (tablaV.getSelectedRow() != -1) {
                detalle.setEnabled(true);
            }else{
                detalle.setEnabled(false);
            }
        });
    }
    
    public void tablaActualizar() throws DAOException {
        try {
            this.model = new TableModelVentas(manager.getVentaDAO());
            this.model.updateModel();
            this.tablaV.setModel(model);
            tablaV.getTableHeader().setReorderingAllowed(false);
            tamColum();
        } catch (DAOException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveData() throws ParseException, DAOException {
        //Formato inicial.  
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaInicio  = fecha.getText();
        Date d = formato.parse(fechaInicio);
        //Aplica formato requerido.
        formato.applyPattern("yyyy/MM/dd");
        String nuevoFormato = formato.format(d);
        System.out.println(nuevoFormato);
        List<Venta> obtenerPorFecha = manager.getVentaDAO().obtenerPorFecha(nuevoFormato);
        if (obtenerPorFecha.size() != 0) {
            model = new TableModelVentas(manager.getVentaDAO());
            model.updateModel(nuevoFormato);
            tablaV.setModel(model);
            tamColum();
        }else{
            JOptionPane.showMessageDialog(null, "No Existen Ventas Registradas con esta Fecha");
        }
    }
    
    private void tamColum() {
        tablaV.getColumn("id").setPreferredWidth(3);
        tablaV.getColumn("id").setResizable(false);
        tablaV.getColumn("Fecha").setPreferredWidth(300);
        tablaV.getColumn("Fecha").setResizable(false);
        tablaV.getColumn("Hora").setPreferredWidth(50);
        tablaV.getColumn("Hora").setResizable(false);
        tablaV.getColumn("Usuario").setPreferredWidth(3);
        tablaV.getColumn("Usuario").setResizable(false);
        tablaV.getColumn("Total").setPreferredWidth(5);
        tablaV.getColumn("Total").setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGenerar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaV = new javax.swing.JTable();
        fecha = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        detalle = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGenerar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, -1));

        tablaV.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaV);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 686, 350));

        fecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        fecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 141, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Fecha");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 141, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reportes");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 49));

        detalle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        detalle.setText("Mostrar Detalle");
        detalle.setEnabled(false);
        detalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalleActionPerformed(evt);
            }
        });
        getContentPane().add(detalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 420, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reportes.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        if (fecha.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Inserte Fecha");
        }else{
            try {
                saveData();
            } catch (ParseException | DAOException ex) {
                Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            tablaActualizar();
        } catch (DAOException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    Venta obtenerSeleccionado() throws DAOException{
        Long id = (Long) model.getValueAt(tablaV.getSelectedRow(), 0);
        return manager.getVentaDAO().obtener(id);
    }
    
    private void detalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detalleActionPerformed
        try {
            venta = obtenerSeleccionado();
            DetalleVentaFrame dvf = new DetalleVentaFrame(venta, manager, this, true);
            dvf.setLocationRelativeTo(this);
            dvf.setVisible(true);
        } catch (DAOException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_detalleActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton detalle;
    private javax.swing.JFormattedTextField fecha;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaV;
    // End of variables declaration//GEN-END:variables
}
