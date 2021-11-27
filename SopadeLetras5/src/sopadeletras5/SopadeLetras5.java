/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package sopadeletras5;

import Estructuras.CircularLinkedList;
import Estructuras.CircularMatrix;
import Estructuras.CircularNodeList;
import Estructuras.List;
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

    List<List<Character>> matrix;
    ScreenController screenController;

    @Override
    public void start(Stage primaryStage) {
                
        Tablero tablero = new Tablero(5,4);
        
        tablero.getMatrix().put(1,2,'Z');
        System.out.println(tablero.getMatrix());
        
        Button btn = new Button();
        btn.setText("INICIAR");
        btn.setOnAction(e->{
            Sistema sistema=new Sistema();
            primaryStage.setScene(new Scene(sistema.getRoot(),500,500));
        });
        
        StackPane root = new StackPane();
//        root.getChildren().add(tablero.getGrid());
        
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 900, 600);
        


     

//        tablero.getMatrix().put(1,2,'Z');s
//        System.out.println(tablero.getMatrix());
//        
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(tablero.getGrid());
//        
        screenController = new ScreenController(900,600);

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
