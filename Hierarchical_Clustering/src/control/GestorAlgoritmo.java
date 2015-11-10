/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.LinkedList;
import modelo.Individuo;

/**
 *
 * @author c09141a
 */
public class GestorAlgoritmo {

    public GestorAlgoritmo() {
    }

    public double[][] generarMatrizInicial(LinkedList<Individuo> individuos) {
        double[][] multi = new double[individuos.size()][individuos.size()];
        for (int i = 0; i < individuos.size(); i++) {
            for (int j = 0; j < individuos.size(); j++) {
                multi[j][i] = GetDistanciaEuclidea(individuos.get(i), individuos.get(j));
            }
        }
        return multi;
    }

    public double[][] generarMatriz(double[][] matriz) {
        double valor = matriz[1][0];
        int posX = 1, posY = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i != 0 && j != 0 && valor > matriz[j][i]) {
                    posX = j;
                    posY = i;
                    valor = matriz[j][i];
                }
            }
        }

        double[][] matrizDestino = matriz;
        matrizDestino = EliminarColumnaFila(posX, posY, matrizDestino);
        matrizDestino = EliminarColumnaFila(posY, posX, matrizDestino);
        matrizDestino = AgregarFilaInicio(matrizDestino);

        matrizDestino = completarNuevoIndividuo(matrizDestino, matriz, posX, posY);

        return matriz;
    }

    public double[][] completarNuevoIndividuo(double[][] matrizDestino, double[][] matrizOriginal, int posX, int posY) {
        int contador;
        for (int i = 1; i < matrizDestino.length; i++) {
            contador = i;
            
            if (contador == posX || contador == posY){
                contador++;
                if (contador == posX || contador == posY){
                    contador++;
                }
            }
            
            if (matrizOriginal[posX][contador] > matrizOriginal[posY][contador]) {
//                System.out.println("Y: " + matrizOriginal[posY][contador]);
//                System.out.println("X: " + matrizOriginal[posX][contador]);
                matrizDestino[0][i] = matrizOriginal[posX][contador];
                matrizDestino[i][0] = matrizOriginal[contador][posX];
            } else {
//                System.out.println("Y: " + matrizOriginal[posY][contador]);
//                System.out.println("X: " + matrizOriginal[posX][contador]);
                matrizDestino[0][i] = matrizOriginal[posY][contador];
                matrizDestino[i][0] = matrizOriginal[contador][posY];
            }
        }
        return matrizDestino;
    }

    public double GetDistanciaEuclidea(Individuo in1, Individuo in2) {
        if (in1.equals(in2)) {
            return 0;
        }
        double valor = 0;
        for (int i = 0; i < in1.getListaValores().size(); i++) {
            valor += pow(in1.getListaValores().get(i) + in2.getListaValores().get(i), 2);

        }
        return sqrt(valor);
    }

    public double[][] AgregarFilaInicio(double[][] matrizOriginal) {
        double[][] matrizDestino = new double[matrizOriginal.length + 1][matrizOriginal.length + 1];
        for (int i = 0; i < matrizDestino.length; i++) {
            matrizDestino[i][0] = 0;
            matrizDestino[0][i] = 0;
        }

        for (int i = 1; i < matrizDestino.length; i++) {
            for (int j = 1; j < matrizDestino.length; j++) {
                matrizDestino[j][i] = matrizOriginal[j - 1][i - 1];
            }
        }

//        System.out.println("\n\n\n");
//
//        for (int i = 0; i < matrizDestino.length; i++) {
//            for (int j = 0; j < matrizDestino.length; j++) {
//                System.out.print("\t" + matrizDestino[j][i]);
//            }
//            System.out.println("");
//        }

        return matrizDestino;
    }

    public double[][] EliminarColumnaFila(int fil, int col, double[][] matrizOriginal) {

//        for (int i = 0; i < matrizOriginal.length; i++) {
//            for (int j = 0; j < matrizOriginal.length; j++) {
//                System.out.print("\t" + matrizOriginal[j][i]);
//            }
//            System.out.println("");
//        }

        double destinationarr[][] = new double[matrizOriginal.length - 1][matrizOriginal.length - 1];

        int p = 0;
        for (int i = 0; i < matrizOriginal.length; ++i) {
            if (i == fil) {
                continue;
            }

            int q = 0;
            for (int j = 0; j < matrizOriginal.length; ++j) {
                if (j == col) {
                    continue;
                }

                destinationarr[p][q] = matrizOriginal[i][j];
                ++q;
            }

            ++p;
        }

//        System.out.println("\n\n\n");
//
//        for (int i = 0; i < destinationarr.length; i++) {
//            for (int j = 0; j < destinationarr.length; j++) {
//                System.out.print("\t" + destinationarr[j][i]);
//            }
//            System.out.println("");
//        }

        return destinationarr;
    }

}
