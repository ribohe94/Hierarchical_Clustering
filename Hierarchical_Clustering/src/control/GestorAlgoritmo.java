/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.PrintWriter;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.LinkedList;
import modelo.Cluster;
import modelo.ContenedorCluster;
import modelo.Individuo;
import modelo.Relacion;
import IO.Write;

/**
 *
 * @author c09141a
 */
public class GestorAlgoritmo {

    public GestorAlgoritmo() {
        ContenedorClusters = new ContenedorCluster();
    }

    //Genera la matriz inicial basandose en los valores originales de los individuos
    public LinkedList<LinkedList<Relacion>> generarMatrizInicialLista(LinkedList<Individuo> individuos) {
        LinkedList<LinkedList<Relacion>> matrizDinamica = new LinkedList<LinkedList<Relacion>>();
        for (int i = 0; i < individuos.size(); i++) {
            matrizDinamica.add(new LinkedList<>());
            for (int j = 0; j < individuos.size(); j++) {
                matrizDinamica.get(i).add(new Relacion(new Cluster("P" + String.valueOf(i)), new Cluster("P" + String.valueOf(j)), GetDistanciaEuclidea(individuos.get(i), individuos.get(j))));
            }
        }
        return matrizDinamica;
    }

    //Genera la matriz inicial basandose en los valores originales de los individuos
    public double[][] generarMatrizInicial(LinkedList<Individuo> individuos) {
        double[][] multi = new double[individuos.size()][individuos.size()];
        for (int i = 0; i < individuos.size(); i++) {
            for (int j = 0; j < individuos.size(); j++) {
                multi[j][i] = GetDistanciaEuclidea(individuos.get(i), individuos.get(j));
            }
        }
        return multi;
    }

    //Metodo recursivo que genera la matriz final
    public LinkedList<LinkedList<Relacion>> generarMatrizLista(double[][] matriz, LinkedList<LinkedList<Relacion>> matrizDinamica) {

        LinkedList<LinkedList<Relacion>> matrizDestino = matrizDinamica;

        if (matrizDestino.size() == 0) {
            return matrizDestino;
        }

        //Primero buscamos el valor mas pequeno
        double valor = matrizDestino.get(0).get(1).getValor();
        int posX = 1, posY = 0;
        for (int i = 0; i < matrizDestino.size(); i++) {
            for (int j = 0; j < matrizDestino.size(); j++) {
                if (valor > matrizDestino.get(i).get(j).getValor()) {
                    posX = i;
                    posY = j;
                    valor = matrizDestino.get(i).get(j).getValor();
                }

            }

        }

        //Eliminamos las columnas y filas de donde se encuentra el valor mas pequeno
        matrizDestino.remove(posX);
        matrizDestino.remove(posY);
        for (int i = 0; i < matrizDestino.get(i).size(); i++) {
            matrizDestino.get(i).remove(posX);
            matrizDestino.get(i).remove(posY);
        }

        //Agrego nuevas filas y columnas del nuevo cluster
        matrizDestino.addFirst(new LinkedList<>());
        for (int i = 0; i < matrizDestino.size() + 1; i++) {
            matrizDestino.get(0).add(new Relacion());
            if (i >= 1) {
                matrizDestino.get(i).addFirst(new Relacion());
            }
        }

        return matrizDestino;

//        return generarMatriz(matrizDestino);
    }

    //Metodo recursivo que genera la matriz final
    public double[][] generarMatriz(double[][] matriz) {

        if (matriz.length == 1) {
            return matriz;
        }

        //Primero buscamos el valor mas pequeno
        double valor = matriz[1][0];
        int posX = 1, posY = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (valor > matriz[j][i] && i != j) {
                    posX = j;
                    posY = i;
                    valor = matriz[j][i];
                }
            }
        }

        //Creamos una matriz auxiliar
        double[][] matrizDestino = matriz;
        //Eliminamos las columnas y filas de donde se encuentra el valor mas pequeno
        if (posX < posY) {
            matrizDestino = EliminarColumnaFila(posX, posX, matrizDestino);
            matrizDestino = EliminarColumnaFila(posY - 1, posY - 1, matrizDestino);
        }
        if (posX > posY) {
            matrizDestino = EliminarColumnaFila(posX - 1, posX - 1, matrizDestino);
            matrizDestino = EliminarColumnaFila(posY, posY, matrizDestino);
        }
        if (posX == posY) {
            matrizDestino = EliminarColumnaFila(posX, posX, matrizDestino);
            matrizDestino = EliminarColumnaFila(posY - 1, posY - 1, matrizDestino);
        }
        //Agregamos nueva fila y columna que representa una combinacion de los dos individuos que se combinaron Ej: P1 - P5
        matrizDestino = AgregarFilaInicio(matrizDestino);

        //Completamos la distancia Euclidea para el nuevo individuo Ej: P1 - P5
        matrizDestino = completarNuevoIndividuo(matrizDestino, matriz, posX, posY);

        System.out.println("Generar Matriz");
        for (int i = 0; i < matrizDestino.length; i++) {
            for (int j = 0; j < matrizDestino.length; j++) {
                System.out.print("\t" + matrizDestino[i][j]);
            }
            System.out.println("");
        }
        System.out.println("\n\n\n");

        return generarMatriz(matrizDestino);
    }

    public LinkedList<LinkedList<Relacion>> completarNuevoIndividuoLista(LinkedList<LinkedList<Relacion>> matrizDinamica, LinkedList<LinkedList<Relacion>> matrizOriginalDinamica, int posX, int posY) {

        int contador;
        for (int i = 1; i < matrizDinamica.size(); i++) {
            contador = i;

            if (contador == posX || contador == posY) {
                contador++;
                if (contador == posX || contador == posY) {
                    contador++;
                }
            }

            if (contador < matrizOriginalDinamica.size()) {
                if (matrizOriginalDinamica.get(posX).get(contador).getValor() > matrizOriginalDinamica.get(posY).get(contador).getValor()) {

                    matrizDinamica.get(0).get(i).setValor(matrizOriginalDinamica.get(posX).get(contador).getValor());
                    matrizDinamica.get(i).get(0).setValor(matrizOriginalDinamica.get(contador).get(posX).getValor());
                    LinkedList<String> valores = matrizOriginalDinamica.get(posX).get(posY).getClusterX().getValores();
                    for (int j = 0; j < matrizOriginalDinamica.get(posX).get(posX).getClusterX().getValores().size(); j++) {
                        valores.add(matrizOriginalDinamica.get(posX).get(posX).getClusterX().getValores().get(i));
                    }

                } else {
                    matrizDinamica.get(0).get(i).setValor(matrizOriginalDinamica.get(posY).get(contador).getValor());
                    matrizDinamica.get(i).get(0).setValor(matrizOriginalDinamica.get(contador).get(posY).getValor());
                }
            }
        }

        return matrizDinamica;
    }

    public double[][] completarNuevoIndividuo(double[][] matrizDestino, double[][] matrizOriginal, int posX, int posY) {
        int contador;
        for (int i = 1; i < matrizDestino.length; i++) {
            contador = i;

            if (contador == posX || contador == posY) {
                contador++;
                if (contador == posX || contador == posY) {
                    contador++;
                }
            }

            if (contador < matrizOriginal.length) {
                if (matrizOriginal[posX][contador] > matrizOriginal[posY][contador]) {

                    matrizDestino[0][i] = matrizOriginal[posX][contador];
                    matrizDestino[i][0] = matrizOriginal[contador][posX];
                } else {
                    matrizDestino[0][i] = matrizOriginal[posY][contador];
                    matrizDestino[i][0] = matrizOriginal[contador][posY];
                }
            }
        }

        System.out.println("Completar Nuevo individuo");
        for (int i = 0; i < matrizDestino.length; i++) {
            for (int j = 0; j < matrizDestino.length; j++) {
                System.out.print("\t" + matrizDestino[i][j]);
            }
            System.out.println("");
        }
        System.out.println("\n\n\n");

        return matrizDestino;
    }

    public double GetDistanciaEuclidea(Individuo in1, Individuo in2) {
        if (in1.equals(in2)) {
            return 0;
        }
        double valor = 0;
        for (int i = 0; i < in1.getListaValores().size(); i++) {
            valor += pow(in1.getListaValores().get(i) - in2.getListaValores().get(i), 2);

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

        System.out.println("Agregar Fila");
        for (int i = 0; i < matrizDestino.length; i++) {
            for (int j = 0; j < matrizDestino.length; j++) {
                System.out.print("\t" + matrizDestino[i][j]);
            }
            System.out.println("");
        }
        System.out.println("\n\n\n");

        return matrizDestino;
    }

    public double[][] EliminarColumnaFila(int fil, int col, double[][] matrizOriginal) {

        double matrizDestino[][] = new double[matrizOriginal.length - 1][matrizOriginal.length - 1];

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

                matrizDestino[p][q] = matrizOriginal[i][j];
                ++q;
            }

            ++p;
        }

        System.out.println("Eliminar Columna");
        for (int i = 0; i < matrizDestino.length; i++) {
            for (int j = 0; j < matrizDestino.length; j++) {
                System.out.print("\t" + matrizDestino[i][j]);
            }
            System.out.println("");
        }
        Write.write("\n\n\n", "Output.txt");
        System.out.println("\n\n\n");

        return matrizDestino;
    }

    //Atributos
    private ContenedorCluster ContenedorClusters;

}
