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

    public Individuo() {
        listaValores = new LinkedList<Double>();
    }

    public Individuo(LinkedList<Double> listaValores) {
        this.listaValores = listaValores;
    }

    public LinkedList<Double> getListaValores() {
        return listaValores;
    }

    public void setListaValores(LinkedList<Double> listaValores) {
        this.listaValores = listaValores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Atributos
    private String nombre;
    private LinkedList<Double> listaValores;
}
