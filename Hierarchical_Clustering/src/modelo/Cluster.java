/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.LinkedList;

/**
 *
 * @author c09141a
 */
public class Cluster {

    public Cluster() {
    }

    public Cluster(LinkedList<Individuo> individuos) {
        this.individuos = individuos;
    }

    public LinkedList<Individuo> getIndividuos() {
        return individuos;
    }

    public void setIndividuos(LinkedList<Individuo> individuos) {
        this.individuos = individuos;
    }
    
    //Atributos
    private LinkedList<Individuo> individuos;
}
