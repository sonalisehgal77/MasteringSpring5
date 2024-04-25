package org.example;

import org.example.Apple.Apple;

import java.util.ArrayList;
import java.util.List;

import static org.example.Apple.AppleColor.GREEN;

public class Main {
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(GREEN.equals(apple.getColor())){
                result.add(apple);
            }
            return  result;
        }
    }
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }

}