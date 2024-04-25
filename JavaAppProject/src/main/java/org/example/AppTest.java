package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class AppTest {

    String quantityOfApples[] = {"red", "green", "orange"};

    List listOfApples = Arrays.stream(quantityOfApples).collect(Collectors.toList());

    long count = quantityOfApples.length;

//
//    System.out.print(listOfApples);
//    System.out.println(count);

//    public Arrays[] getQuantityOfApples() {
//        return quantityOfApples;
//    }
}
