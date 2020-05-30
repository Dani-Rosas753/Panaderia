
package DAO;

import Clases.Usuarios;
import java.util.List;

public interface UsuariosDAO extends DAO<Usuarios,Long>{
    public Usuarios obtenerUsuario(Usuarios a);
    List<Usuarios> obtenerU (Long id);
}
