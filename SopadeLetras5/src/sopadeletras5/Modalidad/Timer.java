/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras5.Modalidad;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author milca
 */
public class Timer extends Thread {
    private int Horas;
    private int Minutos;
    private int Segundos;
    
    private int HorasR;
    private int MinutosR;
    private int SegundosR;
    
    
    
    private boolean activo;
    private Thread hilo;
    
    
    private Label lbl_titulo;
    private Label lbl_Minutos;
    private Label lbl_separador;
    private Label lbl_Segundos;
    
    
    
    private HBox TimerGUI;
    
    
    public Timer(int horas,int minutos,int segundos){
        this.hilo=new Thread();
        this.activo=true;
        
        this.Horas=horas;
        this.Minutos=minutos;
        this.Segundos=segundos;
        
        this.HorasR=horas;
        this.MinutosR=minutos;
        this.SegundosR=segundos;
        
        
        generarGUI();
        
    }

    @Override
    public void run() {
            
           while(activo){
               try {
                   if(Segundos>0){
                       Segundos--;
                       hilo.sleep(1000);
                   }else if(Minutos>0){
                       Minutos--;
                       Segundos=59;
                   }else{
                       Horas--;
                       Minutos=59;
                   }
                }catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
                }
               
               
                if(Horas ==0 && Minutos==0 && Segundos==0){
                    parar();
                }
//                System.out.println(""+Horas+":"+Minutos+":"+Segundos);
                Platform.runLater(()->lbl_Minutos.setText(""+Minutos));
                Platform.runLater(()->lbl_Segundos.setText(""+Segundos));
           }   
 
    }
    
    public void iniciar(){
        hilo.start();
    }
    
    public void parar(){
        this.activo=false;
    }
    
    public void reset(){
        this.Horas=HorasR;
        this.Minutos=MinutosR;
        this.Segundos=SegundosR;
    }
    
    public void setTiempo(int horas,int minutos,int segundos){
        this.Horas=horas;
        this.Minutos=minutos;
        this.Segundos=segundos;
        
        this.HorasR=horas;
        this.MinutosR=minutos;
        this.SegundosR=segundos;
    }

    public int getHoras() {
        return Horas;
    }

    public int getMinutos() {
        return Minutos;
    }

    public int getSegundos() {
        return Segundos;
    }
    
    public void actualizar(){
        lbl_Minutos.setText(""+Minutos);
        lbl_Segundos.setText(""+Segundos);
    }

    public Label getLbl_Minutos() {
        return lbl_Minutos;
    }

    public Label getLbl_Segundos() {
        return lbl_Segundos;
    }

    public HBox getTimerGUI() {
        return TimerGUI;
    }
    
    public void generarGUI(){
        TimerGUI=new HBox();
        TimerGUI.setStyle("-fx-background-color:#FCC936;");
        lbl_titulo=new Label("Tiempo ");
        lbl_Minutos=new Label(""+Minutos);
        lbl_separador=new Label(":");
        lbl_Segundos=new Label(""+Segundos);
        TimerGUI.getChildren().addAll(lbl_titulo,lbl_Minutos,lbl_separador,lbl_Segundos);
    }
    
    
}
