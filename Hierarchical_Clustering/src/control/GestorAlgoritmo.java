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
        return matriz;
    }

    public double[][] generarSubMatriz(double[][] matrizOriginal, int posX, int posY) {
        double[][] aux = new double[matrizOriginal.length-1][matrizOriginal.length-1];
        return aux;
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

}
