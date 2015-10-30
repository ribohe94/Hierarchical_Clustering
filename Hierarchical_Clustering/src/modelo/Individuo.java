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
public class Individuo {

    public Individuo(LinkedList<Double> listaValores) {
        this.listaValores = listaValores;
    }

    public LinkedList<Double> getListaValores() {
        return listaValores;
    }

    public void setListaValores(LinkedList<Double> listaValores) {
        this.listaValores = listaValores;
    }
    
    LinkedList<Double> listaValores;
}
