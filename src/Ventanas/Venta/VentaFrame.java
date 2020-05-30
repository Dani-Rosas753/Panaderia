
package Ventanas.Venta;

import Clases.Categoria;
import Clases.DetalleVenta;
import Clases.Usuarios;
import Clases.Venta;
import DAO.DAOException;
import DAO.DAOManager;
import Ventanas.Alta.Alta;
import Ventanas.modelos.TableModelCategorias;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentaFrame extends javax.swing.JFrame {
    
    private Categoria categoria;
    private DetalleVenta detalleVenta;
    private Usuarios user;
    private DAOManager manager;
    private TableModelCategorias model;
    private Venta newVenta;
    
    public VentaFrame(Usuarios user, DAOManager manager) throws DAOException {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
        this.user = user;
        this.manager = manager;
        nombreUsuario.setText(user.getUser());
        tablaActualizar();
        tablaTiket();
    }
    
    private DefaultTableModel tiket = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return column==1 && column==2 && column==3 && column==4 && column==5;
        }
    };
    
    public void tablaActualizar() throws DAOException {
        try {
            this.model = new TableModelCategorias(manager.getCategoriaDAO());
            this.model.updateModel();
            this.tablaP.setModel(model);
            tablaP.getTableHeader().setReorderingAllowed(false);
            tamColum();
        } catch (DAOException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tamColum() {
        tablaP.getColumn("id").setPreferredWidth(3);
        tablaP.getColumn("id").setResizable(false);
        tablaP.getColumn("Nombre").setPreferredWidth(200);
        tablaP.getColumn("Nombre").setResizable(false);
        tablaP.getColumn("Precio").setPreferredWidth(50);
        tablaP.getColumn("Precio").setResizable(false);
    }
    
    private void tablaTiket() {
        String[] columnas = new String[]{"id","Nombre Producto","Cantidad","PrecioU","PrecioT"};
        tiket.setColumnIdentifiers(columnas);
        tablaDetalle.setModel(tiket);
        
        tablaDetalle.getColumn("id").setPreferredWidth(5);
        tablaDetalle.getColumn("id").setResizable(false);
        tablaDetalle.getColumn("Nombre Producto").setPreferredWidth(100);
        tablaDetalle.getColumn("Nombre Producto").setResizable(false);
        tablaDetalle.getColumn("Cantidad").setPreferredWidth(5);
        tablaDetalle.getColumn("Cantidad").setResizable(false);
        tablaDetalle.getColumn("PrecioU").setPreferredWidth(5);
        tablaDetalle.getColumn("PrecioU").setResizable(false);
        tablaDetalle.getColumn("PrecioT").setPreferredWidth(5);
        tablaDetalle.getColumn("PrecioT").setResizable(false);
    }
    
    private Categoria obtenerSeleccionado() throws DAOException{
        Long id = (Long) model.getValueAt(tablaP.getSelectedRow(), 0);
        return manager.getCategoriaDAO().obtener(id);
    }

    private void calcularTotal() {
        // calcular total
        double canTot = 0.0;
        for (int i = 0; i < tablaDetalle.getRowCount(); i++) {
            canTot = canTot + Double.parseDouble(tiket.getValueAt(i, 4).toString());
        }
        cantidadTotal.setText(""+canTot);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaP = new javax.swing.JTable();
        buscador = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDetalle = new javax.swing.JTable();
        btnCancelarVenta = new javax.swing.JButton();
        btnGenerarVenta = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cantidadTotal = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventas");
        setMaximumSize(new java.awt.Dimension(1040, 630));
        setMinimumSize(new java.awt.Dimension(1040, 630));
        setPreferredSize(new java.awt.Dimension(1040, 630));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bread-1508910-1275182.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 230, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bread-1508910-1275182.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 230, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Agregar");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 160, 40));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Agregar");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 160, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pan de Reposteria");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pan de Dulce");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SAN JUDAS TADEO - PANADERÍA Y PASTELERÍA GUERRERO SUR #331, ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 450, 40));

        tablaP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tablaP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaPKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaP);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 330, 190));

        buscador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscadorKeyTyped(evt);
            }
        });
        getContentPane().add(buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 330, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Buscar Otro Producto");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("COL. CENTRO AJALPAN PUEBLA");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, -1, -1));

        tablaDetalle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaDetalle);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, -1, 170));

        btnCancelarVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelarVenta.setText("Cancelar Venta");
        btnCancelarVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 340, 160, 40));

        btnGenerarVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGenerarVenta.setText("Generar Venta");
        btnGenerarVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 160, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Venta");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 90, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total:");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 120, 50, -1));

        cantidadTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cantidadTotal.setForeground(new java.awt.Color(255, 255, 255));
        cantidadTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cantidadTotal.setText("0.0");
        getContentPane().add(cantidadTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 120, 70, -1));

        nombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        nombreUsuario.setText("jLabel9");
        getContentPane().add(nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/venta.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (categoria == null) {
                categoria = new Categoria();
            }
            List<Categoria> obtenerPorNombreCategoria = manager.getCategoriaDAO().obtenerPorNombreCategoria("Pan de Dulce");
            if (obtenerPorNombreCategoria.size() != 0) {
                Long n = obtenerPorNombreCategoria.get(0).getId();
                categoria = manager.getCategoriaDAO().obtener(n);
                InputNumeros input = new InputNumeros(this, true);
                input.setLocationRelativeTo(this);
                input.setVisible(true);
                Integer cantidad = input.getCantidadProductos();
                //"id","Nombre Producto","Cantidad","PrecioU","PrecioT"
                for (int i = 0; i < tablaDetalle.getRowCount(); i++) {
                    if (categoria.getId() == tablaDetalle.getValueAt(i, 0)) {
                        Integer editarCampoCantidad = Integer.parseInt(tablaDetalle.getValueAt(i, 2).toString());
                        editarCampoCantidad = editarCampoCantidad + cantidad;
                        tablaDetalle.setValueAt(editarCampoCantidad, i, 2);
                        double editarcampoPrecioT = + editarCampoCantidad * Double.parseDouble(tablaDetalle.getValueAt(i, 3).toString());
                        tablaDetalle.setValueAt(editarcampoPrecioT, i, 4);

                        input.setBandera(false);
                    }
                }
                if (input.isBandera() != false) {
                    double precioT = categoria.getPrecio() * cantidad;
                    tiket.addRow(new Object[]{categoria.getId(), categoria.getNombreCategoria(), cantidad, categoria.getPrecio(), precioT });
                }
                calcularTotal();
            }else{
                JOptionPane.showMessageDialog(null,"No se encuentra Registrado en el Sistema");
                JOptionPane.showMessageDialog(null,"Registre la Categoria 'Pan de Dulce'\nNo se encuentra Registrado en el Sistema");
                Alta nva = new Alta("Pan de Dulce",manager, this, true);
                nva.setLocationRelativeTo(this);
                nva.setVisible(true);
            }
        } catch (DAOException ex) {
            Logger.getLogger(VentaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (categoria == null) {
                categoria = new Categoria();
            }
            List<Categoria> obtenerPorNombreCategoria = manager.getCategoriaDAO().obtenerPorNombreCategoria("Pan de Reposteria");
            if (obtenerPorNombreCategoria.size() != 0) {
                Long n = obtenerPorNombreCategoria.get(0).getId();
                categoria = manager.getCategoriaDAO().obtener(n);
                InputNumeros input = new InputNumeros(this, true);
                input.setLocationRelativeTo(this);
                input.setVisible(true);
                Integer cantidad = input.getCantidadProductos();
                //"id","Nombre Producto","Cantidad","PrecioU","PrecioT"
                for (int i = 0; i < tablaDetalle.getRowCount(); i++) {
                    if (categoria.getId() == tablaDetalle.getValueAt(i, 0)) {
                        Integer editarCampoCantidad = Integer.parseInt(tablaDetalle.getValueAt(i, 2).toString());
                        editarCampoCantidad = editarCampoCantidad + cantidad;
                        tablaDetalle.setValueAt(editarCampoCantidad, i, 2);
                        double editarcampoPrecioT = + editarCampoCantidad * Double.parseDouble(tablaDetalle.getValueAt(i, 3).toString());
                        tablaDetalle.setValueAt(editarcampoPrecioT, i, 4);

                        input.setBandera(false);
                    }
                }
                if (input.isBandera() != false) {
                    double precioT = categoria.getPrecio() * cantidad;
                    tiket.addRow(new Object[]{categoria.getId(), categoria.getNombreCategoria(), cantidad, categoria.getPrecio(), precioT });
                }
                calcularTotal();
            }else{
                JOptionPane.showMessageDialog(null,"No se encuentra Registrado en el Sistema");
                JOptionPane.showMessageDialog(null,"Registre la Categoria 'Pan de Reposteria'\nNo se encuentra Registrado en el Sistema");
                Alta nva = new Alta("Pan de Reposteria",manager, this, true);
                nva.setLocationRelativeTo(this);
                nva.setVisible(true);
            }
        } catch (DAOException ex) {
            Logger.getLogger(VentaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorKeyTyped
        // TODO add your handling code here
        String caracter = String.valueOf(evt.getKeyChar());
        if (buscador.getText().equals("")) {
            try {
                tablaActualizar();
            } catch (DAOException ex) {
                Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (caracter.matches("[a-zA-z0-9]")) {
            try {
                this.model = new TableModelCategorias(manager.getCategoriaDAO());
                this.model.updateModel(buscador.getText());
                this.tablaP.setModel(model);
                tamColum();
            } catch (DAOException ex) {
                Logger.getLogger(VentaFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buscadorKeyTyped

    private void tablaPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaPKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            if (categoria == null) {
                categoria = new Categoria();
            }
            try {
                categoria = obtenerSeleccionado();
            } catch (DAOException ex) {
                Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
            }
            InputNumeros input = new InputNumeros(this, true);
            input.setLocationRelativeTo(this);
            input.setVisible(true);
            Integer cantidad = input.getCantidadProductos();
            //"id","Nombre Producto","Cantidad","PrecioU","PrecioT"
            for (int i = 0; i < tablaDetalle.getRowCount(); i++) {
                if (categoria.getId() == tablaDetalle.getValueAt(i, 0)) {
                    Integer editarCampoCantidad = Integer.parseInt(tablaDetalle.getValueAt(i, 2).toString());
                    editarCampoCantidad = editarCampoCantidad + cantidad;
                    tablaDetalle.setValueAt(editarCampoCantidad, i, 2);
                    double editarcampoPrecioT = + editarCampoCantidad * Double.parseDouble(tablaDetalle.getValueAt(i, 3).toString());
                    tablaDetalle.setValueAt(editarcampoPrecioT, i, 4);
                    
                    input.setBandera(false);
                }
            }
            if (input.isBandera() != false) {
                double precioT = categoria.getPrecio() * cantidad;
                tiket.addRow(new Object[]{categoria.getId(), categoria.getNombreCategoria(), cantidad, categoria.getPrecio(), precioT });
            }
            
            calcularTotal();
        }
    }//GEN-LAST:event_tablaPKeyPressed
    
    private void saveDataVenta() throws DAOException {
        if (newVenta == null) {
            newVenta = new Venta();
        }
        //Fecha
        newVenta.setFecha(Date.valueOf(LocalDate.now()));
        
        //Hora
        newVenta.setHora(Time.valueOf(LocalTime.now()));
        
        //Total
        newVenta.setTotal(Double.parseDouble(cantidadTotal.getText()));
        
        newVenta.setIdUsuario(user.getId());
        
        manager.getVentaDAO().insertar(newVenta);
    }
    
    private void saveDataDetalleVenta() throws DAOException {
        if (detalleVenta == null) {
            detalleVenta = new DetalleVenta();
        }
        for (int i = 0; i < tablaDetalle.getRowCount(); i++) {
            detalleVenta.getId().setIdVenta(newVenta.getId());
            detalleVenta.getId().setIdCategoria((Long)tablaDetalle.getValueAt(i, 0));
            detalleVenta.setCantidad((int)tablaDetalle.getValueAt(i, 2));
            manager.getDetalleVentaDAO().insertar(detalleVenta);
        }
        
    }
    
    private void eliminarFilasTabla() {
        for (int i = tablaDetalle.getRowCount()-1; i >= 0; i--) {
            tiket.removeRow(i);
        }
        calcularTotal();
    }
    
    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
        if (tablaDetalle.getRowCount() != 0) {
            try {
                saveDataVenta();
                saveDataDetalleVenta();
                eliminarFilasTabla();
                JOptionPane.showMessageDialog(null, "Venta Exitosa");
            } catch (DAOException ex) {
                Logger.getLogger(VentaFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay productos en la tabla Venta");
        }
    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    private void btnCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVentaActionPerformed
        eliminarFilasTabla();
    }//GEN-LAST:event_btnCancelarVentaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarVenta;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JTextField buscador;
    private javax.swing.JLabel cantidadTotal;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nombreUsuario;
    private javax.swing.JTable tablaDetalle;
    private javax.swing.JTable tablaP;
    // End of variables declaration//GEN-END:variables
}
