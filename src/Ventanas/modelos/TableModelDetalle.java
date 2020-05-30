
package Ventanas.modelos;

import Clases.DetalleVenta;
import DAO.DAOException;
import DAO.DetalleVentaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelDetalle extends AbstractTableModel{
    
    private DetalleVentaDAO detalle;
    
    private List<DetalleVenta> datos = new ArrayList<>();

    public TableModelDetalle(DetalleVentaDAO detalle) {
        this.detalle = detalle;
    }
    
    public void updateModel(Long idVenta) throws DAOException{
        datos = detalle.obtenerPorVenta(idVenta);
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Id Producto";
            case 1: return "Nombre Producto";
            case 2: return "Cantidad";
            default: return "[No]";
        }
    }
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DetalleVenta preguntado = datos.get(rowIndex);
        switch (columnIndex){
            case 0: return preguntado.getId().getIdVenta();
            case 1: return preguntado.getNombreCategoria();
            case 2: return preguntado.getCantidad();
            default: return "";
        }
    }
    
}
