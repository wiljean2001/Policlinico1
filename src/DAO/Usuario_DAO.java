package DAO;

import DBO.Usuario;
import conexion.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Usuario_DAO {

    private static final String ReadAll = "select * from Usuario where Usuario =? and Contraseña =?";
    private Usuario DBOUsuario = null;
    private static final conexion con = conexion.SaberEstado();

    public Usuario BuscarUsuario(Object key, Object key2) {
        PreparedStatement ps;
        ResultSet res;
        try {
            ps = con.getCnn().prepareStatement(ReadAll);
            ps.setString(1, key.toString());
            ps.setString(2, key2.toString());
            res = ps.executeQuery();
            while (res.next()) {
                DBOUsuario = new Usuario(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                            res.getString(5), res.getString(6), res.getBoolean(7), res.getString(8), res.getString(9));
            }
            return DBOUsuario;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Recepcionista error: " + e);
        } finally {
            con.setCnn();
        }
        return null;
    }

}
