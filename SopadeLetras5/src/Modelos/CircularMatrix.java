/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Estructuras.ArrayList;
import Estructuras.CircularLinkedList;
import Estructuras.List;

/**
 *
 * @author Kevin Zhang
 * @param <E>
 */
public class CircularMatrix<E> {

    private List<List<E>> matrix = null;
    private int cols, rows;
    private int countf;

    /**
     *
     */
    public CircularMatrix() {
        matrix = new CircularLinkedList<>();
    }

    public CircularMatrix(int cols, int rows) {
        matrix = new ArrayList<>();
        this.cols = cols;
        this.rows = rows;
    }

    public void zerosInit(E data) {
        for (int i = 0; i < this.rows; i++) {

            CircularLinkedList<E> l = new CircularLinkedList<E>();
            l.full(data, this.cols);
            matrix.addLast(l);
        }

    }

    public boolean add(CircularLinkedList<E> data) {
        if (data.size() > this.cols || countf > this.rows) {
            return false;
        }
        matrix.addLast(data);
        countf++;
        return true;
    }

    public void scramble() {
        int nveces = (int) (Math.random() * this.cols);
        for (int i = 0; i < nveces; i++) {
            int posicion = (int) (Math.random() * this.rows);
            this.matrix.replace(posicion);
        }
    }

    /**
     *
     * @return
     */
    public List<List<E>> getMatrix() {
        return this.matrix;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String string = "\n    |";
        for (int i = 0; i < matrix.size(); i++) {
            string += "    ";
            string += (char) ('A' + i);
            string += "    |";
        }
        string += "\n";
        List<E> current_pointer = matrix.get(0);

        for (int i = 0; i < current_pointer.size(); i++) {
            string += "----+";
            for (int j = 0; j < matrix.size(); j++) {
                string += "---------+";
            }
            string += "\n";
            string += "  " + (i + 1) + " |";
            E current_data_pointer;
            for (int j = 0; j < matrix.size(); j++) {
                current_data_pointer = matrix.get(j).get(i);
                if (current_data_pointer.toString().length() < 10) {
                    int spaces = (9 - current_data_pointer.toString().length()) / 2;
                    for (int k = 0; k < spaces; k++) {
                        string += " ";
                    }
                    string += current_data_pointer;
                    for (int k = 0; k < (9 - current_data_pointer.toString().length()) - spaces; k++) {
                        string += " ";
                    }
                } else {
                    string += String.valueOf(current_data_pointer).substring(0, 9);
                }
                string += "|";
            }

            string += "\n";
        }
        return string;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCountf() {
        return countf;
    }

    public void setCountf(int countf) {
        this.countf = countf;
    }

    /**
     * Este metodo permite añadir un valor en una posicion (i,j)
     *
     * @param col indice de la columna
     * @param row indice de la fila
     * @param data dato a insertar
     */
    public void put(int col, int row, E data) {
        this.matrix.get(col).set(row, data);
    }
}
