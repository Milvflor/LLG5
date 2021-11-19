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

    private CircularLinkedList<CircularLinkedList<E>> matrix;

    public CircularMatrix() {
        matrix = new CircularLinkedList<CircularLinkedList<E>>();
    }

    public void zeros(int col_size, int row_size, E default_value) {
        for (int i = 0; i < col_size; i++) {
            CircularLinkedList<E> new_row = new CircularLinkedList<E>();
            for (int j = 0; j < row_size; j++) {
                if (j == 0) {
                    new_row.setLast(new CircularNodeList<E>(default_value));
                } else {
                    new_row.addLast(default_value);
                }            }
            if (i == 0) {
                matrix.setLast(new CircularNodeList<CircularLinkedList<E>>(new_row));
            } else {
                matrix.addLast(new_row);
            }
        }
    }

    public CircularLinkedList<CircularLinkedList<E>> getMatrix() {
        return this.matrix;
    }

    @Override
    public String toString() {
        String string = "\n    |";
        for (int i = 0; i < matrix.getLast().getContent().getCurrentSize(); i++) {
            string += "    ";
            string += (char) ('A' + i);
            string += "    |";
        }
        string += "\n";
        CircularNodeList<CircularLinkedList<E>> current_pointer = matrix.getFirst();
        for (int i = 0; i < matrix.getCurrentSize(); i++) {
            string += "----+";
            for (int j = 0; j < matrix.getLast().getContent().getCurrentSize(); j++) {
                string += "---------+";
            }
            string += "\n";
            string += "  " + (i + 1) + " |";
            CircularNodeList<E> current_data_pointer = current_pointer.getContent().getFirst();
        
            for (int j = 0; j < matrix.getLast().getContent().getCurrentSize(); j++) {
                if (current_data_pointer.getContent().toString().length() < 10) {
                    int spaces = (9 - current_data_pointer.getContent().toString().length()) / 2;
                    for (int k = 0; k < spaces; k++) {
                        string += " ";
                    }
                    string += current_data_pointer.getContent();
                    for (int k = 0; k < (9 - current_data_pointer.getContent().toString().length()) - spaces; k++) {
                        string += " ";
                    }
                } else {
                    //System.out.println("HEREE");
                    string += String.valueOf(current_data_pointer.getContent()).substring(0, 9) + "A\n";
                }
                string += "|";
                current_data_pointer = current_data_pointer.getNext();
            }
            
            current_pointer = current_pointer.getNext();
            string += "\n";
        }
        return string;
    }
    
    public void setValue(int col_idx, int row_idx, E value){
        CircularNodeList<CircularLinkedList<E>> col_pointer = matrix.getFirst();
        for(int i = 0; i < col_idx; i++){
            col_pointer = col_pointer.getNext(); 
        }
        CircularNodeList<E> row_pointer = col_pointer.getContent().getFirst();
        for(int i = 0; i < row_idx; i++){
            row_pointer = row_pointer.getNext();
        }
        
        row_pointer.setContent(value);
    }
}
