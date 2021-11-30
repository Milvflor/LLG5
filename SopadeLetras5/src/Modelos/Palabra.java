/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Estructuras.ArrayList;
import Estructuras.CircularLinkedList;
import Estructuras.CircularLinkedList2;
import Estructuras.Tupla;
import java.util.Iterator;

/**
 *
 * @author Kevin Zhang
 */
public class Palabra {
    
    CircularMatrix2<Character> box;
    
    public Palabra(Integer f, Integer c){
        box = new CircularMatrix2(f,c);
    }
    
   public void cargarPalabras(ArrayList<String> data){
       CircularLinkedList2<Character> array_;
       int insertadas = 0;
       
       for (int i = 0; i < data.size(); i++) {
           String tmp = data.get(i);
           if (tmp.length() <= box.getColumnas()){
               array_ = insertWord(tmp, box.getColumnas());
//               System.out.println(array_.toString());
               box.add(array_);
               insertadas++;
            }   
        }
       
        array_ = new CircularLinkedList2<Character>();
        array_.full('0', box.getColumnas());
        while(insertadas <= box.getFilas()){
            box.add(array_);
//            System.out.println(array_.toString());
            insertadas++;
        }
   }
   
   public void getTabla(){
       System.out.println(box.toString());
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
    
    public void shuffleF(){
        box.desordenar();
    }
    
    public ArrayList<Tupla<Integer, Integer>> getNullsIndex(){
        
        CircularLinkedList2<Character> tmp;
        
        ArrayList<Tupla<Integer, Integer>> r = new ArrayList<>();
        
        for (int f = 0; f < this.box.getFilas(); f++) {
            int col = 0;
            tmp = this.box.getMatrix().get(f);
            Iterator<Character> it = tmp.iterator();
            while(it.hasNext()){
                Character c = it.next();
                
                if (c.equals('0')){
                    r.addLast(new Tupla(f, col));
                }
                col++;
            }
        }
        return r;
    }
    
    
     
    
    
     
    
    public static void main(String[] args) {
        Palabra b = new Palabra(9,7);
        
        ArrayList<String> palabras = new ArrayList();
        palabras.addLast("Hola");       
        palabras.addLast("maleta");
        palabras.addLast("murcielago");
        palabras.addLast("barco");
        palabras.addLast("mouse");
        palabras.addLast("monitor");
        palabras.addLast("teclado");
        palabras.addLast("amigos");

        
        
        b.cargarPalabras(palabras);
        b.getTabla();
        System.out.println("==================================");
        b.shuffleF();
        b.getTabla();
        System.out.println(b.getNullsIndex());;
        
//        ArrayList<Tupla<Integer, Integer>> indices = new ArrayList<>();
//        
//        indices.addLast(new Tupla(1,4));       
//        indices.addLast(new Tupla(1,5));
//        indices.addLast(new Tupla(1,6));
//        indices.addLast(new Tupla(2,6));
//
//        System.out.println(indices.toString());

     }
}
