package DAO;

import DBO.Paciente_DBO;
import DBO.HistoriaClinica_DBO;
import Interfaces.Mensaje;
import conexion.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HistorialClinico_DAO {

    private static final String INSERT_SQL = "INSERT INTO HistorialClinico VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE HistorialClinico SET ConsumeAlcohol=?, "
            + "ConsuConsumoTabaco=?, ?ConsumoDrogas=, ConsumeInfusiones=?, Alimentacion=?, Diuresis=?,"
            + " Catarsis=?, Sueño=?, EnfermedadActul=?, where CodigoHC?";

    private static final String BUSCAR_Inner = "select * FROM HistorialClinico HC join Paciente p On p.DNI = HC.DNI where p.DNI=? or HC.CodigoHC=?";

    //private static final String READ_ALL_SQL = "SELECT * FROM RegistroPac";
    private static final conexion con = conexion.SaberEstado();

    public boolean RegistrarHC(HistoriaClinica_DBO x, String DNI) {
        //preparar consulta
        PreparedStatement PS;
        try {
            PS = con.getCnn().prepareStatement(INSERT_SQL);
            PS.setString(1, x.getCodigoHC());
            long fecha = x.getFechaCreacion().getTime();
            java.sql.Date date = new java.sql.Date(fecha);
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
            PS.setInt(13, 0);
            if (PS.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            // AGREGAR MENSAJE DE ERROR
            //Mensaje.MensajeError("HISTORIAL CLÍNICO EXISTENTE", "ERROR");
        } finally {
            //Cerrar conexion
            con.setCnn();
        }
        return false;
    }

    public boolean ActualizarPac(HistoriaClinica_DBO x) {
        PreparedStatement PS;

        try {
            PS = con.getCnn().prepareStatement(UPDATE_SQL);
            PS.setString(1, x.getConsumeAlcohol());
            PS.setString(2, x.getConsumeTabaco());
            PS.setString(3, x.getConsumeDrogas());
            PS.setString(4, x.getConsumeInfusiones());
            PS.setString(5, x.getAlimentacion());
            PS.setString(6, x.getDiuresis());
            PS.setString(7, x.getCatarsis());
            PS.setString(8, x.getSueño());
            PS.setString(9, x.getEnfermedadActual());
            PS.setString(10, x.getCodigoHC());

            if (PS.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            // AGREGAR AL WORD MENSAJE DE ERROR
            Mensaje.MensajeError("HISTORIAL CLÍNICO NO SE PUDO ACTUALIZAR", "ERROR");
        } finally {
            //Cerrar conexion
            con.setCnn();
        }

        return false;
    }
    private ArrayList<Paciente_DBO> arrayPac = new ArrayList();

    public ArrayList<HistoriaClinica_DBO> BuscarHC(String key) {
        PreparedStatement ps = null;
        ResultSet res;
        ArrayList<HistoriaClinica_DBO> arrayHC = new ArrayList();
        try {

            ps = con.getCnn().prepareStatement(BUSCAR_Inner);

            ps.setString(1, key);
            ps.setString(2, key);

            res = ps.executeQuery();

            while (res.next()) {

                java.sql.Date FechaCreacionHC = new java.sql.Date(res.getDate(2).getTime());

                arrayHC.add(new HistoriaClinica_DBO(
                        res.getString(1), FechaCreacionHC, res.getString(3),
                        res.getString(4), res.getString(5), res.getString(6),
                        res.getString(7), res.getString(8), res.getString(9),
                        res.getString(10), res.getString(11)));

                java.sql.Date FechaNac = new java.sql.Date(res.getDate(15).getTime());
                arrayPac.add(new Paciente_DBO(
                        res.getString(14), FechaNac, res.getString(16), res.getString(17),
                        res.getString(18), res.getString(19), res.getString(20).charAt(0),
                        res.getInt(21), res.getString(22), res.getBytes(23)));

            }
            return arrayHC;
        } catch (SQLException ex) {
            // AGREGAR AL WORD MENSAJE DE ERROR
            Mensaje.MensajeError("HISTORIAL CLÍNICO NO EXISTE", "ERROR");
        } finally {
            con.setCnn();
        }
        return null;
    }

    public ArrayList<Paciente_DBO> BuscarPaciente() {
        return arrayPac;
    }

}
