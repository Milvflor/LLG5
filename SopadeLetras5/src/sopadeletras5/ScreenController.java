/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras5;

import Estructuras.ArrayList;
import Estructuras.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ComboBox categoria;

    /**
     *
     * @param height
     * @param width
     */
    public ScreenController(int height, int width) {
        panes = new ArrayList<>();

        panes.addLast(this.generateMainMenu());
        panes.addLast(this.generateLobby());
        panes.addLast(this.generarLeaderBoard());

        this.setCurrentPane(panes.get(0));
        this.context = new Scene(currentPane, height, width);
    }

    /**
     * Permite actualizar la escena si esque el panel actual ha sido modificado
     */
    public void refreshScene() {
        context.setRoot(currentPane);
    }

    /**
     *
     */
    public void showScene() {

    }

    /**
     * Permite cambiar al panel asociado a dicha id
     *
     * @param id id de la posicion del panel a ser puesto en escena.
     */
    public void changeScene(int id) {
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

    private static Button generateButton(String label) {
        Button cache = new Button(label);
        cache.setMinSize(300, 80);
        cache.setFont(BUTTONFONT);
        cache.setStyle("-fx-border-color: #" + BUTTONBORDER + ";-fx-text-fill: #" + BUTTONLABELFILL);

        return cache;
    }

    private static Label generateH1(String label) {
        Label cache = new Label(label);

        cache.setFont(TITLEFONT);
        cache.setStyle("-fx-text-fill: #" + TITLELABELFILL);
        return cache;
    }

    private Pane generateMainMenu() {
        VBox main = new VBox();

        main.setAlignment(Pos.TOP_CENTER);
        main.setSpacing(40);
        main.setPadding(new Insets(100, 0, 0, 0));

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

        leaderboard.setOnAction(m -> {
            changeScene(2);
        });

        end.setOnAction(a -> {
            System.exit(0);
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
    public int addPane(Pane pane) {
        this.panes.addLast(pane);

        return this.panes.size() - 1;
    }

    private Pane generateLobby() {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        
        VBox espacio = new VBox();
        espacio.setPrefHeight(100);
        HBox fila2 = new HBox();
        
        HBox fila1 = new HBox();
        fila1.setAlignment(Pos.CENTER);
        fila1.setPadding(new Insets(20, 20, 20, 20));
        fila1.setSpacing(20);
        
        fila2.setAlignment(Pos.CENTER);
        fila2.setSpacing(20);

        HBox filaCat = new HBox();
        filaCat.setAlignment(Pos.CENTER);
        filaCat.setPadding(new Insets(20, 20, 20, 20));
        filaCat.setSpacing(20);
        
        Label seleccionarCategoria = new Label("Seleccionar Categoria");

        ObservableList<String> options
                = FXCollections.observableArrayList(
                        "Comida",
                        "Plantas"
                );
        categoria = new ComboBox(options);

        filaCat.getChildren().addAll(seleccionarCategoria, categoria);
        
        Label titulo = generateH1("Dimensiones del tablero");;

        Label lbl_fila = new Label("Filas");
        Label lbl_columna = new Label("Columnas");

        txt_fila = new TextField();
        txt_fila.setPrefWidth(50);

        txt_columna = new TextField();
        txt_columna.setPrefWidth(50);

        Button btn_jugar = generateButton("Jugar");

        btn_jugar.setId("btnJugar");

        btn_jugar.setOnAction(e -> {
            System.out.println("------------------------------------------------------------------");
            System.out.println("filas: " + txt_fila.getText() + "\ncolumnas: " + txt_columna.getText());
            System.out.println("------------------------------------------------------------------");
            try {

                panes.addLast(this.generatePlayground());

                changeScene(3);
            } catch (Exception m) {
                Alert alerta = new Alert(AlertType.ERROR);
                alerta.show();
            }
        });

        fila1.getChildren().addAll(lbl_fila, txt_fila);
        fila2.getChildren().addAll(lbl_columna, txt_columna);
        
        root.setStyle("-fx-font-weight:bold;-fx-font-size:20px;");
        root.getChildren().addAll(titulo,filaCat ,fila1, fila2, espacio, btn_jugar);

        return root;
    }

    private Pane generatePlayground() {
        BorderPane pantalla = new BorderPane();

        ImageView imagen = new ImageView("/recursos/fondo.jpeg");
        imagen.setEffect(new GaussianBlur(5));
        imagen.fitWidthProperty().bind(context.widthProperty());
        imagen.fitHeightProperty().bind(context.heightProperty());

        pantalla.getChildren().add(imagen);

        int filas = Integer.parseInt(txt_fila.getText());
        int columnas = Integer.parseInt(txt_columna.getText());
        
        String catSelec = categoria.getValue().toString();
        String cat = "";
        switch(catSelec){
            case "Comida":
                cat = "food";
                break;
            case "Plantas":
                cat = "plant";
                break;
            default:
                cat = "random";
                break;
        }
        
        Tablero tablero = new Tablero(columnas, filas, cat);
        tablero.getTabla();
        System.out.println(tablero.getTabla().getAlmacenadas());
        pantalla.setStyle("-fx-font-size:20px;");

        VBox lado_derecho = new VBox();
        lado_derecho.setAlignment(Pos.CENTER);
        lado_derecho.setPrefWidth(200);

        tablero.getGrid().setId("tablero");
        tablero.getGrid().setPrefSize(70, 70);
        pantalla.setCenter(tablero.getGrid());

        //Temporizador
        Timer tiempo = new Timer(0, 5, 30);
        tiempo.start();

        //Jugador
        Jugador player1 = new Jugador("Hugo");
        pantalla.setLeft(player1.getScore().getScoreGUI());

        lado_derecho.getChildren().addAll(player1.getScore().getScoreGUI(), tiempo.getTimerGUI());
        pantalla.setRight(lado_derecho);

        return pantalla;

    }

    public Pane generarLeaderBoard() {
        VBox fondo = new VBox();
        fondo.setAlignment(Pos.CENTER);
        Label titulo = generateH1("Leaderboard");

        Button btn_back = new Button("back");

        btn_back.setOnAction(u -> {
            changeScene(0);
        });

        fondo.getChildren().addAll(btn_back, titulo);
        return fondo;
    }
}
