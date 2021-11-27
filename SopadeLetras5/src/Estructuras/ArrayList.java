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
public class ArrayList<E> implements List<E> {
    
    // arreglo de elementos
    private int capacity = 100;
    private E[] elements = null;
    private int effectiveSize = 0;
    
    /**
     *
     */
    public ArrayList(){
        this.elements = (E[]) (new Object[capacity]);
        this.effectiveSize = 0;
    }
    
    private boolean isFull(){
        return this.effectiveSize == this.capacity;
    }
    
    private void addCapacity(){
        E[] tmp = (E[]) new Object[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            tmp[i] = elements[i];
        }
        elements = tmp;
        capacity = capacity * 2;
    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public boolean addFirst(E e) {
        if(e == null){
            return false;
        }else if(isEmpty()){
            elements[effectiveSize ++] = e;
            return true;
        }else if (capacity == effectiveSize){
            addCapacity();
        }        
        for(int i = effectiveSize -1 ; i >= 0; i-- ){
            elements[i+1] = elements[i];
        } 
        elements [0] = e;
        effectiveSize++;
        return true;   
    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public boolean addLast(E e) {
        if(e == null){
            return false;
        }else if (capacity == effectiveSize){
            addCapacity();
        }
        elements [effectiveSize ++] = e;
        //effectiveSize++;
        return true;   
    }

    /**
     *
     * @return
     */
    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {
        return this.effectiveSize;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.effectiveSize == 0;
    }

    /**
     *
     */
    @Override
    public void clear() {
        this.effectiveSize = 0;
    }

    /**
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        if(index > this.size()){
            return null;
        }
        
        return elements[index];
    }

    /**
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public boolean set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
