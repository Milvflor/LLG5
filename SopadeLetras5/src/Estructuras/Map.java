/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Kevin Zhang <kzhang@espol.edu.ec>
 */
public interface Map<K,V> {
    
    public abstract void put(K key,V value);
    public abstract void putIfAbsent(K key, V value);
    public abstract void remove(K key);
    public abstract V get(K key);
    public abstract Set<K> keySet();
    public abstract void clear();
    public abstract void replace(K key, V value);
    public abstract int size();
    
}
