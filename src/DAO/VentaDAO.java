
package DAO;

import Clases.Venta;
import java.util.List;

public interface VentaDAO extends DAO<Venta, Long>{
    List<Venta> obtenerPorFecha(String fecha);
}
