/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Estructuras.ArrayList;
import Estructuras.CircularLinkedList2;

/**
 *
 * @author Kevin Zhang
 */
public class Palabra {
    
    CircularMatrix2 box;
    
    public Palabra(Integer f, Integer c){
        box = new CircularMatrix2(f,c);
    }
    
   public void cargarData(ArrayList<String> data){

    for (int i = 0; i < data.size(); i++) {
        String tmp = data.get(i);
        if (tmp.length() <= box.getColumnas()){
            CircularLinkedList2<Character> array_ = insertWord(tmp, box.getColumnas());
            System.out.println(array_.toString());
            box.add(array_);
        }
    }
    
    
   }
    
    
    public static CircularLinkedList2<Character> insertWord(String w, Integer lenght_max){
        
        CircularLinkedList2<Character> l = new CircularLinkedList2<Character>();
        if (w.length() > lenght_max) return l;
        
        
        Integer des_permitido = lenght_max - w.length() + 1;
        
        for (int i = 0; i < w.length(); i++) {
            l.addLast(w.charAt(i));
        }
        
        for (int i = w.length(); i < lenght_max; i++) {
            l.addLast('0');
        }
        
        Integer randomNum = (int)(Math.random() * des_permitido);
        
        l.desplazar(randomNum);
        return l;
    }
    
    @Override
    public String toString(){
        
        return box.toString();
    }
    
    public static void main(String[] args) {
        Palabra b = new Palabra(6,7);
        
        ArrayList<String> palabras = new ArrayList();
        palabras.addLast("Hola");       
        palabras.addLast("maleta");
        palabras.addLast("murcielago");
        palabras.addLast("barco");
        palabras.addLast("la");
        
        b.cargarData(palabras);
        
//        System.out.println(b.toString());

     }
}
