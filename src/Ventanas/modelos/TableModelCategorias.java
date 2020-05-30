
package Ventanas.modelos;

import Clases.Categoria;
import DAO.CategoriaDAO;
import DAO.DAOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelCategorias extends AbstractTableModel{
    
    private CategoriaDAO categoria;
    
    private List<Categoria> datos = new ArrayList<>();

    public TableModelCategorias(CategoriaDAO categoria) {
        this.categoria = categoria;
    }
    
    public void updateModel() throws DAOException{
        datos = categoria.obtenerTodos();
    }
    
    public void updateModel(String nombre) throws DAOException {
        datos = categoria.obtenerPorNombreCategoria(nombre);
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "id";
            case 1: return "Nombre";
            case 2: return "Precio";
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
        Categoria preguntado = datos.get(rowIndex);
        switch (columnIndex){
            case 0: return preguntado.getId();
            case 1: return preguntado.getNombreCategoria();
            case 2: return preguntado.getPrecio();
            default: return "";
        }
    }   
}
