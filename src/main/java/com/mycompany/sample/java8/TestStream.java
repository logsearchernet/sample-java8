/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sample.java8;

import com.mycompany.sample.java8.model.Developer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author User
 */
public class TestStream {
    
    
    public static void main(String[] args) {
        
        getList().stream().findFirst().ifPresent(System.out::println);
        
        getDevelopers().stream().findFirst().ifPresent(System.out::println);
        
        
        /*
        sort: Developer{name=alvin, salary=80000, age=20}; Developer{name=mkyong, salary=70000, age=33}
        sort: Developer{name=jason, salary=100000, age=10}; Developer{name=alvin, salary=80000, age=20}
        sort: Developer{name=jason, salary=100000, age=10}; Developer{name=mkyong, salary=70000, age=33}
        sort: Developer{name=jason, salary=100000, age=10}; Developer{name=alvin, salary=80000, age=20}
        sort: Developer{name=iris, salary=170000, age=55}; Developer{name=jason, salary=100000, age=10}
        sort: Developer{name=iris, salary=170000, age=55}; Developer{name=alvin, salary=80000, age=20}
        map: Developer{name=alvin, salary=80000, age=20}
        filter: ALVIN
        forEach ==>ALVIN
        map: Developer{name=iris, salary=170000, age=55}
        filter: IRIS
        map: Developer{name=jason, salary=100000, age=10}
        filter: JASON
        map: Developer{name=mkyong, salary=70000, age=33}
        filter: MKYONG
         */
        getDevelopers().stream()
            .sorted((s1, s2) -> {
                System.out.printf("sort: %s; %s\n", s1, s2);
                return s1.getName().compareTo(s2.getName());
            })    
            .map(s -> {
                System.out.println("map: " + s);
                return s.getName().toUpperCase();
            })
            .filter(s -> {
                System.out.println("filter: " + s);
                return s.startsWith("A");
            })
            .forEach(s -> System.out.println("forEach ==>" + s));
        
        /*
        LIST==>Developer{name=mkyong, salary=70000, age=33}
        LIST==>Developer{name=alvin, salary=80000, age=20}
        LIST==>Developer{name=iris, salary=170000, age=55}
        */
        List<Developer> list = getDevelopers().stream()
            .filter(l -> l.getAge() > 10)
            .collect(Collectors.toList());
        for (Developer developer : list) {
            System.out.println("LIST==>"+ developer);
        }
            
    }
    
    private static List<String> getList(){
        List<String> list = new ArrayList<>();
        list.add("line 1");
        list.add("line 2");
        list.add("line 3");
        
        return list;
    }
    private static List<Developer> getDevelopers() {

        List<Developer> result = new ArrayList<>();

        result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
        result.add(new Developer("alvin", new BigDecimal("80000"), 20));
        result.add(new Developer("jason", new BigDecimal("100000"), 10));
        result.add(new Developer("iris", new BigDecimal("170000"), 55));

        return result;
    }
    
}
