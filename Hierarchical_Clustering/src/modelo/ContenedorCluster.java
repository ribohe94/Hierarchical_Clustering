/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.LinkedList;

/**
 *
 * @author Riccardo
 */
public class ContenedorCluster {

    public ContenedorCluster() {
    }

    public ContenedorCluster(LinkedList<ContenedorIndividuos> clusters) {
        this.clusters = clusters;
    }

    public LinkedList<ContenedorIndividuos> getClusters() {
        return clusters;
    }

    public void setClusters(LinkedList<ContenedorIndividuos> clusters) {
        this.clusters = clusters;
    }
    
    //Atributos
    private LinkedList<ContenedorIndividuos> clusters;
}
