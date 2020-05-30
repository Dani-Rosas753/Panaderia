
package DAO.MySQL;

import Clases.Usuarios;
import DAO.DAOException;
import DAO.UsuariosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLUsuariosDAO implements UsuariosDAO{
    
    //Codigo SQL
    final String INSERT = "INSERT INTO usuarios (nombreUsuario, passwordUsuario) VALUES (?, ?);";
    final String UPDATE = "UPDATE usuarios SET nombreUsuario = ? , passwordUsuario = ? WHERE idUsuario = ? ;";
    final String DELETE = "DELETE FROM usuarios WHERE idUsuario = ? ;";
    final String GETALL = "SELECT idUsuario, nombreUsuario, passwordUsuario FROM usuarios";
    final String GETONE = "SELECT idUsuario, nombreUsuario, passwordUsuario FROM panaderiasanjudas.usuarios WHERE idUsuario = ? ";
    
    private Connection conn;
    
    public MySQLUsuariosDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insertar(Usuarios a) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(INSERT,stat.RETURN_GENERATED_KEYS);
            stat.setString(1, a.getUser());
            stat.setString(2, a.getPassword());
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
    public void modificar(Usuarios a) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, a.getUser());
            stat.setString(2, a.getPassword());
            stat.setLong(3, a.getId());
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
    public void eliminar(Usuarios a) throws DAOException {
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
    
    private Usuarios convertir(ResultSet rs) throws SQLException{
        String user = rs.getString("nombreUsuario");
        String password = rs.getString("passwordUsuario");
        
        Usuarios usuarios = new Usuarios(user, password);
        usuarios.setId(rs.getLong("idUsuario"));
        
        return usuarios;
    }
    
    @Override
    public List<Usuarios> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Usuarios> usuarios = new ArrayList<>();
        try{
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()){
                usuarios.add(convertir(rs));
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
        return usuarios;
    }

    @Override
    public Usuarios obtener(Long id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Usuarios a = null;
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
    public Usuarios obtenerUsuario(Usuarios u) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Usuarios a = null;
        try{
            stat = conn.prepareStatement(GETONE);
            stat.setLong(1, u.getId());
            rs = stat.executeQuery();
            if(rs.next()){
                a = convertir(rs);
            }else{
                throw new DAOException("No s ha encontrado ese registro");
            }
        } catch(SQLException ex){
            try {
                throw new DAOException("Error en SQL ", ex);
            } catch (DAOException ex1) {
                Logger.getLogger(MySQLUsuariosDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (DAOException ex) {
            Logger.getLogger(MySQLUsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public List<Usuarios> obtenerU(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
