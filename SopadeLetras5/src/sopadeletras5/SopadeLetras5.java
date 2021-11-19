/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package sopadeletras5;

import Estructuras.CircularLinkedList;
import Estructuras.CircularMatrix;
import Estructuras.CircularNodeList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author milca
 */
public class SopadeLetras5 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        CircularMatrix<Integer> matrix = new CircularMatrix<Integer>();
        matrix.zeros(4, 5, 0);
        
        matrix.setValue(0, 0, 1);
        matrix.setValue(0, 1, 2);
        matrix.setValue(1, 0, 3);
        matrix.setValue(1, 1, 4);
        CircularNodeList<CircularLinkedList<Integer>> puntero_vertical = matrix.getMatrix().getFirst();       
        
        System.out.println(matrix);
        
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
