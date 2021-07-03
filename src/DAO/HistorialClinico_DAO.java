package DAO;

import DBO.Paciente_DBO;
import DBO.HistoriaClinica_DBO;
import conexion.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class HistorialClinico_DAO {

    private static final String INSERT_SQL = "INSERT INTO HistorialClinico VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE HistorialClinico SET DNI =?, Fecha_Nacimiento=?, Telefono=?,"
            + "Apellido=?, Nombre=?, Dirección=?, Sexo=?, Edad=?, EstadoCivil=?, Foto=? WHERE DNI =? ";
    private static final String BUSCAR_SQL = "SELECT * FROM HistorialClinico HC join Paciente P On P.DNI = HC.DNI"
                                            + "WHERE P.DNI=? or HC.CodigoHC =?";
    //private static final String READ_ALL_SQL = "SELECT * FROM RegistroPac";
    private static final conexion con = conexion.SaberEstado();

    public boolean RegistrarPac(HistoriaClinica_DBO x, String DNI, int IDUsuario) {
        //preparar consulta
        PreparedStatement PS;
        try {
            PS = con.getCnn().prepareStatement(INSERT_SQL);
            
            PS.setString(1, x.getCodigoHC());
            java.sql.Date date = new java.sql.Date(x.getFechaCreacion().getTime());
            PS.setDate(2, date);
            PS.setString(3, x.getConsumeAlcohol());
            PS.setString(4, x.getConsumeTabaco());
            PS.setString(5, x.getConsumeDrogas());
            PS.setString(6, x.getConsumeInfusiones());
            PS.setString(7, x.getAlimentacion());
            PS.setString(8, x.getDiuresis());
            PS.setString(9, x.getCatarsis());
            PS.setString(10, x.getSueño());
            PS.setString(11, x.getEnfermedadActual());
            PS.setString(12, DNI);
            PS.setInt(12, IDUsuario);
            if (PS.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            // AGREGAR MENSAJE DE ERROR
            JOptionPane.showMessageDialog(null, "DNI EXISTENTE", "ERROR", 0);
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
                return true;
            }
        } catch (SQLException ex) {
            // AGREGAR AL WORD MENSAJE DE ERROR
            JOptionPane.showMessageDialog(null, "DNI EXISTENTE", "ERROR", 0);
        } finally {
            //Cerrar conexion
            con.setCnn();
        }
        return false;
    }
    
    private enum tipo {HistoriaClinica_DBO, Paciente_DBO}
    /*
    public ArrayList<tipo> BuscarPac(String key) {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<tipo> lista = new ArrayList();
        try {
            ps = con.getCnn().prepareStatement(BUSCAR_SQL);
            ps.setString(1, key);
            res = ps.executeQuery();
            while (res.next()) {
                
                java.sql.Date date = new java.sql.Date(res.getDate(2).getTime());
                
                
                lista.add(new Paciente_DBO(
                        res.getString(1), date, res.getString(3), res.getString(4),
                        res.getString(5), res.getString(6), res.getString(7).charAt(0),
                        res.getInt(8), res.getString(9), res.getBytes(10)));
            }
            return lista;
        } catch (SQLException ex) {
            // AGREGAR AL WORD MENSAJE DE ERROR
            JOptionPane.showMessageDialog(null, "PACIENTE NO EXISTENTE", "ERROR", 0);
        } finally {
            con.setCnn();
        }
        return null;
    }
    
    */
}
