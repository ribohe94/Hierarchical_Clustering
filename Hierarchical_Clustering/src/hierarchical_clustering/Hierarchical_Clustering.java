/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hierarchical_clustering;

import control.Control;
import vista.VentanaPrincipal;

/**
 *
 * @author c09141a
 */
public class Hierarchical_Clustering {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Control c = new Control();
        VentanaPrincipal va = new VentanaPrincipal(c);
        va.init();

    }
}
