/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.Iterator;

/**
 *
 * @author milca & kevin
 * @param <E>
 */
public class CircularLinkedList<E> implements List<E>, Iterable {

    private CircularNodeList<E> last;
    private CircularNodeList<E> currentPointer;
    private int currentSize;

    /**
     *
     */
    public CircularLinkedList() {
        currentSize = 0;
        last = null;
        currentPointer = null;
    }

    /**
     *
     * @return
     */
    public int getCurrentSize() {
        return this.currentSize;
    }

    /**
     *
     * @return
     */
    public CircularNodeList<E> getLast() {
        return this.last;
    }

    /**
     *
     * @return
     */
    public CircularNodeList<E> getFirst() {
        return this.last.getNext();
    }

    /**
     *
     * @param last
     */
    public void setLast(CircularNodeList<E> last) {
        this.last = last;
        this.last.setNext(this.last);
        this.last.setPrevious(this.last);
    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public boolean addFirst(E e) {

        if (e == null) {
            return false;
        }

        CircularNodeList<E> new_elem = new CircularNodeList<E>(e);
        if (this.last != null) {
            this.last.getNext().setPrevious(new_elem);
            this.last.setNext(new_elem);
        } else {
            this.setLast(new_elem);
        }
        this.currentSize++;
        return true;
    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public boolean addLast(E e) {
        if (e == null) {
            return false;
        }

        CircularNodeList<E> new_node = new CircularNodeList<E>(e);

        if (this.last != null) {

            new_node.setNext(last.getNext());
            new_node.setPrevious(last);
            last.getNext().setPrevious(new_node);
            last.setNext(new_node);

            last = new_node;
        } else {
            this.setLast(new_node);
        }
        this.currentSize++;
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
        return this.currentSize;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     */
    @Override
    public void clear() {
        this.last = null; //To change body of generated methods, choose Tools | Templates.
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
        if (index < 0 || index > this.currentSize) {
            return null;
        }

        CircularNodeList<E> pointer = this.getFirst();

        for (int i = 0; i < index; i++) {
            pointer = pointer.getNext();
        }
        return pointer.getContent();
    }

    /**
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public boolean set(int index, E element) {
        if (index < 0 || index > this.currentSize) {
            return false;
        }

        CircularNodeList<E> pointer = this.getFirst();

        for (int i = 0; i < index; i++) {
            pointer = pointer.getNext();
        }
        pointer.setContent(element);
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String string = "";
        CircularNodeList<E> current = last.getNext();
        int i = 0;

        while (i < currentSize - 1) {
            string += "\t" + current.toString() + "\t";
            current = current.getNext();
            i++;
        }

        string += "\t" + current.toString() + "\t";

        return string;
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator iterator() {
        Iterator<E> it = new Iterator<E>() {
            CircularNodeList<E> n = last.getNext();
            int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < currentSize;
            }

            @Override
            public E next() {
                E r = n.getContent();
                n = n.getNext();
                cursor++;
                return r;
            }
        };
        return it;
    }

    public void move(Integer n) {
        CircularNodeList<E> current = last;

        for (int i = 1; i < n; i++) {
            this.last.setNext(current.getPrevious());
            current = this.last.getNext();
        }

    }

    public void full(E data, int lenght) {

        for (int i = 0; i < lenght; i++) {
            this.addLast(data);
        }

    }

    public static void main(String[] args) {

        CircularLinkedList<Integer> l = new CircularLinkedList();

//        l.addLast("1");
//        l.addLast("2");
//        l.addLast("3");
//        l.addLast("4");
//        l.addLast("5");
//        l.addLast("6");
//        l.addLast("7");
//        l.desplazar(3);
        l.full(0, 5);
        System.out.println(l.toString());
    }

    @Override
    public void replace(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
