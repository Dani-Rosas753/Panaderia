
package DAO.MySQL;

import Clases.DetalleVenta;
import DAO.DAOException;
import DAO.DetalleVentaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLDetalleVentaDAO implements DetalleVentaDAO{
    //Codigo SQL
    final String INSERT = "INSERT INTO detalleventa (fk_idVenta, fk_idCategoria, cantidad) VALUES ( ? , ? , ? );";
    final String UPDATE = "UPDATE detalleventa SET cantidad = ? WHERE fk_idVenta = ? AND fk_idCategoria = ? ;";
    final String DELETE = "DELETE FROM detalleventa WHERE fk_idVenta = ? ;";
    final String GETALL = "SELECT fk_idVenta, nombreCategoria, cantidad FROM detalleventa, categoria WHERE fk_idCategoria = idCategoria";
    final String GETONE = "SELECT fk_idVenta, nombreCategoria, cantidad FROM detalleventa, categoria WHERE fk_idCategoria = idCategoria AND fk_idVenta = ? AND fk_idCategoria = ?";
    final String GETventa = "SELECT fk_idVenta, nombreCategoria, cantidad FROM detalleventa, categoria WHERE fk_idCategoria = idCategoria AND fk_idVenta = ?";
    final String GETC = "SELECT fk_idVenta, nombreCategoria, cantidad FROM detalleventa, categoria WHERE idCategoria = fk_idCategoria AND fk_idCategoria = ?";
    
    private Connection conn;
    
    public MySQLDetalleVentaDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insertar(DetalleVenta a) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(INSERT,stat.RETURN_GENERATED_KEYS);
            stat.setLong(1, a.getId().getIdVenta());
            stat.setLong(2, a.getId().getIdCategoria());
            stat.setInt(3, a.getCantidad());
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya Guardado");
            }
        } catch (SQLException ex){
            throw new DAOException("Error en SQL ", ex);
        }
        finally{
            if(stat != null){
                try{
                    stat.close();
                } catch(SQLException ex){
                    throw new DAOException("Error en SQL ",ex);
                }
            }
        }
    }

    @Override
    public void modificar(DetalleVenta a) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(UPDATE);
            stat.setInt(1, a.getCantidad());
            stat.setLong(2, a.getId().getIdVenta());
            stat.setLong(3, a.getId().getIdCategoria());
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya modificado");
            }
        }catch (SQLException ex){
            throw new DAOException("Error en SQL ", ex);
        }
        finally{
            if(stat != null){
                try{
                    stat.close();
                } catch(SQLException ex){
                    throw new DAOException("Error en SQL ",ex);
                }
            }
        }
    }

    @Override
    public void eliminar(DetalleVenta a) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, a.getId().getIdVenta());
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya modificado");
            }
        }catch (SQLException ex){
            throw new DAOException("Error en SQL ", ex);
        }
        finally{
            if(stat != null){
                try{
                    stat.close();
                } catch(SQLException ex){
                    throw new DAOException("Error en SQL ",ex);
                }
            }
        }
    }
    
    DetalleVenta convertir(ResultSet rs) throws SQLException{
        //
        DetalleVenta detalle = new DetalleVenta();
        detalle.getId().setIdVenta(rs.getLong("fk_idVenta"));
        detalle.setNombreCategoria(rs.getString("nombreCategoria"));
        detalle.setCantidad(rs.getInt("cantidad"));
        return detalle;
    }

    @Override
    public List<DetalleVenta> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<DetalleVenta> detalleventa = new ArrayList<>();
        try{
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()){
                detalleventa.add(convertir(rs));
            }
        } catch(SQLException ex){
            throw new DAOException("Error en SQL ", ex);
        }finally{
            if(rs != null){
                try{
                    rs.close();
                } catch (SQLException ex){
                    new DAOException("Error en SQL ",ex);
                }
            }
            if(stat != null){
                try{
                    stat.close();
                } catch(SQLException ex){
                    new DAOException("Error en SQL ", ex);
                }
            }
        }
        return detalleventa;
    }

    @Override
    public DetalleVenta obtener(DetalleVenta.idDetalleVenta id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        DetalleVenta a = null;
        try{
            stat = conn.prepareStatement(GETONE);
            stat.setLong(1, id.getIdVenta());
            stat.setLong(2, id.getIdCategoria());
            rs = stat.executeQuery();
            if(rs.next()){
                a = convertir(rs);
            }else{
                throw new DAOException("No s ha encontrado ese registro");
            }
        } catch(SQLException ex){
            throw new DAOException("Error en SQL ", ex);
        }finally{
            if(rs != null){
                try{
                    rs.close();
                } catch (SQLException ex){
                    new DAOException("Error en SQL ",ex);
                }
            }
            if(stat != null){
                try{
                    stat.close();
                } catch(SQLException ex){
                    new DAOException("Error en SQL ", ex);
                }
            }
        }
        return a;
    }

    @Override
    public List<DetalleVenta> obtenerPorVenta(Long idVenta) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<DetalleVenta> lista = new ArrayList<>();
        try{
            stat = conn.prepareStatement(GETventa);
            stat.setLong(1, idVenta);
            rs = stat.executeQuery();
            while(rs.next()){
                lista.add(convertir(rs));
            }
        } catch(SQLException ex){
            try {
                throw new DAOException("Error en SQL ", ex);
            } catch (DAOException ex1) {
                Logger.getLogger(MySQLDetalleVentaDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }finally{
            if(rs != null){
                try{
                    rs.close();
                } catch (SQLException ex){
                    new DAOException("Error en SQL ",ex);
                }
            }
            if(stat != null){
                try{
                    stat.close();
                } catch(SQLException ex){
                    new DAOException("Error en SQL ", ex);
                }
            }
        }
        return lista;
    }

    @Override
    public List<DetalleVenta> obtenerPorCateg(Long idCat) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<DetalleVenta> lista = new ArrayList<>();
        try{
            stat = conn.prepareStatement(GETC);
            stat.setLong(1, idCat);
            rs = stat.executeQuery();
            while(rs.next()){
                lista.add(convertir(rs));
            }
        } catch(SQLException ex){
            try {
                throw new DAOException("Error en SQL ", ex);
            } catch (DAOException ex1) {
                Logger.getLogger(MySQLDetalleVentaDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }finally{
            if(rs != null){
                try{
                    rs.close();
                } catch (SQLException ex){
                    new DAOException("Error en SQL ",ex);
                }
            }
            if(stat != null){
                try{
                    stat.close();
                } catch(SQLException ex){
                    new DAOException("Error en SQL ", ex);
                }
            }
        }
        return lista;
    }
    
    
}
