
package DAO.MySQL;

import DAO.CategoriaDAO;
import DAO.DAOManager;
import DAO.DetalleVentaDAO;
import DAO.UsuariosDAO;
import DAO.VentaDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAOManager implements DAOManager{
    
    private Connection conn;
    
    private UsuariosDAO usuario = null;
    private CategoriaDAO categoria = null;
    private VentaDAO venta = null;
    private DetalleVentaDAO detalleVenta = null;
    
    public MySQLDAOManager(String host, String username, String password, String database) throws SQLException{
        conn = DriverManager.getConnection("jdbc:mysql://"+host+"/"+database,username,password);
    }
    
    @Override
    public UsuariosDAO getUsuariosDAO() {
        if (usuario == null) {
            usuario = new MySQLUsuariosDAO(conn);
        }
        return usuario;
    }

    @Override
    public VentaDAO getVentaDAO() {
        if (venta == null) {
            venta = new MySQLVentaDAO(conn);
        }
        return venta;
    }

    @Override
    public CategoriaDAO getCategoriaDAO() {
        if (categoria == null) {
            categoria = new MySQLCategoriasDAO(conn);
        }
        return categoria;
    }

    @Override
    public DetalleVentaDAO getDetalleVentaDAO() {
        if (detalleVenta == null) {
            detalleVenta = new MySQLDetalleVentaDAO(conn);
        }
        return detalleVenta;
    }
    
}
