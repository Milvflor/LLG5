/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras5;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author milca
 */
public class Sistema {
    ScreenController screenController;
    private int filas;
    private int columnas;
    
    private VBox root;
    private HBox fila1;
    private HBox fila2;
    
    private TextField txt_fila;
    private TextField txt_columna;
    
    private Label lbl_fila;
    private Label lbl_columna;
    
    private Button btn_jugar;
    
    
    public Sistema(){
        generarVentana();
    }
    
    public void generarVentana(){
        root=new VBox();
        root.setAlignment(Pos.CENTER);
        fila1=new HBox();
        fila2=new HBox();
        
        
        
        lbl_fila=new Label("filas");
        lbl_columna=new Label("columnas");
        
        txt_fila=new TextField();
        txt_fila.setPrefWidth(50);
        txt_columna=new TextField();
        txt_columna.setPrefWidth(50);
        
        btn_jugar=new Button("JUGAR");
        
        fila1.getChildren().addAll(lbl_fila,txt_fila);
        fila2.getChildren().addAll(lbl_columna,txt_columna);
        
        root.getChildren().addAll(fila1,fila2,btn_jugar);
    }
    
    public VBox getRoot(){
        return root;
    }

    public TextField getTxt_fila() {
        return txt_fila;
    }

    public TextField getTxt_columna() {
        return txt_columna;
    }
    
    
}
