package controlador;

import Vistas.Cargando;
import Vistas.Login;
import Vistas.MenuMedicos;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class cntrlLoading implements Runnable {

    private JLabel iconoLog;
    private Thread tiempo = null;
    private Login l = null;
    private cntrlLogin cntrlL = null;
    Cargando c = new Cargando();

    public cntrlLoading(Cargando c) {
        this.c = c;
        l = new Login();
        iconoLog = c.jLabelLoad;
        c.setLocationRelativeTo(null);

        /*ImageIcon imagenicon = new ImageIcon(cntrlLogin.class.getResource("/recursos/cat_loading.gif"));
        Icon icono = new ImageIcon(imagenicon.getImage().getScaledInstance(iconoLog.getWidth(), iconoLog.getHeight(), Image.SCALE_DEFAULT));
        iconoLog.setIcon(icono);
*/
        tiempo = new Thread(this);
        tiempo.start();
    }

    @Override
    public void run() {
        while (tiempo != null) {
            try {
                Thread.sleep(5000);
                tiempo = null;
                c.dispose();
                cntrlL = new cntrlLogin(l);
                l.setVisible(true);
                c = null;
            } catch (InterruptedException ex) {
                Logger.getLogger(Cargando.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
