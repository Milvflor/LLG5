/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras5;

import Modelos.CircularMatrix;
import Estructuras.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author milca
 */
public class Tablero {

    private CircularMatrix matrix;
    private int col, row;
    
    GridPane grid;   

    public Tablero(int col, int row) {
        this.col = col;
        this.row = row;
        matrix = new CircularMatrix<Character>();
        matrix.zeros(col, row, 'D');
        
        grid = this.drawBoard();
    }

    private GridPane drawBoard() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(2);
        grid.setVgap(2);
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.println(matrix.getMatrix().get(i));
                Button cell = new Button(matrix.getMatrix().get(i).toString());
                grid.add(cell, i, j,1,1);
            }
        }
        return grid;

    }

    public CircularMatrix getMatrix() {
        return matrix;
    }

    public void setMatrix(CircularMatrix matrix) {
        this.matrix = matrix;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public GridPane getGrid() {
        return grid;
    }

    public void setGrid(GridPane grid) {
        this.grid = grid;
    }

}
