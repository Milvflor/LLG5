/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras5.Base;

import Estructuras.ArrayList;
import Estructuras.List;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Usuario
 */
public class Bloque {

    private StackPane panel;
    private Rectangle cuadro;
    private Label letra;
    private String caracter;
    private int timeSelected;

    public static List<String> seleccionados = new ArrayList<>();

    public Bloque(String letra) {
        crearBloque();
        this.letra.setText(letra);
        timeSelected = 0;
        caracter = letra;
    }

    public void crearBloque() {
        panel = new StackPane();
        panel.setPrefSize(70, 70);
        panel.setAlignment(Pos.CENTER);
        
        panel.setOnDragDetected(e -> {
            System.out.println("AAAA");
            if (timeSelected == 0) {
                System.out.println("BBBB");
                seleccionados.addLast(this.caracter);
                timeSelected++;
                select();
            }

        });

        panel.setOnDragEntered(e -> {
            System.out.println("AAAA");
            if (timeSelected == 0) {
                System.out.println("BBBB");
                seleccionados.addLast(this.caracter);
                timeSelected++;
                select();
            }

        });

        panel.setOnDragExited(e -> {
            
        });

        cuadro = new Rectangle(70, 70);
        cuadro.setFill(Paint.valueOf("white"));
//        cuadro.setStroke(Paint.valueOf("black"));
//        cuadro.setStrokeWidth(2);

        letra = new Label();
        letra.setAlignment(Pos.CENTER);
        letra.setTextFill(Paint.valueOf("black"));

        panel.getChildren().addAll(cuadro, letra);

    }

    public StackPane getPanel() {
        return panel;
    }

    public void select() {
        cuadro.setFill(Paint.valueOf("yellow"));
    }

    public void desactivar() {
        this.panel.setDisable(true);
    }
}
