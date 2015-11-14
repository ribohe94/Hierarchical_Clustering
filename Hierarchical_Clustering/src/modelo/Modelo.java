/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Observable;

public class Modelo extends Observable{

    public Modelo() {
        
    }
    
    public void actualizar(Object evento){
        setChanged();
        notifyObservers(evento);
    }
}
