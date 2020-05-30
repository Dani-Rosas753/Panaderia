
package Ventanas.modelos;


import Clases.Venta;
import DAO.DAOException;
import DAO.VentaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelVentas extends AbstractTableModel{
    
    private VentaDAO venta;
    
    private List<Venta> datos = new ArrayList<>();

    public TableModelVentas(VentaDAO venta) {
        this.venta = venta;
    }
    
    public void updateModel() throws DAOException{
        datos = venta.obtenerTodos();
    }
    
    public void updateModel(String fecha) throws DAOException {
        datos = venta.obtenerPorFecha(fecha);
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "id";
            case 1: return "Fecha";
            case 2: return "Hora";
            case 3: return "Usuario";
            case 4: return "Total";
            default: return "[No]";
        }
    }
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Venta preguntado = datos.get(rowIndex);
        switch (columnIndex){
            case 0: return preguntado.getId();
            case 1: return preguntado.getFecha();
            case 2: return preguntado.getHora();
            case 3: return preguntado.getUsuario();
            case 4: return preguntado.getTotal();
            default: return "";
        }
    }   
}
