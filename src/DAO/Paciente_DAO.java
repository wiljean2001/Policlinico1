package DAO;

import DBO.HistoriaClinica_DBO;
import DBO.Paciente_DBO;
import Interfaces.Mensaje;
import Main.Hospital_v2;
import conexion.conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Paciente_DAO {

    private static final String INSERT_SQL = "INSERT INTO Paciente VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE Paciente SET DNI =?, Fecha_Nacimiento=?, Telefono=?,"
            + "Apellido=?, Nombre=?, Dirección=?, Sexo=?, Edad=?, EstadoCivil=?, Foto=? WHERE DNI =? ";
    private static final String BUSCAR_SQL = "SELECT * FROM Paciente WHERE DNI=?";
    private static final String BUSCAR_Inner = "select CodigoHC FROM HistorialClinico HC join Paciente p On p.DNI = HC.DNI where p.DNI=?";

    //private static final String READ_ALL_SQL = "SELECT * FROM RegistroPac";
    private static final conexion con = conexion.SaberEstado();

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
                return true;
            }
        } catch (SQLException e) {
            // AGREGAR MENSAJE DE ERROR
            Mensaje.MensajeError("DNI EXISTENTE", "ERROR");
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
            Mensaje.MensajeError("DNI EXISTENTE", "ERROR");
        } finally {
            //Cerrar conexion
            con.setCnn();
        }
        return false;
    }

    public ArrayList<Paciente_DBO> BuscarPac(String key) {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<Paciente_DBO> lista = new ArrayList();
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
            Mensaje.MensajeError("PACIENTE NO EXISTENTE", "ERROR");
        } finally {
            con.setCnn();
        }
        return null;
    }

    public ArrayList<Paciente_DBO> BuscarHC(String key) {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<Paciente_DBO> lista = new ArrayList();
        try {
            ps = con.getCnn().prepareStatement(BUSCAR_Inner);
            ps.setString(1, key);

            res = ps.executeQuery();

            while (res.next()) {

                if (res.getString(1) != null) {
                    Hospital_v2.FBP.ButtonEnviarPaciente.setVisible(false);
                    Mensaje.MensajeError("El Historial clínico ya existe", "HC EXISTENTE");
                } else {
                    Hospital_v2.FBP.ButtonEnviarPaciente.setVisible(true);

                    Mensaje.MensajeConformidad("ACCIÓN COMPLETADA!", "MENSAJE");
                }

            }
            lista = BuscarPac(key);
            return lista;
        } catch (SQLException ex) {
            // AGREGAR AL WORD MENSAJE DE ERROR
            Mensaje.MensajeError("PACIENTE NO EXISTENTE: " + ex, "ERROR");
        } finally {
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
