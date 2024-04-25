package org.example.Apple;

import static org.example.Apple.AppleColor.GREEN;

public class Apple {
    //    public static boolean getColor() {
//        return
//    }
    public static boolean isGREENApple(AppleColorTest apple) {
        return GREEN.equals(apple.getColor());
    }

    public static boolean isHEAVYApple(Apple apple) {
        return apple.getWeight() > 150;
    }
}


