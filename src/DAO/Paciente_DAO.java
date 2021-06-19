package DAO;

import DBO.Paciente_DBO;
import Interfaces.Obligaciones;
import Vistas.RegistrarP;
import conexion.conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.sql.ResultSet;

public class Paciente_DAO {

    private static final String INSERT_SQL = "INSERT INTO Paciente VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE Paciente SET DNI =?, Fecha_Nacimiento=?, Telefono=?,"
                                    + "Apellido=?, Nombre=?, Dirección=?, Sexo=?, Edad=?, EstadoCivil=?, Foto=? WHERE DNI =? ";
    private static final String BUSCAR_SQL = "SELECT * FROM Paciente WHERE DNI=?";
    //private static final String READ_ALL_SQL = "SELECT * FROM RegistroPac";
    private static final conexion con = conexion.SaberEstado();
/*
    String DNI_Paciente, Date FechadeNacimiento, String telefono, String Apellidos, String nombres, String Direccion,
            char Sexo, int edad, String EstadoCivil, Image Foto
    */
    public boolean RegistrarPac(Paciente_DBO x) {
        //preparar consulta
        PreparedStatement PS;
        try {
            PS = con.getCnn().prepareStatement(INSERT_SQL);
            PS.setString(1, x.getDNI_Paciente());
            java.sql.Date date = new java.sql.Date(x.getFechadeNacimiento().getTime());
            PS.setDate(2, date);
            PS.setString(3, x.getTelefono());
            PS.setString(4, x.getApellidos());
            PS.setString(5, x.getNombres());
            PS.setString(6, x.getDireccion());
            PS.setString(7, String.valueOf(x.getSexo()));
            PS.setInt(8, x.getEdad());
            PS.setString(9, x.getEstadoCivil());
            PS.setBytes(10, x.getFoto());
            if (PS.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL ERROR: " + e);
        } finally {
            //Cerrar conexion
            con.setCnn();
        }
        return false;
    }
    
    public boolean ActualizarPac(Paciente_DBO x) {
        PreparedStatement PS;
        try {
            PS = con.getCnn().prepareStatement(UPDATE_SQL);
            PS.setString(1, x.getDNI_Paciente());
            java.sql.Date date = new java.sql.Date(x.getFechadeNacimiento().getTime());
            PS.setDate(2, date);
            PS.setString(3, x.getTelefono());
            PS.setString(4, x.getApellidos());
            PS.setString(5, x.getNombres());
            PS.setString(6, x.getDireccion());
            PS.setString(7, String.valueOf(x.getSexo()));
            PS.setInt(8, x.getEdad());
            PS.setString(9, x.getEstadoCivil());
            PS.setBytes(10, x.getFoto());
            PS.setString(11, x.getDNI_Paciente());
            if (PS.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "MODIFICACION EXITOSO");
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL ERROR: " + ex);
        } finally {
            //Cerrar conexion
            con.setCnn();
        }
        return false;
    }
    
    public Paciente_DBO BuscarPac(String key) {
        PreparedStatement ps;
        ResultSet res;
        Paciente_DBO l = null;
        try {
            ps = con.getCnn().prepareStatement(BUSCAR_SQL);
            ps.setString(1, key);
            res = ps.executeQuery();
            while(res.next()){
                java.sql.Date date = new java.sql.Date(res.getDate(2).getTime());
                l= new Paciente_DBO(res.getString(1), date, res.getString(3), res.getString(4), res.getString(5)
                        , res.getString(6), res.getString(7).charAt(0), res.getInt(8), res.getString(9), res.getBytes(10));
                JOptionPane.showMessageDialog(null, "PACIENTE BUSCADO");
            }
            return l;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        } finally{
            con.setCnn();
        }
        return null;
    }

    /*
 
    @Override
    public dboCamas read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        dboCamas l = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();
            while(res.next()){
                l= new dboCamas(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(camaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.CerrarConn();
        }
        return null;
    }

    @Override
    public List<dboCamas> readAll() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<dboCamas> Acama = new ArrayList();
        try {
            ps = con.getCnn().prepareStatement(SQL_READ_ALL);
                res = ps.executeQuery();
            while(res.next()){
                Acama.add(new dboCamas(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)));
            }
            return Acama;
            
        } catch (SQLException ex) {
            Logger.getLogger(camaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.CerrarConn();
        }
        return null;
    }

}

     */
}
