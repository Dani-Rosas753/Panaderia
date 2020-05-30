
package Ventanas;

import DAO.DAOException;
import DAO.MySQL.MySQLDAOManager;
import Ventanas.Login.Login;
import java.sql.SQLException;

public class Main {
    
    public static void main(String[] args) throws SQLException, DAOException {
        MySQLDAOManager manager = new MySQLDAOManager("localhost", "root", "", "panaderiasanjudas");
        Login n = new Login(manager);
        n.setLocationRelativeTo(n);
        n.setVisible(true);
    }
}
