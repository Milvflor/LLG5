/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras5.Modalidad;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author milca
 */
public class Score {
    private int puntaje;
    private StackPane scoreGUI;
    
    private Rectangle fondo;
    private Label lbl_titulo;
    private Label lbl_puntos;
    private HBox fila;
    
    
    public Score(){
        this.puntaje=0;
        generarGUI();
    }
    
    
    public void generarGUI(){
       scoreGUI=new StackPane();
       scoreGUI.setStyle("-fx-background-color:white;-fx-font-weight:bold;");
       fila=new HBox();
       fila.setAlignment(Pos.CENTER);
       lbl_titulo=new Label("Puntos ");
       lbl_titulo.setStyle("-fx-text-fill:blue;");
       lbl_puntos=new Label(""+this.puntaje);
       lbl_puntos.setStyle("-fx-text-fill:green;");
       fila.getChildren().addAll(lbl_titulo,lbl_puntos);
       scoreGUI.getChildren().addAll(fila);
    }
    
    public boolean addPoints(String palabra){
        
        if(palabra!=null){
            this.puntaje=this.puntaje+palabra.length();
            this.lbl_puntos.setText(""+this.puntaje);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean losePoints(String palabra){
        if(palabra!=null){
            this.puntaje=this.puntaje-palabra.length();
            this.lbl_puntos.setText(""+this.puntaje);
            return true;
        }else{
            return false;
        }
    }
    
    public StackPane getScoreGUI(){
        return scoreGUI;
    }
}
