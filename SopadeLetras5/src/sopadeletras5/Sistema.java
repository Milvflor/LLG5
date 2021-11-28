/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras5;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sopadeletras5.Base.Bloque;
import sopadeletras5.Modalidad.Timer;

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
    
    /**
     *
     */
    public Sistema(){
        generarVentana();
    }
    
    /**
     *
     */
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
        btn_jugar.setId("btnJugar");
        
        btn_jugar.setOnAction(e->{
            System.out.println("------------------------------------------------------------------");
            System.out.println("filas: "+txt_fila.getText()+"\ncolumnas: "+txt_columna.getText());
            
            
            
            //GENERAR EL TABLERO
             Tablero tablero = new Tablero(5,4);
        
             tablero.getMatrix().put(1,2,'Z');
             System.out.println(tablero.getMatrix());
             
             BorderPane pantalla=new BorderPane();
             tablero.getGrid().setId("tablero");
             pantalla.setCenter(tablero.getGrid());
             
             Timer tiempo=new Timer(0,0,30);
             tiempo.start();
             
             pantalla.setRight(tiempo.getTimerGUI());
             
             btn_jugar.getScene().setRoot(pantalla);       
        });
        
        fila1.getChildren().addAll(lbl_fila,txt_fila);
        fila2.getChildren().addAll(lbl_columna,txt_columna);

        root.getChildren().addAll(fila1,fila2,btn_jugar);
    }
    
    /**
     *
     * @return
     */
    public VBox getRoot(){
        return root;
    }

    /**
     *
     * @return
     */
    public TextField getTxt_fila() {
        return txt_fila;
    }

    /**
     *
     * @return
     */
    public TextField getTxt_columna() {
        return txt_columna;
    }
    
    
}
