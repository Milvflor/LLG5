/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author milca & kevin
 */
public class CircularLinkedList<E> implements List<E>{
    
    private CircularNodeList<E> last;
    private int currentSize;
    
    public CircularLinkedList(){
        currentSize = 0;
    }

    public CircularNodeList<E> getLast(){
        return this.last;
    }
    
    public CircularNodeList<E> getFirst(){
        return this.last.getNext();
    }
    
    public void setLast(CircularNodeList<E> last){
        this.last = last;
    }

    @Override
    public boolean addFirst(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addLast(E e) {
        if(e == null){
            return false;
        }
        CircularNodeList<E> new_node = new CircularNodeList<E>(e);
        
        new_node.setNext(last.getNext());
        new_node.setPrevious(last);
        last.getNext().setPrevious(new_node);
        last.setNext(new_node);
        
        last = new_node;
              
        return true;
    }

    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        String string= "";      
        CircularNodeList<E> current = last.getNext();
        int i = 0;

        while(current.getContent() != this.last.getContent()){
            string += "node#" + i + " \t"+current.toString() + "\n";
            current = current.getNext();
            i++;
        }
        
        string += "node#" + i + " \t"+current.toString() + "\n";
        
        return string;
    }
    
}
