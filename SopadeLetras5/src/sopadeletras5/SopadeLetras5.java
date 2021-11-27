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

        Tablero tablero = new Tablero(5, 4);

        screenController = new ScreenController(900,600);

        primaryStage.setTitle("Sopa de Letras");
        primaryStage.setScene(screenController.getContext());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
