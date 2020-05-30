
package DAO;

public interface DAOManager {
    UsuariosDAO getUsuariosDAO();
    VentaDAO getVentaDAO();
    CategoriaDAO getCategoriaDAO();
    DetalleVentaDAO getDetalleVentaDAO();
}
