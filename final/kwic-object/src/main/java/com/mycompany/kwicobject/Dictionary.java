/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kwicobject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author j
 */
public class Dictionary<K, V> {
    private Map<K, V> dict = new HashMap<K, V>();

    public Map<K, V> getDict() {
        return dict;
    }

    public void setDict(Map<K, V> dict) {
        this.dict = dict;
    }

    public boolean containsKey(K key){
        return dict.containsKey(key);
    }
    
    public V get(K key){
        return dict.get(key);
    }

    void put(K key, V value) {
        dict.put(key, value);
    }
}
