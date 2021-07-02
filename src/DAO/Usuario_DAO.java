package DAO;

import DBO.Usuario_DBO;
import Interfaces.Mensaje;
import conexion.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario_DAO {

    private static final String ReadAll = "select * from Usuario where Usuario =? and Contraseña =?";
    private Usuario_DBO DBOUsuario = null;
    private static final conexion con = conexion.SaberEstado();

    public Usuario_DBO BuscarUsuario(Object key, Object key2) {
        PreparedStatement ps;
        ResultSet res;
        try {
            ps = con.getCnn().prepareStatement(ReadAll);
            ps.setString(1, key.toString());
            ps.setString(2, key2.toString());
            res = ps.executeQuery();
            while (res.next()) {
                DBOUsuario = new Usuario_DBO(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                            res.getString(5), res.getString(6), res.getBoolean(7), res.getString(8), res.getString(9));
            }
            return DBOUsuario;
        } catch (SQLException e) {
                Mensaje.MensajeError("USUARIO NO EXISTENTE", "ERROR");
        } finally {
            con.setCnn();
        }
        return null;
    }

}
