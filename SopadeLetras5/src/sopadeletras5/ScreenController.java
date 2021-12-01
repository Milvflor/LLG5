/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras5;

import Estructuras.ArrayList;
import Estructuras.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sopadeletras5.Base.Jugador;
import sopadeletras5.Modalidad.Timer;

/**
 *
 * @author Kevin Zhang
 */
public class ScreenController {
    private Scene context;
    private Pane currentPane;
    
    private List<Pane> panes;
    private int height, width;
    
    private static Font TITLEFONT = Font.font("Courier New", FontWeight.BOLD, 40);
    private static Font BUTTONFONT = Font.font("Courier New", FontWeight.BOLD, 20);

    private static String TITLELABELFILL = "0000ff";
    private static String BUTTONLABELFILL = "0000ff";
    private static String BUTTONBORDER = "";
    
    
    
    private TextField txt_fila;
    private TextField txt_columna;
    
    /**
     *
     * @param height
     * @param width
     */
    public ScreenController(int height, int width) {
        panes = new ArrayList<>();
        
        panes.addLast(this.generateMainMenu());
        panes.addLast(this.generateLobby());
        panes.addLast(this.generatePlayground());
        
        this.setCurrentPane(panes.get(0));
        this.context = new Scene(currentPane, height, width);
    }
    
    /**
     *Permite actualizar la escena si esque el panel actual ha sido modificado
     */
    public void refreshScene(){        
        context.setRoot(currentPane);
    }
    
    /**
     *
     */
    public void showScene(){
        
    }
    
    /**
     *Permite cambiar al panel asociado a dicha id
     * @param id id de la posicion del panel a ser puesto en escena.
     */
    public void changeScene(int id){
        this.currentPane = panes.get(id);
        this.refreshScene();
    }

    /**
     *
     * @return
     */
    public Scene getContext() {
        return context;
    }

    /**
     *
     * @param context
     */
    public void setContext(Scene context) {
        this.context = context;
    }

    /**
     *
     * @return
     */
    public Pane getCurrentPane() {
        return currentPane;
    }

    /**
     *
     * @param currentPane
     */
    public void setCurrentPane(Pane currentPane) {
        this.currentPane = currentPane;
    }
    
    private static Button generateButton(String label){
        Button cache = new Button(label);
        cache.setMinSize(300, 80);
        cache.setFont(BUTTONFONT);
        cache.setStyle("-fx-border-color: #"+ BUTTONBORDER + ";-fx-text-fill: #"+BUTTONLABELFILL);

        return cache;
    }
    
    private static Label generateH1(String label){
        Label cache = new Label(label);
        
        cache.setFont(TITLEFONT);
        cache.setStyle("-fx-text-fill: #"+TITLELABELFILL);
        return cache;
    }
        
    private Pane generateMainMenu(){
        VBox main = new VBox();
        
        main.setAlignment(Pos.TOP_CENTER);
        main.setSpacing(40);
        main.setPadding(new Insets(100,0,0,0));
        
        Label title = generateH1("Sopa de Letras");
        
        main.getChildren().add(title);
        
        VBox buttonContainer = new VBox();
        
        buttonContainer.setAlignment(Pos.TOP_CENTER);
        buttonContainer.setSpacing(15);
        
        Button start = generateButton("Iniciar Juego");
        Button leaderboard = generateButton("LeaderBoard");
        Button end = generateButton("Salir");
        
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeScene(1);
            }
        });
        
        buttonContainer.getChildren().add(start);
        buttonContainer.getChildren().add(leaderboard);
        buttonContainer.getChildren().add(end);
        
        main.getChildren().add(buttonContainer);
        
        return main;
    }

    /**
     *
     * @param pane
     * @return
     */
    public int addPane(Pane pane){
        this.panes.addLast(pane);
        
        return this.panes.size() - 1;
    }
    
    
    private Pane generateLobby(){
        VBox root=new VBox();
        root.setAlignment(Pos.CENTER);
        HBox fila1=new HBox();
        HBox fila2=new HBox();
        fila1.setAlignment(Pos.CENTER);
        fila2.setAlignment(Pos.CENTER);
        
        
        
        Label lbl_fila=new Label("filas");
        Label lbl_columna=new Label("columna");
        
        txt_fila=new TextField();
        txt_columna=new TextField();
        
        
        
        Button btn_jugar=new Button("JUGAR");
        
        btn_jugar.setId("btnJugar");
        
        btn_jugar.setOnAction(e->{
            System.out.println("------------------------------------------------------------------");
            System.out.println("filas: "+txt_fila.getText()+"\ncolumnas: "+txt_columna.getText());
            System.out.println("------------------------------------------------------------------");
            changeScene(2);
        });
        
        
        fila1.getChildren().addAll(lbl_fila,txt_fila);
        fila2.getChildren().addAll(lbl_columna,txt_columna);
        
        root.getChildren().addAll(fila1,fila2,btn_jugar);
                
        return root;
    }
    
    
    
    private Pane generatePlayground(){
//            int filas=Integer.parseInt(txt_fila.getText());
//            int columnas=Integer.parseInt(txt_columna.getText());
            
            
             Tablero tablero = new Tablero(7,7);
 
             BorderPane pantalla=new BorderPane();

             VBox lado_derecho=new VBox();
             lado_derecho.setAlignment(Pos.CENTER);
             lado_derecho.setPrefWidth(200);

             tablero.getGrid().setId("tablero");
             tablero.getGrid().setPrefSize(70, 70);
             pantalla.setCenter(tablero.getGrid());
             
             //Temporizador
             Timer tiempo=new Timer(0,5,30);
             tiempo.start();
             

             
             //Jugador
             Jugador player1=new Jugador("Hugo");
             pantalla.setLeft(player1.getScore().getScoreGUI());
             
             
             lado_derecho.getChildren().addAll(player1.getScore().getScoreGUI(),tiempo.getTimerGUI());
             pantalla.setRight(lado_derecho);

        return pantalla;
    }
    
}
