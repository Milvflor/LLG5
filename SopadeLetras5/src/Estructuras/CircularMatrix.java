/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author kazp_
 */
public class CircularMatrix<E> {

    private List<List<E>> matrix = new CircularLinkedList<>();
    
    public CircularMatrix() {
        matrix = new CircularLinkedList<>();
    }

    public void zeros(int col_size, int row_size, E default_value) {    
        List<E> new_lista;
        for(int i = 0; i < col_size; i++){
            new_lista = new CircularLinkedList<>();
            
            for(int j = 0; j < row_size; j++ ){
                new_lista.addLast(default_value);
            }
            
            matrix.addLast(new_lista);
        }        
    }
    
    public List<List<E>> getMatrix() {
        return this.matrix;
    }

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
    
    public void put(int col, int row, E data){
        this.matrix.get(col).set(row, data);
    }
}
