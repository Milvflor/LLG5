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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Kevin Zhang
 */
public class ScreenController {
    private Scene context;
    private Pane currentPane;
    
    private List<Pane> panes;
    private int height, width;

    /**
     *
     * @param height
     * @param width
     */
    public ScreenController(int height, int width) {
        panes = new ArrayList<>();
        
        panes.addLast(this.generateMainMenu());
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
        
    private Pane generateMainMenu(){
        VBox main = new VBox();
        
        Label title = new Label("Menu principal");
        
        main.getChildren().add(title);
        
        Button button = new Button("Cambiar");
        
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeScene(1);
            }
        });
        
        main.getChildren().add(button);
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
    
    private Pane generatePlayground(){
        VBox main = new VBox();
        
        Label title = new Label("Playground");
        
        main.getChildren().add(title);
        
        return main;
    }
    
}
