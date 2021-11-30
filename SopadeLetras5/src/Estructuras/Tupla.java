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
    
    E derecha;
    T izquierda;
    
    public Tupla(E d, T i){
        this.derecha = d;
        this.izquierda = i;
    }
    
    @Override
    public String toString(){
        String s= "";
        s += "("+ this.derecha + ", " + this.izquierda + ")";       
        return s;
    }
    
    /*Retorna verdadero si la data E de la derecha son iguales.
    */
    public boolean sameD(Tupla a){
        return a.derecha == this.derecha;
    }
    
    
}
