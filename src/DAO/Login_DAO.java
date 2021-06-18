package DAO;

import DBO.Medicos;
import DBO.Recepcionista;
import conexion.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login_DAO {

    private static final String ReadAll = "select * from Usuario where Usuario =?";
    private Recepcionista DBO_Recepcionista;
    private Medicos DBO_Medicos;
    private static final conexion con = conexion.SaberEstado();
    private boolean colaborador = false;
    public Recepcionista ReadRecepcionista(Object key) {
        PreparedStatement ps;
        ResultSet res;
        try {
            ps = con.getCnn().prepareStatement(ReadAll);
            ps.setString(1, key.toString());
            res = ps.executeQuery();
            
            while (res.next()) {
                //res.getInt(1) == 1
                colaborador = res.getBoolean(1);
                if (colaborador=false) {
                    
                    DBO_Recepcionista = new Recepcionista(colaborador, res.getString(2), res.getString(3));
                } else {
                    DBO_Recepcionista=null;
                    JOptionPane.showMessageDialog(null, "No encontrado");
                }
            }

            return DBO_Recepcionista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Recepcionista error: " + e);
        } finally {
            con.setCnn();
        }
        return null;
    }

    public Medicos ReadMedicos(Object key) {
        PreparedStatement ps;
        ResultSet res;
        try {
            ps = con.getCnn().prepareStatement(ReadAll);
            ps.setString(1, key.toString());
            res = ps.executeQuery();
            while (res.next()) {
                colaborador = res.getBoolean(1);
                if (colaborador=true) {
                    DBO_Medicos = new Medicos(res.getBoolean(1), res.getString(2), res.getString(3));
                }else{
                    DBO_Medicos=null;
                    JOptionPane.showMessageDialog(null, "No encontrado");
                }
            }
            return DBO_Medicos;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Medicos error: " + e);
        } finally {
            con.setCnn();
        }
        return null;
    }

}
