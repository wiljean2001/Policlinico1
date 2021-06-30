/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Vistas.RegistrarHC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cntrlRegistrarHC implements ActionListener{
    
    RegistrarHC rHC = new RegistrarHC();
    public cntrlRegistrarHC(RegistrarHC rHC){
        this.rHC = rHC;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
