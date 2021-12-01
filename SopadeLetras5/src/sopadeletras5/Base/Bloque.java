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
    private boolean isSelected;
    
    
    public Bloque(String letra){
        crearBloque();
        this.letra.setText(letra);
        isSelected=false;
    }
    
    public void crearBloque(){
        panel=new StackPane();
        panel.setPrefSize(70, 70);
        panel.setAlignment(Pos.CENTER);
        
        panel.setOnMouseEntered(e->{
            if(panel.isPressed()){
                select();
            }
            
        });
        
        
        cuadro=new Rectangle(70,70);
        cuadro.setFill(Paint.valueOf("white"));
//        cuadro.setStroke(Paint.valueOf("black"));
//        cuadro.setStrokeWidth(2);
        
        letra=new Label();
        letra.setAlignment(Pos.CENTER);
        letra.setTextFill(Paint.valueOf("black"));

        panel.getChildren().addAll(cuadro,letra);
        
        
    }

    public StackPane getPanel() {
        return panel;
    }
    
    public void select(){
        cuadro.setFill(Paint.valueOf("yellow"));
        isSelected=true;
    }
    
    public boolean IsSelected(){
        return isSelected;
    }
    
    public void desactivar(){
        this.panel.setDisable(true);
    }
}
