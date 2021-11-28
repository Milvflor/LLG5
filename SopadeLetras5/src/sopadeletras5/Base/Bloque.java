/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras5.Base;

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
    
    
    public Bloque(String letra){
        crearBloque();
        this.letra.setText(letra);
    }
    
    public void crearBloque(){
        panel=new StackPane();
        panel.setPrefSize(50, 50);
        panel.setAlignment(Pos.CENTER);
        
        panel.setOnMouseEntered(e->{
            pintar();
        });
        
        
        cuadro=new Rectangle(50,50);
        cuadro.setFill(Paint.valueOf("white"));
//        cuadro.setStroke(Paint.valueOf("black"));
//        cuadro.setStrokeWidth(2);
        
        letra=new Label();
        letra.setTextFill(Paint.valueOf("black"));
        letra.setStyle("-fx-font-size: 11px;");
        
        panel.getChildren().addAll(cuadro,letra);
        
        
    }

    public StackPane getPanel() {
        return panel;
    }
    
    public void pintar(){
        cuadro.setFill(Paint.valueOf("yellow"));
    }
}
