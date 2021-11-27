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
 * @author kazp_
 */
public class ScreenController {
    private Scene context;
    private Pane currentPane;
    
    private List<Pane> panes;
    private int height, width;

    public ScreenController(int height, int width) {
        panes = new ArrayList<>();
        
        panes.addLast(this.generateMainMenu());
        panes.addLast(this.generatePlayground());
        this.setCurrentPane(panes.get(0));
        this.context = new Scene(currentPane, height, width);
    }
    
    public void refreshScene(){        
        context.setRoot(currentPane);
    }
    
    public void showScene(){
        
    }
    
    public void changeScene(int id){
        this.currentPane = panes.get(id);
        this.refreshScene();
    }

    public Scene getContext() {
        return context;
    }

    public void setContext(Scene context) {
        this.context = context;
    }

    public Pane getCurrentPane() {
        return currentPane;
    }

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
