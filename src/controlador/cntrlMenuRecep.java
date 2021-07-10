package controlador;

import Interfaces.Seteo;
import Vistas.MenuRecep;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import rojeru_san.complementos.RSMoveWindow;
import rojerusan.RSAnimation;
import Main.*;

public class cntrlMenuRecep implements MouseListener {

    private MenuRecep m;
    private RSMoveWindow a = new RSMoveWindow();
    private JPanel Panel_cont, Panel_Bott, Panel_Inf, PanelArriba, PanelIzq, PanelIzqArriba;
    private JButton button_Reg, button_BusHC, button_BusPac, button_ActPac, cerrarSesion;
    private JToggleButton bttn_MenuDespl;
    private JDesktopPane DesktopPaneMenu;
    private JLabel DNI, Nombres, Prof, CELL, TipoCuenta;
    private final int altoAct = Hospital_v2.FBP.getHeight() - Hospital_v2.FBP.ButtonEnviarPaciente.getHeight();
    private final int anchoAct = Hospital_v2.FBP.getWidth();
    private final int anchoPanel;
    private final int altoPanel;
    // otros

    public cntrlMenuRecep(MenuRecep m) {
        this.m = m;
        m.setLocationRelativeTo(null);
        Acciones(m);
        Panel_cont.add(Panel_Bott);
        a.setMoveWindow(this.m);

        anchoPanel = DesktopPaneMenu.getWidth();
        altoPanel = DesktopPaneMenu.getHeight();
    }

    private void Acciones(MenuRecep m) {
        //Panelenes--------------------
        Panel_cont = m.PanelContenedor;
        Panel_Bott = m.bttnExtra;
        DesktopPaneMenu = m.jDesktopPaneMenu;
        //Menus
        PanelArriba = m.jPanelARRIBA;
        PanelIzq = m.jPanelIzq;
        PanelIzqArriba = m.jPanelIzqArriba;

        // Botones----------------- jDesktopPaneMenu
        button_Reg = m.button_RegPaciente;
        button_BusHC = m.button_BuscarHC;
        bttn_MenuDespl = m.MovButt_Menu;
        button_BusPac = m.button_BuscarPaciente;
        button_ActPac = m.button_ActPaciente;
        cerrarSesion = m.buttonCerrarSesion;

        cerrarSesion.addMouseListener(this);
        button_Reg.addMouseListener(this);
        button_BusHC.addMouseListener(this);
        bttn_MenuDespl.addMouseListener(this);
        button_BusPac.addMouseListener(this);
        button_ActPac.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Seteo.SeteoPaneles();
        if (e.getSource() == bttn_MenuDespl) {
            DesplazarMenu();
        }
        //Botòn buscar Registrar Paciente
        if (e.getSource() == button_Reg) {
            Hospital_v2.cRP.primeravez = false;
            Hospital_v2.cRP.limpiar();
            DesktopPaneMenu.add(Hospital_v2.FRP);
            Hospital_v2.FRP.setVisible(true);
            
        }
        //Botòn buscar paciente
        if (e.getSource() == button_BusPac) {
            Hospital_v2.cBP.limpiar();
            Hospital_v2.FBP.ButtonEnviarPaciente.setVisible(false);
            Hospital_v2.FBP.setSize(new Dimension(anchoAct, altoAct));
            Hospital_v2.FBP.setVisible(true);

        }
        //Botòn Actualizar PacienteHGGHGHG
        if (e.getSource() == button_ActPac) {
            Hospital_v2.cAP.limpiar();
            DesktopPaneMenu.add(Hospital_v2.FAP);
            Hospital_v2.FAP.setVisible(true);

        }
        //Botòn buscar Historial clinico
        if (e.getSource() == button_BusHC) {
            Hospital_v2.FBHC.setVisible(true);
        }
        if (e.getSource() == cerrarSesion) {
            m.dispose();
            Hospital_v2.FL.setVisible(true);
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

        if (PanelIzq.getX() == 5) {
            //PanelIzq
            RSAnimation.setMoverIzquierda(5, -250, 5, 5, PanelIzq);
            RSAnimation.setMoverIzquierda(5, -(245 - 60), 4, 4, PanelIzqArriba);
            RSAnimation.setMoverIzquierda(255, 5, 4, 4, m.rSScrollPane1);
            m.rSScrollPane1.setBounds(m.rSScrollPane1.getX(), m.rSScrollPane1.getY(), m.getWidth() + (255 - 15), altoPanel);
            //m.rSScrollPane1.setSize(new Dimension());

        } else {
            RSAnimation.setMoverDerecha(-250, 5, 5, 5, PanelIzq);
            RSAnimation.setMoverDerecha(-(245 - 60), 0, 4, 4, PanelIzqArriba);
            RSAnimation.setMoverDerecha(5, 255, 4, 4, m.rSScrollPane1);
            //m.rSScrollPane1.setBounds(255, 65, m.getWidth() - 10, 830);
            m.rSScrollPane1.setSize(new Dimension(anchoPanel, altoPanel));
        }

    }

}
