/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras5;

import Estructuras.ArrayList;
import Estructuras.List;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author kazp_
 */
public class ScreenController {
    private Stage root;
    private Pane currentPane;
    
    private List<Pane> panes;
    private int height, width;

    public ScreenController(Stage root, Pane currentPane) {
        this.root = root;
        this.currentPane = currentPane;
        panes = new ArrayList<>();
        
        panes.add(0, this.generateMainMenu());
        panes.addLast(this.generatePlayground());
        this.setCurrentPane(panes.get(0));
        this.refreshScene();
    }
    
    public void refreshScene(){
        Scene scene = new Scene(this.currentPane, this.height, this.width);
        root.setScene(scene);
    }
    
    public void changeScene(int id){
        this.currentPane = panes.get(id);
        this.refreshScene();
    }

    public Stage getRoot() {
        return root;
    }

    public void setRoot(Stage root) {
        this.root = root;
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
        
        return main;
    }
    
    private Pane generatePlayground(){
        VBox main = new VBox();
        
        Label title = new Label("Playground");
        
        main.getChildren().add(title);
        
        return main;
    }
    
}
