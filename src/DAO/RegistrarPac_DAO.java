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

public class RegistrarPac_DAO implements Obligaciones<Paciente_DBO> {

    private static final String INSERT_SQL = "INSERT INTO RegistroPac VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE_SQL = "DELETE FROM RegistroPac WHERE DNI =? ";
    private static final String UPDATE_SQL = "UPDATE RegistroPac SET DNI =?, Num_Tarj=?, Cod_seg=?, NombreyApell=?, Dir=?, Sexo=?, Provincia=?, CP=?";
    private static final String READ_SQL = "SELECT * FROM RegistroPac WHERE DNI=?";
    private static final String READ_ALL_SQL = "SELECT * FROM RegistroPac";
    private static final conexion con = conexion.SaberEstado();

    @Override
    public boolean create(Paciente_DBO x) {
        //preparar consulta
        /*
        PreparedStatement PS;
        try {
            PS = con.getCnn().prepareStatement(INSERT_SQL);
            PS.setInt(1, x.getDNI());
            PS.setInt(2, x.getNum_Tarj());
            PS.setInt(3, x.getCod_Seg());
            PS.setString(4, x.getNom_Apll());
            PS.setString(5, x.getDir());
            PS.setString(6, x.getSexo());
            PS.setString(7, x.getProv());
            PS.setString(8, x.getCP());
            if(PS.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL ERROR: "+e);
        } finally {
            //Cerrar conexion
            con.setCnn();
        }
        */
        return false;
    }

    @Override
    public boolean delete(Object key) {
       return false;
    }

    @Override
    public boolean update(Paciente_DBO x) {
        return false;
    }

    @Override
    public Paciente_DBO read(Object key) {
        return null;
    }

    @Override
    public List<Paciente_DBO> readAll() {
        return null;
    }

}
