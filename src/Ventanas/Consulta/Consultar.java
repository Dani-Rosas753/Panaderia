
package Ventanas.Consulta;

import Clases.Categoria;
import Clases.DetalleVenta;
import DAO.DAOException;
import DAO.DAOManager;
import Ventanas.modelos.TableModelCategorias;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Consultar extends javax.swing.JDialog {
    
    private TableModelCategorias model;
    private DAOManager manager;
    private Categoria categoria;
    
    public Consultar(DAOManager manager, java.awt.Frame parent, boolean modal) throws DAOException {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
        this.manager = manager;
        tablaActualizar();
        tablaProductos.getSelectionModel().addListSelectionListener(e->{
            if (tablaProductos.getSelectedRow() != -1) {
                editar.setEnabled(true);
                borrar.setEnabled(true);
            }else{
                editar.setEnabled(false);
                borrar.setEnabled(false);
            }
        });
    }
    
    public void tablaActualizar() throws DAOException {
        try {
            estado.setText("Preparando...");
            this.model = new TableModelCategorias(manager.getCategoriaDAO());
            this.model.updateModel();
            this.tablaProductos.setModel(model);
            tablaProductos.getTableHeader().setReorderingAllowed(false);
            estado.setText(model.getRowCount()+" Registrados");
            tamColum();
        } catch (DAOException ex) {
            Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tamColum() {
        tablaProductos.getColumn("id").setPreferredWidth(3);
        tablaProductos.getColumn("id").setResizable(false);
        tablaProductos.getColumn("Nombre").setPreferredWidth(400);
        tablaProductos.getColumn("Nombre").setResizable(false);
        tablaProductos.getColumn("Precio").setPreferredWidth(50);
        tablaProductos.getColumn("Precio").setResizable(false);
    }
    
    Categoria obtenerSeleccionado() throws DAOException{
        Long id = (Long) model.getValueAt(tablaProductos.getSelectedRow(), 0);
        return manager.getCategoriaDAO().obtener(id);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        estado = new javax.swing.JLabel();
        editar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Actualizar = new javax.swing.JButton();
        buscador = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Cat/Prod");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaProductos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 530, 310));

        estado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        estado.setForeground(new java.awt.Color(255, 255, 255));
        estado.setText("Estado");
        getContentPane().add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 250, -1));

        editar.setText("Editar");
        editar.setEnabled(false);
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        getContentPane().add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, 130, 40));

        borrar.setText("Eliminar");
        borrar.setEnabled(false);
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        getContentPane().add(borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 130, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consultar Cat/Prod");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 220, 30));

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 420, 120, 40));

        buscador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscadorKeyTyped(evt);
            }
        });
        getContentPane().add(buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 290, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/consulta.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        try {
            Categoria obtenerSeleccionado = obtenerSeleccionado();
            List<DetalleVenta> obtenerPorCateg = manager.getDetalleVentaDAO().obtenerPorCateg(obtenerSeleccionado.getId());
            if (obtenerPorCateg.size() == 0) {
                System.out.println("No hay ventas registradas con este producto");
                manager.getCategoriaDAO().eliminar(obtenerSeleccionado());
                tablaActualizar();
            }else{
                JOptionPane.showMessageDialog(null, "Existen Ventas con esta Cat/Prod\nLO SENTIMOS NO SE PUEDEN ELIMINAR");
            }
        } catch (DAOException ex) {
            Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_borrarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        try {
            categoria = obtenerSeleccionado();
            Editar ve = new Editar(manager, categoria, null, true);
            ve.setLocationRelativeTo(ve);
            ve.setVisible(true);
        } catch (DAOException ex) {
            Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);    
        }
    }//GEN-LAST:event_editarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        try {
            tablaActualizar();
        } catch (DAOException ex) {
            Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ActualizarActionPerformed

    private void buscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorKeyTyped
        // TODO add your handling code here:
        String caracter = String.valueOf(evt.getKeyChar());
        if (buscador.getText().equals("")) {
            try {
                tablaActualizar();
            } catch (DAOException ex) {
                Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (caracter.matches("[a-zA-z0-9]")) {
            try {
                this.model = new TableModelCategorias(manager.getCategoriaDAO());
                this.model.updateModel(buscador.getText());
                this.tablaProductos.setModel(model);
                tamColum();
            } catch (DAOException ex) {
                Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buscadorKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton borrar;
    private javax.swing.JTextField buscador;
    private javax.swing.JButton editar;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
