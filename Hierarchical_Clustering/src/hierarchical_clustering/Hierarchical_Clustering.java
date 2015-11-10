/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hierarchical_clustering;

import control.GestorAlgoritmo;
import java.util.LinkedList;
import modelo.ContenedorIndividuo;
import modelo.Individuo;

/**
 *
 * @author c09141a
 */
public class Hierarchical_Clustering {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


        GestorAlgoritmo ga = new GestorAlgoritmo();
        double[][] matriz = {{22.1, 12, 543, 667, 34.6},
        {54, 23.55, 23.54, 12, 76},
        {234, 13, 656, 233, 6},
        {4, 13, 4, 78, 3},
        {12, 54, 23, 87, 9}};
        ga.AgregarFilaInicio(ga.EliminarColumnaFila(2, 2, matriz));

    }
}
