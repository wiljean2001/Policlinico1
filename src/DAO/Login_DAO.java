package DAO;

import DBO.Login_DBO;
import conexion.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login_DAO{
    private static final String ReadAll = "select USUARIO, CONTRASEÑA from [Iniciar Sesion] where usuario =?";
    private Login_DBO DBO_Login;
    private static final conexion con = conexion.SaberEstado();
    public Login_DBO Read(Object key){
        PreparedStatement ps;
        ResultSet res;
        try {
            ps = con.getCnn().prepareStatement(ReadAll);
            ps.setString(1, key.toString());
            res = ps.executeQuery();
            while (res.next()) {
                DBO_Login = new Login_DBO(res.getString(1), res.getString(2));
            }
            return DBO_Login;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL error: "+e);
        }finally{
            con.setCnn();
        }
        return null;
    }
}
