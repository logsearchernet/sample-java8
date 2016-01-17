/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sample.java8;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author User
 */
public class TestForEach {

    public static void main(String[] args) {
        normalWay();
        java8Way();
    }

    protected static void normalWay() {
        System.out.println("com.mycompany.sample.java8.TestForEach.normalWay()");
        Map<String, Integer> items = getMap();
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }
    }

    protected static void java8Way() {
        System.out.println("com.mycompany.sample.java8.TestForEach.java8Way()");
        Map<String, Integer> items = getMap();
        items.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));

        items.forEach((k, v) -> {
            System.out.println("Item : " + k + " Count : " + v);
            if ("E".equals(k)) {
                System.out.println("Hello E");
            }
        });
    }

    private static Map<String, Integer> getMap() {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);
        return items;
    }
}
