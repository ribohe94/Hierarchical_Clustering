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
public class ContenedorIndividuos {

    public ContenedorIndividuos() {
        individuos = new LinkedList<>();
    }

    public ContenedorIndividuos(LinkedList<Individuo> individuos) {
        this.individuos = individuos;
    }

    public ContenedorIndividuos(Individuo individuo) {
        this.individuos.add(individuo);
    }
    
    public LinkedList<Individuo> getIndividuos() {
        return individuos;
    }

    public void setIndividuos(LinkedList<Individuo> individuos) {
        this.individuos = individuos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        individuos.stream().forEach((individuo) -> {
            sb.append(" ").append(individuo.getNombre()).append(" ");
        });
        sb.append("}");
        return sb.toString();
    }

    //Atributos
    private LinkedList<Individuo> individuos;
}
