/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Riccardo
 */
public class Relacion {

    public Relacion() {
    }

    public Relacion(Cluster Cluster1, Cluster Cluster2, double valor) {
        this.ClusterX = Cluster1;
        this.ClusterY = Cluster2;
        this.valor = valor;
    }

    public Cluster getClusterX() {
        return ClusterX;
    }

    public void setClusterX(Cluster Cluster1) {
        this.ClusterX = Cluster1;
    }

    public Cluster getClusterY() {
        return ClusterY;
    }

    public void setClusterY(Cluster Cluster2) {
        this.ClusterY = Cluster2;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    //Atributos
    private Cluster ClusterX;
    private Cluster ClusterY;
    private double valor;
}
