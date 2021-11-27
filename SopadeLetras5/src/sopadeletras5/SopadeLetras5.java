/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package sopadeletras5;

import Estructuras.CircularLinkedList;
import Modelos.CircularMatrix;
import Estructuras.CircularNodeList;
import Estructuras.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
        
        Label titulo=new Label("SOPA DE LETRAS");
        
        
        
        Button btn = new Button();
        btn.setText("INICIAR");
        btn.setOnAction(e->{
            Sistema sistema=new Sistema();
            Scene escena1=new Scene(sistema.getRoot(),500,500);
            escena1.getStylesheets().add("/css/estiloInicio.css");
            primaryStage.setScene(escena1);
        });
        
        StackPane root = new StackPane();
//        root.getChildren().add(tablero.getGrid());
        

        VBox columna=new VBox();
        columna.setAlignment(Pos.CENTER);
        columna.getChildren().addAll(titulo,btn);
        root.getChildren().add(columna);
        
        Scene scene = new Scene(root, 900, 600);
       
        


     

        screenController = new ScreenController(900,600);

        primaryStage.setTitle("SOPA DE LETRAS LGG5");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}
