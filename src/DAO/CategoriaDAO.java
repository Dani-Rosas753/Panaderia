
package DAO;

import Clases.Categoria;
import java.util.List;

public interface CategoriaDAO extends DAO<Categoria, Long>{
    List<Categoria> obtenerPorNombreCategoria(String nombre) throws DAOException;
}
