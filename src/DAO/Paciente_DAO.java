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

public class Paciente_DAO {

    private static final String INSERT_SQL = "INSERT INTO Paciente VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE Paciente SET DNI =?, Num_Tarj=?, Cod_seg=?, NombreyApell=?, Dir=?, Sexo=?, Provincia=?, CP=?";
    private static final String READ_SQL = "SELECT * FROM Paciente WHERE DNI=?";
    //private static final String READ_ALL_SQL = "SELECT * FROM RegistroPac";
    private static final conexion con = conexion.SaberEstado();
/*
    String DNI_Paciente, Date FechadeNacimiento, String telefono, String Apellidos, String nombres, String Direccion,
            char Sexo, int edad, String EstadoCivil, Image Foto
    */
    public boolean create(Paciente_DBO x) {
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

    /*
    
    @Override
    public boolean create(dboCamas c) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, c.getCod_camas());
            ps.setString(2, c.getEdificio());
            ps.setString(3, c.getPiso());
            ps.setString(4, c.getCuarto());
            ps.setInt(5, Integer.parseInt(c.getCama()));
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
                return true;  
            }
        } catch (SQLException ex) {
            Logger.getLogger(camaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.CerrarConn();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            if (ps.executeUpdate() > 0) {
                 JOptionPane.showMessageDialog(null, "ELIMINADO EXITOSO");
                return true;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(camaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.CerrarConn();
        }
        return false;
    }

    @Override
    public boolean update(dboCamas c) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, c.getEdificio() + "_" + c.getCuarto() + "_" + c.getCama());
            ps.setString(2, c.getEdificio());
            ps.setString(3, c.getPiso());
            ps.setString(4, c.getCuarto());
            ps.setInt(5, Integer.parseInt(c.getCama()));
            ps.setString(6, c.getCod_camas());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "MODIFICACION EXITOSO");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(camaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.CerrarConn();
        }
        return false;
    }

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
