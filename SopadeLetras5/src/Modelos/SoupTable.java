/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Estructuras.ArrayList;
import Estructuras.CircularLinkedList;
import Estructuras.CircularLinkedList2;
import Estructuras.List;
import Estructuras.Tupla;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Kevin Zhang
 */
public class SoupTable {

    private CircularMatrix2<Character> box;
    private List<String> rezagadas;
    private List<String> almacenadas;
    private Character[] abece = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n','ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static String RUTA = System.getProperty("user.dir") + "/src/data/";

    
    public SoupTable(Integer f, Integer c) {
        box = new CircularMatrix2(f, c);
        rezagadas = new ArrayList<>();
        almacenadas = new ArrayList<>();
    }

    public static List<String> cargarPalabras(String filename) throws FileNotFoundException, IOException {
        List<String> palabras = new ArrayList<>();
        System.out.println(filename);
        String row;
        BufferedReader csvReader = new BufferedReader(new FileReader(RUTA + filename + ".csv"));
        while ((row = csvReader.readLine()) != null) {
            palabras.addLast(row);
        }
        csvReader.close();
        return palabras;
    }

    private void cargarPalabras(List<String> data) {
        CircularLinkedList2<Character> array_;
        int insertadas = 0;

        for (int i = 0; i < data.size(); i++) {
            String tmp = data.get(i);
            if (tmp.length() <= box.getColumnas() && insertadas <= box.getFilas() - 1) {
                array_ = insertWord(tmp, box.getColumnas());
//               System.out.println(array_.toString());
                box.add(array_);
                almacenadas.addLast(tmp);
                insertadas++;
            } else {
                rezagadas.addLast(tmp);
            }
        }

        array_ = new CircularLinkedList2<Character>();
        array_.full('0', box.getColumnas());
        while (insertadas <= box.getFilas()) {
            box.add(array_);
//            System.out.println(array_.toString());
            insertadas++;
        }
    }

    public void getTabla() {
        System.out.println(box.toString());
    }

    private static CircularLinkedList2<Character> insertWord(String w, Integer lenght_max) {

        CircularLinkedList2<Character> l = new CircularLinkedList2<Character>();
        if (w.length() > lenght_max) {
            return l;
        }

        Integer des_permitido = lenght_max - w.length() + 1;

        for (int i = 0; i < w.length(); i++) {
            l.addLast(w.charAt(i));
        }

        for (int i = w.length(); i < lenght_max; i++) {
            l.addLast('0');
        }

        Integer randomNum = (int) (Math.random() * des_permitido);

        l.desplazar(randomNum);
        return l;
    }

    private void shuffleF() {
        box.desordenar();
    }

    private ArrayList<Tupla<Integer, Integer>> getNullsIndex() {

        CircularLinkedList2<Character> tmp;

        ArrayList<Tupla<Integer, Integer>> r = new ArrayList<>();

        for (int f = 0; f < this.box.getFilas(); f++) {
            int col = 0;
            tmp = this.box.getMatrix().get(f);
            Iterator<Character> it = tmp.iterator();
            while (it.hasNext()) {
                Character c = it.next();

                if (c.equals('0')) {
                    r.addLast(new Tupla(f, col));
                }
                col++;
            }
        }
        return r;
    }

    private static Map<Integer, ArrayList> agruparIndices(ArrayList<Tupla<Integer, Integer>> indices) {
        Map<Integer, ArrayList> mp = new HashMap<>();

        for (int i = 0; i < indices.size(); i++) {
            Tupla tmp = indices.get(i);
            if (!mp.containsKey((Integer) tmp.getDerecha())) {
                ArrayList<Tupla> sublist = new ArrayList<>();
                sublist.addLast(tmp);
                mp.put((Integer) tmp.getDerecha(), sublist);
            } else {
                mp.get((Integer) tmp.getDerecha()).addLast(tmp);
            }
        }
        return mp;
    }

    private static Map<Integer, ArrayList> consecutivos(ArrayList<Tupla> list) {

        Map<Integer, ArrayList> mp = new HashMap<>();

        ArrayList<Tupla> array = new ArrayList<>();

        Integer init = null;
        for (int i = 0; i < list.size(); i++) {
            Tupla t = list.get(i);
            Integer n = (Integer) t.getIzquierda();
            if (init == null) {
                init = n;
                array.addLast(t);
                init++;
            } else {
                if (init.equals(n)) {
                    array.addLast(t);
                    init++;
                    if (init == list.size() && array.size() >= 4) {
                        mp.put((Integer) array.get(0).getIzquierda(), array);
                    }
                } else {
                    if (array.size() < 4) {
                        array = new ArrayList<>();
                    } else {
                        mp.put((Integer) array.get(0).getIzquierda(), array);
                        array = new ArrayList<>();
                    }
                    init = null;
                }
            }
        }

        return mp;
    }

    private boolean addVertical(String palabra, ArrayList<Tupla> indices) {

        if (palabra.length() > indices.size() || indices.isEmpty() || palabra.isEmpty()) {
            return false;
        }

        for (int i = 0; i < palabra.length(); i++) {
            Tupla indiceT = indices.get(i);
            this.box.getMatrix().get((Integer) indiceT.getIzquierda()).replaceV((Integer) indiceT.getDerecha(), palabra.charAt(i));
        }
        return true;
    }

    private String getWord(Integer len_) {
        String s = "";
        for (int i = 0; i < this.rezagadas.size(); i++) {
            String r = rezagadas.get(i);
            if (r.length() <= len_) {
                rezagadas.remove(i);
                almacenadas.addLast(r);
                return r;
            }
        }
        return s;
    }

    public List<String> getRezagadas() {
        return rezagadas;
    }

    private void fuller() {
        ArrayList<Tupla<Integer, Integer>> nulls = this.getNullsIndex();
        for (int i = 0; i < nulls.size(); i++) {
            Character letra = abece[(int) (Math.random() * abece.length)];
            Tupla indiceT = nulls.get(i);
            Integer f = (Integer) indiceT.getIzquierda();
            Integer c = (Integer) indiceT.getDerecha();
            CircularLinkedList2 a = this.box.getMatrix().get(f);
//            System.out.println(a);
            a.replaceV(c, letra);
//            System.out.println(a);
        }

    }

    public List<String> getAlmacenadas() {
        return almacenadas;
    }

    public void generate(List<String> palabras) {

        //Agregando palabras rezagadas en Horizontal
        this.cargarPalabras(palabras);
        this.shuffleF();

        ArrayList<Tupla<Integer, Integer>> r = this.getNullsIndex();
        Map<Integer, ArrayList> mpIndicesAll = agruparIndices(r);

        //Agregando palabras rezagadas en Vertical
        for (Integer i : mpIndicesAll.keySet()) {
            Map<Integer, ArrayList> m = consecutivos(mpIndicesAll.get(i));
            if (!m.isEmpty()) {

                for (Integer f : m.keySet()) {
                    ArrayList a = m.get(f);
                    String s;
                    s = this.getWord(a.size());

                    if (s != "") {
                        this.addVertical(s, a);
                    }
                }

            }
        }
        this.fuller();
//        this.getTabla();    
    }

    public CircularMatrix2<Character> getBox() {
        return box;
    }

    public static void main(String[] args) {

        SoupTable b = new SoupTable(7, 9);

//
        ArrayList<String> palabras = new ArrayList();
        palabras.addLast("hola");
        palabras.addLast("maleta");
        palabras.addLast("murcielago");
        palabras.addLast("barco");
        palabras.addLast("mouse");
        palabras.addLast("monitor");
        palabras.addLast("teclado");
        palabras.addLast("amigos");
        palabras.addLast("PEDRO");
        palabras.addLast("CARAMELO");
        palabras.addLast("PLATILLO");
        palabras.addLast("PELUCA");
        palabras.addLast("VENTANA");

        b.generate(palabras);

    }
}
