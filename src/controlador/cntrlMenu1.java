package controlador;

import Vistas.BuscarHC;
import Vistas.Menu1;
import Vistas.RegistrarP;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import rojeru_san.complementos.RSMoveWindow;
import rojerusan.RSAnimation;

/**
 *
 * @author HP-Litzy-Jean
 */
public class cntrlMenu1 implements MouseListener {

    Menu1 m = new Menu1();
    RSMoveWindow a = new RSMoveWindow();

    private JPanel Panel_cont, Panel_Bott, Panel_Inf, PanelArriba, PanelIzq, PanelIzqArriba;
    private JButton button_Reg, button_Bus, bttn_Menu, bttn_close;
    private JToggleButton bttn_MenuDespl;
    private JDesktopPane DesktopPaneMenu;
    private JLabel DNI, Nombres, Prof, CELL, TipoCuenta;
    RegistrarP r = null;
    cntrlRegistrarP cntrlR = null;
    // otros
    boolean estado;

    public cntrlMenu1(Menu1 m) {
        this.m = m;
        Acciones(m);
        Panel_cont.add(Panel_Bott);
        estado = false;
        a.setMoveWindow(this.m);
        bttn_Menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //
        DesplazarMenu();
        m.setExtendedState(JFrame.NORMAL);
    }

    private void Acciones(Menu1 m) {
        //Panelenes--------------------
        Panel_cont = m.PanelContenedor;
        Panel_Bott = m.bttnExtra;
        DesktopPaneMenu = m.jDesktopPaneMenu;

        //Menus
        PanelArriba = m.jPanelARRIBA;
        PanelIzq = m.jPanelIzq;
        PanelIzqArriba = m.jPanelIzqArriba;

        // Botones----------------- jDesktopPaneMenu
        bttn_Menu = m.buttonMenu;
        button_Reg = m.buttonReg;
        button_Bus = m.button_Bus;
        bttn_MenuDespl = m.MovButt_Menu;
        bttn_close = m.Close_button;

        button_Bus.addMouseListener(this);
        button_Reg.addMouseListener(this);
        bttn_Menu.addMouseListener(this);
        bttn_MenuDespl.addMouseListener(this);
        bttn_close.addMouseListener(this);

        // Labels
    }

    private void informacionUser() {
        /*
        DBO_admin = DAO_admin.ReadAdmin(usuario);
        DNI.setText(String.valueOf(DBO_admin.getDNI()));
        Nombres.setText(DBO_admin.getNom_Apll());
        Prof.setText(DBO_admin.getProf());
        TipoCuenta.setText(DBO_admin.getTipo_cuenta());
        CELL.setText(String.valueOf(DBO_admin.getCelular()));
         */
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        PanelInf_Botones(e);
        PanelDesktop(e);
        if (e.getSource() == bttn_MenuDespl) {
            DesplazarMenu();
        }
        if (e.getSource() == bttn_close) {
            System.exit(0);
        }
    }

    private void PanelInf_Botones(MouseEvent e) {
        if (e.getSource() == bttn_Menu) {
            if (estado) {
                Panel_cont.add(Panel_Bott);
                estado = false;
            } else {
                Panel_cont.add(Panel_Inf);
                estado = true;
            }
        }
    }

// botón registrar
    private void PanelDesktop(MouseEvent e) {
        if (e.getSource() == button_Reg) {
            if (r == null) {
                r = new RegistrarP();
                cntrlR = new cntrlRegistrarP(r);
            }
            DesktopPaneMenu.add(r);
            r.setVisible(true);
        }
        if (e.getSource() == button_Bus) {
            BuscarHC c = new BuscarHC();
            DesktopPaneMenu.add(c);
            c.setVisible(true);

            //panela.setSize(336, 455);
            /**
             * para paneles DesktopPaneMenu.add(panel);
             * DesktopPaneMenu.validate(); DesktopPaneMenu.repaint();
             */
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void DesplazarMenu() {
        bttn_MenuDespl.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                int estado = e.getStateChange();
                if (PanelIzq.getX() == 5) {
                    //PanelIzq
                    RSAnimation.setMoverIzquierda(5, -250, 5, 5, PanelIzq);
                    RSAnimation.setMoverIzquierda(5, -(245 - 60), 4, 4, PanelIzqArriba);
                    RSAnimation.setMoverIzquierda(255, 5, 4, 4, m.rSScrollPane1);
                    m.rSScrollPane1.setBounds(5, 65, m.getWidth() + (255 - 15), m.getHeight());

                } else {
                    RSAnimation.setMoverDerecha(-250, 5, 5, 5, PanelIzq);
                    RSAnimation.setMoverDerecha(-(245 - 60), 0, 4, 4, PanelIzqArriba);
                    RSAnimation.setMoverDerecha(5, 255, 4, 4, m.rSScrollPane1);
                    m.rSScrollPane1.setBounds(255, 65, m.getWidth() - 10, m.getHeight());
                }

            }

        });
    }

}
