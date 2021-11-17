/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras5.Modalidad;

import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    
    public Timer(int horas,int minutos,int segundos){
        this.hilo=new Thread();
        this.activo=true;
        
        this.Horas=horas;
        this.Minutos=minutos;
        this.Segundos=segundos;
        
        this.HorasR=horas;
        this.MinutosR=minutos;
        this.SegundosR=segundos;
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
                System.out.println(""+Horas+":"+Minutos+":"+Segundos);
           }   
 
    }
    
    public void iniciar(){
        this.hilo.start();
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
}
