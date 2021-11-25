/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author kazp_
 */
public interface Array<E> {  
    public abstract double sortAll();
    public abstract void fillRandom();
    public abstract int[] binarySearch(E element);
}
