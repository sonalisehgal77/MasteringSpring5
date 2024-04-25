package org.example.Apple;

public class AppleColorTest {
    AppleColor color;

    public AppleColorTest(AppleColor color) {
        this.color = color;
    }

    public void getColor() {
        switch (color) {
            case GREEN:
                System.out.println("GREEN color apple is good.");
                break;

            case RED:
                System.out.println("RED color Applea are very nutritious");
                break;

            case YELLOW:
                System.out.println("YELLOW color Applea are very nutritious");
                break;

            default:
                System.out.println("Other Apples are so-so.");
                break;
        }

    }
}
