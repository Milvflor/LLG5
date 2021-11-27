/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author milca & kevin
 * @param <E>
 */
public class CircularNodeList <E> {
    private E content;
    
    private CircularNodeList<E> next;
    private CircularNodeList<E> previous;
    
    /**
     *
     * @param content
     * @param next
     * @param previous
     */
    public CircularNodeList(E content, CircularNodeList<E> next, CircularNodeList<E> previous){
        this.content = content;
        this.next = next;
        this.previous = previous;
    }
        
    /**
     *
     * @param content
     */
    public CircularNodeList(E content){
        this.content = content;
        this.next = this;
        this.previous = this;
    }

    /**
     *
     * @return
     */
    public E getContent() {
        return content;
    }

    /**
     *
     * @param content
     */
    public void setContent(E content) {
        this.content = content;
    }

    /**
     *
     * @return
     */
    public CircularNodeList<E> getNext() {
        return next;
    }

    /**
     *
     * @param next
     */
    public void setNext(CircularNodeList<E> next) {
        this.next = next;
    }

    /**
     *
     * @return
     */
    public CircularNodeList<E> getPrevious() {
        return previous;
    }

    /**
     *
     * @param previous
     */
    public void setPrevious(CircularNodeList<E> previous) {
        this.previous = previous;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        
        return content.toString();
    }
    
    
}
