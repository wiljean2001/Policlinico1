package Interfaces;

import Main.Hospital_v2;
import RSMaterialComponent.RSCheckBoxMaterial;
import app.bolivia.swing.JCTextField;
import com.toedter.calendar.JDateChooser;
import rojerusan.RSDateChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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

    public static void SeteoCheckbox(JPanel formulario) {
        RSCheckBoxMaterial clear;
        for (int i = 0; i < formulario.getComponentCount(); i++) {
            if (formulario.getComponent(i).getClass().getName().equals("RSMaterialComponent.RSCheckBoxMaterial")) {
                clear = (RSCheckBoxMaterial) formulario.getComponent(i);
                clear.setSelected(false);
            }
        }
    }

    public static void SeteoJCalendar(JDateChooser datechooser) {
        datechooser.setDate(null);
    }
    public static void SeteoJCalendar(RSDateChooser datechooser) {
        datechooser.setLimpiarFecha(true);
    }

    public static void SeteoJTable(DefaultTableModel modelo) {
        int valor = modelo.getRowCount() - 1;
        for (int i = valor; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public static void SeteoJTextArea(JTextArea clear) {
        clear.setText("");
    }

}
