package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conex {

    String bd = "";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "admin";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;

    public Conex() {
    }

    public Connection getConnection() {

        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url + bd, user, password);
            System.out.println("SE CONECTO");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(bd + ", NO SE CONECTO");
            Logger.getLogger(Conex.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }

}
