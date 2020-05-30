
package DAO;

import Clases.DetalleVenta;
import java.util.List;

public interface DetalleVentaDAO extends DAO<DetalleVenta, DetalleVenta.idDetalleVenta>{
    public List<DetalleVenta> obtenerPorVenta(Long idVenta);
    public List<DetalleVenta> obtenerPorCateg(Long idCat);
}
