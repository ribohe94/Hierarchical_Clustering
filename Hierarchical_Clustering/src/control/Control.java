/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Observer;
import modelo.Modelo;

/**
 *
 * @author c09141a
 */
public class Control {

    public Control(Modelo nuevosDatos) {
        datos = nuevosDatos;
    }

    public Control() {
        this(new Modelo());
    }
    
    public void registrar(Observer nuevoObservador) {
        datos.addObserver(nuevoObservador);
    }

    public void actualizar(Object evento) {
        datos.actualizar(evento);
    }
    
    //Atributos
    private Modelo datos;
}
