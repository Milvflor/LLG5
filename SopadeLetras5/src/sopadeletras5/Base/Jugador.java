/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras5.Base;

import sopadeletras5.Modalidad.Score;

/**
 *
 * @author milca
 */
public class Jugador {
    private String nombre;
    private Score puntuacion;
    private Jugador rival;
    private int error;
    
    
    public Jugador(String nombre){
        this.nombre=nombre;
        this.rival=null;
        this.puntuacion=new Score();
        this.error=3;
    }
    
    public void setRival(Jugador rival){
        this.rival=rival;
    }
    
    public void puntuar(String palabra){
        this.puntuacion.addPoints(palabra);
    }
    
    public Score getScore(){
        return puntuacion;
    }
    
    public void cometerError(String palabra){
        this.error=this.error-1;
        this.puntuacion.losePoints(palabra);
    }
    
    public int getErrores(){
        return error;
    }
}
