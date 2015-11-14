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
public class Cluster {

    public Cluster() {
    }

    public Cluster(LinkedList<String> valores) {
        this.valores = valores;
    }

    public Cluster(String valor) {
        this.valores.add(valor);
    }

    public LinkedList<String> getValores() {
        return valores;
    }

    public void setValores(LinkedList<String> valores) {
        this.valores = valores;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        valores.stream().forEach((individuo) -> {
            sb.append(" ").append(individuo).append(" ");
        });
        sb.append("}");
        return sb.toString();
    }

    //Atributos
    private LinkedList<String> valores;
}
