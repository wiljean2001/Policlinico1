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

    private static final String BUSCAR_Inner = "select * FROM HistorialClinico HC join Paciente p On p.DNI = HC.DNI where p.DNI=? or HC.CodigoHC=?";
    private static final String BUSCAR_Right = "select * FROM HistorialClinico HC right join Paciente p On p.DNI = HC.DNI where p.DNI=? or HC.CodigoHC=?";

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
            PS.setInt(13, IDUsuario);
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

    public boolean ActualizarPac(HistoriaClinica_DBO x) {
        PreparedStatement PS;
        /*
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
         */
        return false;
    }
    private ArrayList<Paciente_DBO> arrayPac = new ArrayList();

    public ArrayList<HistoriaClinica_DBO> BuscarHC(String key, int Form) {
        PreparedStatement ps = null;
        ResultSet res;
        ArrayList<HistoriaClinica_DBO> arrayHC = new ArrayList();
        try {
            switch (Form) {
                case 1:
                    ps = con.getCnn().prepareStatement(BUSCAR_Right);

                    break;
                case 0:
                    ps = con.getCnn().prepareStatement(BUSCAR_Inner);
                    break;
            }
            ps.setString(1, key);
            ps.setString(2, key);

            res = ps.executeQuery();

            while (res.next()) {
                
                if(res.getString(1)!=null){
                    java.sql.Date FechaCreacionHC = new java.sql.Date(res.getDate(2).getTime());

                    arrayHC.add(new HistoriaClinica_DBO(
                            res.getString(1), FechaCreacionHC, res.getString(3),
                            res.getString(4), res.getString(5), res.getString(6),
                            res.getString(7), res.getString(8), res.getString(9),
                            res.getString(10), res.getString(11)));
                }
                
                java.sql.Date FechaNac = new java.sql.Date(res.getDate(15).getTime());
                arrayPac.add(new Paciente_DBO(
                        res.getString(14), FechaNac, res.getString(16), res.getString(17),
                        res.getString(18), res.getString(19), res.getString(20).charAt(0),
                        res.getInt(21), res.getString(22), res.getBytes(23)));

            }

            return arrayHC;
        } catch (SQLException ex) {
            // AGREGAR AL WORD MENSAJE DE ERROR
            JOptionPane.showMessageDialog(null, "PACIENTE NO EXISTENTE: " + ex, "ERROR", 0);
        } finally {
            con.setCnn();
        }
        return null;
    }

    public ArrayList<Paciente_DBO> BuscarPaciente() {
        return arrayPac;
    }

}
