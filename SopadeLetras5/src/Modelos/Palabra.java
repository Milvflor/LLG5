/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Estructuras.ArrayList;
import Estructuras.CircularLinkedList;
import Estructuras.List;
import Estructuras.Tupla;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 *
 * @author Kevin Zhang
 */
public class Palabra {
    
    CircularMatrix<Character> box;
    private static String RUTA = System.getProperty("user.dir") + "/src/data/"; 

    
    public Palabra(Integer f, Integer c){
        box = new CircularMatrix(f,c);
    }
    
   public void cargarPalabras(ArrayList<String> data){
       CircularLinkedList<Character> array_;
       int insertadas = 0;
       
       for (int i = 0; i < data.size(); i++) {
           String tmp = data.get(i);
           if (tmp.length() <= box.getCols()){
               array_ = insertWord(tmp, box.getCols());
//               System.out.println(array_.toString());
               box.add(array_);
               insertadas++;
            }   
        }
       
        array_ = new CircularLinkedList<Character>();
        array_.full('0', box.getCols());
        while(insertadas <= box.getRows()){
            box.add(array_);
//            System.out.println(array_.toString());
            insertadas++;
        }
   }
   
   public void getTabla(){
       System.out.println(box.toString());
   }
    
    
    public static CircularLinkedList<Character> insertWord(String w, Integer lenght_max){
        
        CircularLinkedList<Character> l = new CircularLinkedList<Character>();
        if (w.length() > lenght_max) return l;
        
        
        Integer des_permitido = lenght_max - w.length() + 1;
        
        for (int i = 0; i < w.length(); i++) {
            l.addLast(w.charAt(i));
        }
        
        for (int i = w.length(); i < lenght_max; i++) {
            l.addLast('0');
        }
        
        Integer randomNum = (int)(Math.random() * des_permitido);
        
        l.move(randomNum);
        return l;
    }
    
    public void shuffleF(){
        box.scramble();
    }
    
    public List<Tupla<Integer, Integer>> getNullsIndex(){
        
        List<Character> tmp;
        
        List<Tupla<Integer, Integer>> r = new ArrayList<>();
        
        for (int f = 0; f < this.box.getRows(); f++) {
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
    
    public List<String> cargarPalabras(String filename) throws FileNotFoundException, IOException {
        List<String> palabras = new ArrayList<>();
        
        String row;
        BufferedReader csvReader = new BufferedReader(new FileReader(RUTA + filename + ".csv"));
        while ((row = csvReader.readLine()) != null) {
            palabras.addLast(row);
        }
        csvReader.close();
        
        return palabras;
    }
}
