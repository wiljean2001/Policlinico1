package Interfaces;

import RSMaterialComponent.RSCheckBoxMaterial;
import app.bolivia.swing.JCTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import rojerusan.RSDateChooser;
import rojerusan.RSLabelImage;

public class Enable {
    public static void DesactivarRSTextField(JPanel formulario) {
        JCTextField clear;
        JLabel clear2;
        RSLabelImage clear3;
        JDateChooser FechadeNacimiento;
        for (int i = 0; i < formulario.getComponentCount(); i++) {
            if (formulario.getComponent(i).getClass().getName().equals("app.bolivia.swing.JCTextField")) {
                clear = (JCTextField) formulario.getComponent(i);
                clear.setEditable(false);
            }
            if (formulario.getComponent(i).getClass().getName().equals("javax.swing.JLabel")) {
                clear2 = (JLabel) formulario.getComponent(i);
                clear2.setEnabled(false);
            }
            if (formulario.getComponent(i).getClass().getName().equals("rojerusan.RSLabelImage")) {
                clear3 = (RSLabelImage) formulario.getComponent(i);
                clear3.setEnabled(false);
            }
            if (formulario.getComponent(i).getClass().getName().equals("com.toedter.calendar.JDateChooser")) {
                FechadeNacimiento = (JDateChooser) formulario.getComponent(i);
                FechadeNacimiento.setEnabled(false);
            }
        }
    }
    public static void ActivarRSTextField(JPanel formulario) {
        JCTextField clear;
        JLabel clear2;
        RSLabelImage clear3;
        JDateChooser FechadeNacimiento;
        for (int i = 0; i < formulario.getComponentCount(); i++) {
            if (formulario.getComponent(i).getClass().getName().equals("app.bolivia.swing.JCTextField")) {
                clear = (JCTextField) formulario.getComponent(i);
                clear.setEditable(true);
            }
            if (formulario.getComponent(i).getClass().getName().equals("javax.swing.JLabel")) {
                clear2 = (JLabel) formulario.getComponent(i);
                clear2.setEnabled(true);
            }
            if (formulario.getComponent(i).getClass().getName().equals("rojerusan.RSLabelImage")) {
                clear3 = (RSLabelImage) formulario.getComponent(i);
                clear3.setEnabled(true);
            }
            if (formulario.getComponent(i).getClass().getName().equals("com.toedter.calendar.JDateChooser")) {
                FechadeNacimiento = (JDateChooser) formulario.getComponent(i);
                FechadeNacimiento.setEnabled(true);
            }
        }
    }
    public static void ActivarJCheckBox(JPanel formulario) {
        RSCheckBoxMaterial clear;
        for (int i = 0; i < formulario.getComponentCount(); i++) {
            if (formulario.getComponent(i).getClass().getName().equals("RSMaterialComponent.RSCheckBoxMaterial")) {
                clear = (RSCheckBoxMaterial) formulario.getComponent(i);
                clear.setEnabled(true);
            }
        }
    }
    public static void DesactivarJCheckBox(JPanel formulario) {
        RSCheckBoxMaterial clear;
        for (int i = 0; i < formulario.getComponentCount(); i++) {
            if (formulario.getComponent(i).getClass().getName().equals("RSMaterialComponent.RSCheckBoxMaterial")) {
                clear = (RSCheckBoxMaterial) formulario.getComponent(i);
                clear.setEnabled(false);
            }
        }
    }
    
    public static void DesactivarJTextArea(JDateChooser clear) {
        clear.setDate(null);
    }
    public static void ActivarJTextArea(RSDateChooser clear) {
        clear.setTextoFecha("");
    }
}
