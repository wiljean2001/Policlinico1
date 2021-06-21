package controlador;

import Vistas.ActualizarP;
import Vistas.BuscarHC;
import Vistas.BuscarPaciente;
import Vistas.MenuRecep;
import Vistas.RegistrarP;
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

/**
 *
 * @author HP-Litzy-Jean
 */
public class cntrlMenuRecep implements MouseListener {

    MenuRecep m = new MenuRecep();
    RSMoveWindow a = new RSMoveWindow();

    private JPanel Panel_cont, Panel_Bott, Panel_Inf, PanelArriba, PanelIzq, PanelIzqArriba;
    private JButton button_Reg, button_BusHC, button_BusPac, button_ActPac;
    private JToggleButton bttn_MenuDespl;
    public static JDesktopPane DesktopPaneMenu;
    private JLabel DNI, Nombres, Prof, CELL, TipoCuenta;
    RegistrarP r = null;
    cntrlRegistrarP cntrlR = null;
    // otros

    public cntrlMenuRecep(MenuRecep m) {
        this.m = m;
        Acciones(m);
        Panel_cont.add(Panel_Bott);
        a.setMoveWindow(this.m);
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

        button_Reg.addMouseListener(this);
        button_BusHC.addMouseListener(this);
        bttn_MenuDespl.addMouseListener(this);
        button_BusPac.addMouseListener(this);
        button_ActPac.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == bttn_MenuDespl) {
            DesplazarMenu();
        }
        //Botòn buscar Registrar Paciente
        if (e.getSource() == button_Reg) {
            r = new RegistrarP();
            cntrlR = new cntrlRegistrarP(r);
            DesktopPaneMenu.add(r);
            cntrlR.limpiar();
            r.setVisible(true);
        }
        //Botòn buscar paciente
        if (e.getSource() == button_BusPac) {
            BuscarPaciente buscarP = new BuscarPaciente(m, false);
            cntrlBuscarP cntrl_BuscPac = new cntrlBuscarP(buscarP);
            //DesktopPaneMenu.add(buscarP);
            buscarP.ButtonEnviarPaciente.setVisible(false);
            buscarP.setSize(new Dimension(1163, 409 - 80));
            buscarP.setVisible(true);
        }
        //Botòn Actualizar PacienteHGGHGHG
        if (e.getSource() == button_ActPac) {
            ActualizarP actualizarP = new ActualizarP();
            cntrlActualizarP cntrl_ActualizarP = new cntrlActualizarP(actualizarP);
            DesktopPaneMenu.add(actualizarP);
            actualizarP.setVisible(true);
        }
        //Botòn buscar Historial clinico
        if (e.getSource() == button_BusHC) {
            BuscarHC c = new BuscarHC();
            //falta controlador
            DesktopPaneMenu.add(c);
            c.ButtonEnviarHC.setVisible(false);
            c.setVisible(true);
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
            m.rSScrollPane1.setBounds(5, 65, m.getWidth() + (255 - 15), 830);

        } else {
            RSAnimation.setMoverDerecha(-250, 5, 5, 5, PanelIzq);
            RSAnimation.setMoverDerecha(-(245 - 60), 0, 4, 4, PanelIzqArriba);
            RSAnimation.setMoverDerecha(5, 255, 4, 4, m.rSScrollPane1);
            m.rSScrollPane1.setBounds(255, 65, m.getWidth() - 10, 830);
        }

    }

}
