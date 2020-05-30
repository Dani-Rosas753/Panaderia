
package DAO.MySQL;

import Clases.Categoria;
import DAO.CategoriaDAO;
import DAO.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriasDAO implements CategoriaDAO{
    
    //Codigo SQL
    final String INSERT = "INSERT INTO categoria ( nombreCategoria, Precio ) VALUES ( ? , ? );";
    final String UPDATE = "UPDATE categoria SET nombreCategoria = ? , Precio = ? WHERE idCategoria = ? ;";
    final String DELETE = "DELETE FROM categoria WHERE idCategoria = ? ;";
    final String GETALL = "SELECT idCategoria, nombreCategoria, Precio FROM categoria";
    final String GETONE = "SELECT idCategoria, nombreCategoria, Precio FROM categoria WHERE idCategoria = ? ";
    final String GETONENom = "SELECT idCategoria, nombreCategoria, Precio FROM categoria WHERE nombreCategoria LIKE ?";
    final String GETONEn = "SELECT idCategoria, nombreCategoria, Precio FROM categoria WHERE nombreCategoria LIKE ?";
    
    private Connection conn;
    
    public MySQLCategoriasDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insertar(Categoria a) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        try{
            stat = conn.prepareStatement(INSERT,stat.RETURN_GENERATED_KEYS);
            stat.setString(1, a.getNombreCategoria());
            stat.setDouble(2, a.getPrecio());
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
    public void modificar(Categoria a) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, a.getNombreCategoria());
            stat.setDouble(2, a.getPrecio());
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
    public void eliminar(Categoria a) throws DAOException {
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
    
    private Categoria convertir(ResultSet rs) throws SQLException{
        String nombreCategoria = rs.getString("nombreCategoria");
        double precio = rs.getDouble("Precio");
        
        Categoria categorias = new Categoria(nombreCategoria, precio);
        categorias.setId(rs.getLong("idCategoria"));
        return categorias;
    }

    @Override
    public List<Categoria> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Categoria> categorias = new ArrayList<>();
        try{
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()){
                categorias.add(convertir(rs));
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
        return categorias;
    }

    @Override
    public Categoria obtener(Long id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Categoria a = null;
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
    public List<Categoria> obtenerPorNombreCategoria(String nombre) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Categoria> categorias = new ArrayList<>();
        try{
            stat = conn.prepareStatement(GETONENom);
            stat.setString(1,'%'+nombre+'%');
            rs = stat.executeQuery();
            while(rs.next()){
                categorias.add(convertir(rs));
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
        return categorias;
    }

}
