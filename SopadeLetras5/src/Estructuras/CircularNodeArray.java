/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author milca & kevin
 */
public class CircularNodeArray <E> {
    private E content;
    private CircularNodeArray<E> next;
    private CircularNodeArray<E> previous;
    private CircularNodeArray<E> top;
    private CircularNodeArray<E> bottom;
    
    public CircularNodeArray(E content, CircularNodeArray<E> next, CircularNodeArray<E> previous, CircularNodeArray<E> top, CircularNodeArray<E> bottom){
        this.content = content;
        this.next = next;
        this.previous = previous;
        this.top = top;
        this.bottom = bottom;
    }
        
    public CircularNodeArray(E content){
        this.content = content;
        this.next = this;
        this.previous = this;
        this.top = this;
        this.bottom = this;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public CircularNodeArray<E> getNext() {
        return next;
    }

    public void setNext(CircularNodeArray<E> next) {
        this.next = next;
    }

    public CircularNodeArray<E> getPrevious() {
        return previous;
    }

    public void setPrevious(CircularNodeArray<E> previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "content=" + content;
    }
    
    
}
