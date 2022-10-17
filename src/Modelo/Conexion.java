package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    Connection con;

    public Connection getConnection() {
        try {
            String myBD = "jdbc:mysql://localhost:3306/restaurante";
            con = DriverManager.getConnection(myBD, "root", "admin");
            System.out.println("CONECTO");
            //JOptionPane.showMessageDialog(null, "Conexión exitosa a la BD Restaurante");
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
