package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PlatosDao {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public boolean Registrar(Platos pla) {
        String sql = "INSERT INTO platos (nombre, precio, fecha) VALUES (?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pla.getNombre());
            ps.setDouble(2, pla.getPrecio());
            ps.setString(3, pla.getFecha());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public Connection ListarMenu() {
        String sql = "SELECT * FROM platos";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                double precio = rs.getDouble(3);
                String fecha = rs.getString(4);
                System.out.println("Id Orden: " + id);
                System.out.println("Plato: " + nombre);
                System.out.println("Precio: " + precio);
                System.out.println("Fecha: " + fecha);
            }
            JOptionPane.showMessageDialog(null, "Conexión Exitosa Modulo Menu");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return con;
    }
    

    public List Listar(String valor, String fecha) {
        List<Platos> Lista = new ArrayList();
        String sql = "SELECT * FROM platos WHERE fecha = ?";
        String consulta = "SELECT * FROM platos WHERE nombre LIKE '%"+valor+"%' AND fecha = ?";
        try {
            con = cn.getConnection();
            if(valor.equalsIgnoreCase("")){
                ps = con.prepareStatement(sql);
            }else{
                ps = con.prepareStatement(consulta);
            }
            ps.setString(1, fecha);
            rs = ps.executeQuery();
            while (rs.next()) {
                Platos pl = new Platos();
                pl.setId(rs.getInt("id"));
                pl.setNombre(rs.getString("nombre"));
                pl.setPrecio(rs.getDouble("precio"));
                Lista.add(pl);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return Lista;
    }

    public boolean Eliminar(int id) {
        String sql = "DELETE FROM platos WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public boolean Modificar(Platos pla) {
        String sql = "UPDATE platos SET nombre=?, precio=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pla.getNombre());
            ps.setDouble(2, pla.getPrecio());
            ps.setInt(3, pla.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

}
