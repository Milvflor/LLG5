/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Kevin Zhang
 * @param <E>
 */
public interface Array<E> {  

    /**
     *
     * @return
     */
    public abstract double sortAll();

    /**
     *
     */
    public abstract void fillRandom();

    /**
     *
     * @param element
     * @return
     */
    public abstract int[] binarySearch(E element);
}
