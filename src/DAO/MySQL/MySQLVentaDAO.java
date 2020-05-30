
package DAO.MySQL;

import Clases.Venta;
import DAO.DAOException;
import DAO.VentaDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLVentaDAO implements VentaDAO{
    
    //Codigo SQL
    final String INSERT = "INSERT INTO venta (usuario, Fecha, hora, total) VALUES ( ? , ? , ? , ? );";
    final String UPDATE = "UPDATE venta SET usuario = ?, Fecha = ?, hora = ?, total = ? WHERE idVenta = ? ;";
    final String DELETE = "DELETE FROM venta WHERE idVenta = ?";
    final String GETALL = "SELECT idVenta, nombreUsuario, Fecha, hora, total FROM venta, usuarios WHERE usuario = idUsuario";
    final String GETONE = "SELECT idVenta, nombreUsuario, Fecha, hora, total FROM venta, usuarios WHERE usuario = idUsuario AND idVenta = ? ";
    final String GETFECHA = "SELECT idVenta, nombreUsuario, Fecha, hora, total FROM venta, usuarios WHERE usuario = idUsuario AND Fecha = ? ";
    
    private Connection conn;
    
    public MySQLVentaDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insertar(Venta a) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(INSERT,stat.RETURN_GENERATED_KEYS);
            stat.setLong(1, a.getIdUsuario());
            stat.setDate(2, a.getFecha());
            stat.setTime(3, a.getHora());
            stat.setDouble(4, a.getTotal());
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya Guardado");
            }
            rs = stat.getGeneratedKeys();
            if(rs.next()){
                a.setId(rs.getLong(1));
            }else{
                throw new DAOException("No se puede asignar este ID a esta Categoria");
            }
        } catch (SQLException ex){
            throw new DAOException("Error en SQL ", ex);
        }
        finally{
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
                    throw new DAOException("Error en SQL ",ex);
                }
            }
        }
    }

    @Override
    public void modificar(Venta a) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(UPDATE);
            stat.setLong(1, a.getIdUsuario());
            stat.setDate(2, (Date) a.getFecha());
            stat.setTime(3, a.getHora());
            stat.setDouble(4, a.getTotal());
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
    public void eliminar(Venta a) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, a.getId());
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya eliminado");
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
    
    private Venta convertir(ResultSet rs) throws SQLException{
        Date fecha = rs.getDate("Fecha");
        Time hora = rs.getTime("hora");
        double total = rs.getDouble("total");
        
        Venta venta = new Venta(fecha, hora, total);
        
        venta.setId(rs.getLong("idVenta"));
        venta.setUsuario(rs.getString("nombreUsuario"));
        
        return venta;
    }
    
    @Override
    public List<Venta> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Venta> ventas = new ArrayList<>();
        try{
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()){
                ventas.add(convertir(rs));
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
        return ventas;
    }

    @Override
    public Venta obtener(Long id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Venta a = null;
        try{
            stat = conn.prepareStatement(GETONE);
            stat.setLong(1, id);
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
    public List<Venta> obtenerPorFecha(String fecha) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Venta> ventas = new ArrayList<>();
        try{
            stat = conn.prepareStatement(GETFECHA);
            stat.setString(1, fecha);
            rs = stat.executeQuery();
            while(rs.next()){
                ventas.add(convertir(rs));
            }
        } catch(SQLException ex){
            try {
                throw new DAOException("Error en SQL ", ex);
            } catch (DAOException ex1) {
                Logger.getLogger(MySQLVentaDAO.class.getName()).log(Level.SEVERE, null, ex1);
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
        return ventas;
    }

    
}
