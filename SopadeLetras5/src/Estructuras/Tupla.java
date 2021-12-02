/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author milca
 */
public class Tupla<E, T> {
    
    T izquierda;
    E derecha;
    
    
    public Tupla(T i, E d){
        this.izquierda = i;
        this.derecha = d;
        
    }
    
    @Override
    public String toString(){
        String s= "";
        s += "("+ this.izquierda + ", " + this.derecha + ")";       
        return s;
    }
    
    /*Retorna verdadero si la data E de la derecha son iguales.
    */
    public boolean sameD(Tupla a){
        return a.derecha == this.derecha;
    }

    public E getDerecha() {
        return derecha;
    }

    public void setDerecha(E derecha) {
        this.derecha = derecha;
    }

    public T getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(T izquierda) {
        this.izquierda = izquierda;
    }
    
    
    
    
}
