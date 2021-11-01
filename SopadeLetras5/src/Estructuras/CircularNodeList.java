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
    
    public CircularNodeList(E content, CircularNodeList<E> next){
        this.content = content;
        this.next = next;
    }
        
    public CircularNodeList(E content){
        this(content, null);
    }
}
