package controlador;

import Main.Hospital_v2;
import Vistas.Cargando;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cntrlLoading implements Runnable {

    private Thread tiempo = null;
    private Cargando c;

    public cntrlLoading(Cargando c) {
        this.c = c;
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
                Hospital_v2.FL.setVisible(true);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cargando.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
