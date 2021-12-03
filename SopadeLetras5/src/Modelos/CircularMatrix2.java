/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Estructuras.ArrayList;
import Estructuras.CircularLinkedList2;
import Estructuras.List;

/**
 *
 * @author Kevin Zhang
 * @param <E>
 */
public class CircularMatrix2<E> {

    private ArrayList<CircularLinkedList2<E>> matrix;
    private Integer columnas;
    private Integer filas;
    private int countf = 0;
    
    /**
     *
     */
    public CircularMatrix2(int f, int c) {
        matrix = new ArrayList<CircularLinkedList2<E>>();
        this.columnas = c;
        this.filas = f;
    }
    
    public void dataInit(E data){
        
        for (int i = 0; i < filas; i++) {
            
            CircularLinkedList2<E> l = new CircularLinkedList2<E>();
            l.full(data, columnas);
            matrix.addLast(l);
        }  
    }
    
    public boolean add(CircularLinkedList2<E> data){
        if (data.size() > columnas || countf > filas) return false;
        matrix.addLast(data);
        countf++;
        return true;
    }
    
    public void desordenar(){
        Integer nveces = (int)(Math.random() * this.getFilas());
        for (int i = 0; i < nveces; i++) {
            Integer posicion = (int)(Math.random() * this.getFilas());
            this.matrix.intercambiar(posicion);
        } 
    }

    public Integer getColumnas() {
        return columnas;
    }

    public Integer getFilas() {
        return filas;
    }

   

    /**
     *
     * @return
     */
    public ArrayList<CircularLinkedList2<E>> getMatrix() {
        return this.matrix;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < filas; i++) {
            
            string += "\n|\t" + matrix.get(i).toString() + "\t|\n";
            string += new String(new char[columnas*19]).replace("\0", "-");
            string += "\n";
           
        }
        
        
        return string;
    }
    
    /**
     * Este metodo permite añadir un valor en una posicion (i,j)
     * @param col indice de la columna
     * @param row indice de la fila 
     * @param data dato a insertar
     */
    public void put(int col, int row, E data){
        this.matrix.get(col).set(row, data);
    }

    public static void main(String[] args) {
        CircularMatrix2 mat = new CircularMatrix2(4, 6);
        
       
        
        System.out.println(mat.toString());
    }
}
