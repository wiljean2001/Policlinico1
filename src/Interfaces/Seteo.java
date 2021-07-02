package Interfaces;

import Main.Hospital_v2;
import app.bolivia.swing.JCTextField;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Seteo {

    public static void SeteoPaneles() {
        Hospital_v2.FMR.jDesktopPaneMenu.removeAll();
        Hospital_v2.FMR.jDesktopPaneMenu.repaint();
        Hospital_v2.FMM.jDesktopPaneMenu.removeAll();
        Hospital_v2.FMM.jDesktopPaneMenu.repaint();
    }

    public static void SeteoTextField(JPanel formulario) {
        JCTextField clear;
        for (int i = 0; i < formulario.getComponentCount(); i++) {
            if (formulario.getComponent(i).getClass().getName().equals("app.bolivia.swing.JCTextField")) {
                clear = (JCTextField) formulario.getComponent(i);
                clear.setText("");
            }
        }
    }

    public static void SeteoJCalendar(JPanel formulario) {
        JCTextField clear;
        for (int i = 0; i < formulario.getComponentCount(); i++) {
            if (formulario.getComponent(i).getClass().getName().equals("app.bolivia.swing.JCTextField")) {
                clear = (JCTextField) formulario.getComponent(i);
                clear.setText("");
            }
        }
    }

    public static void SeteoJTable(DefaultTableModel modelo) {
        int valor = modelo.getRowCount() - 1;
        for (int i = valor; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

}
