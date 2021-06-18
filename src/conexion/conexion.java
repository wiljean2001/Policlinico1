package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP-Litzy-Jean
 */
public class conexion {

    public static conexion Instancia;
    private Connection cnn;

    private conexion() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Hospital_v2";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnn = DriverManager.getConnection(url, "sa","jayalaga");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de Conexion a la Base de Datos", "Error Conexion", 1);
        }
    }

    public synchronized static conexion SaberEstado() {
        if (Instancia == null) {
            Instancia = new conexion();
        }
        return Instancia;
    }

    public Connection getCnn() {
        return cnn;
    }

    public void setCnn() {
        Instancia = null;
    }
    
}
