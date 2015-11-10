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

//        GestorAlgoritmo ga = new GestorAlgoritmo();
//        ContenedorIndividuo  i;
//        i = new ContenedorIndividuo();
//        
//        LinkedList<Double> aux = null;
//        Individuo p1 = new Individuo();
//        aux.add(34.0);
//        aux.add(3.0);
//        aux.add(3.0);
//         p1.setListaValores(aux);
//         
//        Individuo p2 = new Individuo();
//        aux.add(6.0);
//        aux.add(6.0);
//        aux.add(98.0);
//        p2.setListaValores(aux);
//        
//        Individuo p3 =  new Individuo();
//        aux.add(64.0);
//        aux.add(25.0);
//        aux.add(64.0);
//        p3.setListaValores(aux);
//        
//        Individuo p4 =  new Individuo();
//        aux.add(75.0);
//        aux.add(36.0);
//        aux.add(34.0);
//        p4.setListaValores(aux);
//        
//         Individuo p5 =  new Individuo();
//        aux.add(36.0);
//        aux.add(4.0);
//        aux.add(2.0);
//        p5.setListaValores(aux);
//      
//         Individuo p6 =  new Individuo();
//        aux.add(6.0);
//        aux.add(56.0);
//        aux.add(75.0);
//        p6.setListaValores(aux);
//        
//        LinkedList<Individuo> aux2 = null;
//        aux2.add(p1);
//        aux2.add(p2);
//        aux2.add(p3);
//        aux2.add(p4);
//        aux2.add(p5);
//        aux2.add(p6);
//        i.setIndividuos(aux2);
//        
//        double mat[][] = ga.generarMatrizInicial(i.getIndividuos());
//        
//        for (double[] mat1 : mat) {
//            for (int j = 0; j < mat.length; j++) {
//                System.out.print(mat1[j] + " | ");   
//            }
//            System.out.println("");
//        }
        GestorAlgoritmo ga = new GestorAlgoritmo();
        double[][] matriz = {{22.1, 12, 543, 667, 34.6},
        {54, 23.55, 23.54, 12, 76},
        {234, 13, 656, 233, 6},
        {4, 13, 4, 78, 3},
        {12, 54, 23, 87, 9}};
        ga.AgregarFilaInicio(ga.EliminarColumnaFila(2, 2, matriz));

    }
}
