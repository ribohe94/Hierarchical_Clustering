/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hierarchical_clustering;

import control.GestorAlgoritmo;

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
        double[][] matriz = {
            {0    , 99.8    , 71.44   , 61.08 , 2.44  , 93.68},
            {99.8 , 0       , 69.84   , 98.77 , 100.59, 61.74},
            {71.44, 69.84   , 0       , 33.79 , 71.19 , 44.51},
            {61.08, 98.77   , 33.79   , 0     , 59.74 , 61.33},
            {2.44 , 100.59  , 71.19   , 59.74 , 0     , 61.80},
            {93.68, 61.74   , 44.51   , 61.33 , 61.80 , 0}
        };

        double[][] matrizDestino = matriz;
        
        matrizDestino = ga.eliminarFila(3, matrizDestino);
        
        for (int i = 0; i < matrizDestino.length; i++) {
            for (int j = 0; j < matrizDestino.length; j++) {
                System.out.print("\t" + matrizDestino[j][i]);
            }
            System.out.println("");
        }
        

//        matrizDestino = ga.generarMatriz(matriz);
        
//        matrizDestino = ga.EliminarColumnaFila(5, 5, matrizDestino);
//        matrizDestino = ga.EliminarColumnaFila(4, 4, matrizDestino);
//        
//        matrizDestino = ga.AgregarFilaInicio(matrizDestino);
//        matrizDestino = ga.completarNuevoIndividuo(matrizDestino, matriz, 0, 4);
//
//        for (int i = 0; i < matrizDestino.length; i++) {
//            for (int j = 0; j < matrizDestino.length; j++) {
//                System.out.print("\t" + matrizDestino[j][i]);
//            }
//            System.out.println("");
//        }

//        ga.AgregarFilaInicio(ga.EliminarColumnaFila(0, 0, matriz));
//        ga.AgregarFilaInicio(ga.EliminarColumnaFila(5, 5, matriz));
    }
}
