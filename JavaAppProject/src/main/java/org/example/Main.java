package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List artists = new ArrayList();
        artists.add("One");artists.add("Two");artists.add("Three");artists.add("Four");artists.add("Five");artists.add("Six");

        long count = artists.stream(artists->isFrom("London")).count();
        System.out.println(count);

    }

//    private static Object isFrom(String state) {
//
//    }
}