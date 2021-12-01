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
import sopadeletras5.Base.Bloque;

/**
 *
 * @author milca
 */
public class Tablero {

    private CircularMatrix<Character> matrix;
    private int col, row;
    
    GridPane grid;   

    /**
     *
     * @param col
     * @param row
     */
    public Tablero(int col, int row) {
        this.col = col;
        this.row = row;       
        
        matrix = new CircularMatrix<Character>(col, row);
        matrix.zerosInit('e');
        
        grid = this.drawBoard();
    }

    private GridPane drawBoard() {
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(2);
        grid.setVgap(2);
        for (int i = 0; i < col - 1; i++) {
            for (int j = 0; j < row - 1; j++) {
                Bloque cell = new Bloque(matrix.getMatrix().get(i).get(j).toString());
                grid.add(cell.getPanel(), i, j,1,1);
            }
        }
        return grid;

    }

    /**
     *
     * @return
     */
    public CircularMatrix getMatrix() {
        return matrix;
    }

    /**
     *
     * @param matrix
     */
    public void setMatrix(CircularMatrix matrix) {
        this.matrix = matrix;
    }

    /**
     *
     * @return
     */
    public int getCol() {
        return col;
    }

    /**
     *
     * @param col
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     *
     * @return
     */
    public int getRow() {
        return row;
    }

    /**
     *
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     *
     * @return
     */
    public GridPane getGrid() {
        return grid;
    }

    /**
     *
     * @param grid
     */
    public void setGrid(GridPane grid) {
        this.grid = grid;
    }

}
