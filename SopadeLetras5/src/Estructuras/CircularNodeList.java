/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author milca & kevin
 */
public class CircularNodeList <E> {
    private E content;
    
    private CircularNodeList<E> next;
    private CircularNodeList<E> previous;
    
    public CircularNodeList(E content, CircularNodeList<E> next, CircularNodeList<E> previous){
        this.content = content;
        this.next = next;
        this.previous = previous;
    }
        
    public CircularNodeList(E content){
        this.content = content;
        this.next = this;
        this.previous = this;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public CircularNodeList<E> getNext() {
        return next;
    }

    public void setNext(CircularNodeList<E> next) {
        this.next = next;
    }

    public CircularNodeList<E> getPrevious() {
        return previous;
    }

    public void setPrevious(CircularNodeList<E> previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        
        return content.toString();
    }
    
    
}
