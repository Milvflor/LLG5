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
                System.out.println(j);
                if (j == 0) {
                    new_row.setLast(new CircularNodeList<E>(default_value));
                } else {
                    new_row.addLast(default_value);
                }
                System.out.println(new_row);
            }
            if (i == 0) {
                matrix.setLast(new CircularNodeList<CircularLinkedList<E>>(new_row));
            } else {
                matrix.addLast(new_row);
            }
            System.out.println("row: "+ new_row.getLast().getContent());
        }
        
        System.out.println("col_size: " + matrix.getCurrentSize());
        System.out.println("row_size: " + matrix.getLast().getContent().getCurrentSize());
        
    }

    public CircularLinkedList<CircularLinkedList<E>> getMatrix() {
        return this.matrix;
    }

    @Override
    public String toString() {
        String string = "";
        
        
        CircularNodeList<CircularLinkedList<E>> last_col = matrix.getLast();
        CircularNodeList<CircularLinkedList<E>> current_col = last_col.getNext();
        int i = 0;
        System.out.println(current_col);
        while (current_col.getContent() != last_col.getContent()) {
            string += "col#"  + i + current_col.getContent().toString() + "\n";
            current_col = current_col.getNext();
            i++;
        }

        string += "col#" + i + current_col.toString() + "\n";

        return string;
    }

}
