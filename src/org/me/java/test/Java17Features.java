package org.me.java.test;

// Sealed class must be top-level or static nested if inside another class
sealed class Shape permits Circle {
    int r = 4;

    public int getR() {
        System.out.println(this.r);
        return this.r;
    }
}

// Permitted subclass must be either final, sealed, or non-sealed
final class Circle extends Shape {}

public class Java17Features {
    public static void main(String[] args) {
        //1. Sealed Classes
        new Circle().getR();

        //2. Pattern Matching for instanceof
        Object obj = "Hello Java!";
        if (obj instanceof String s) {
            System.out.println(s.length());
        }

        //3. Record Class (must be declared at top-level or static nested)
        Player rcb18 = new Player("King", "Kohli", 18);
        Player msd7 = new Player("Thala", "Dhoni", 7);
        System.out.println(rcb18.first());
        System.out.println(msd7.last());


        //4. Switch Case Enhancements
        int day = 4;
        String type = switch (day) {
            case 6, 7 -> "Weekend";
            default -> "Weekday";
        };
        System.out.println(type);
    }

    // Nested static record declaration (records cannot be local inside a method before Java 21)
    public static record Player(String last, String first, int level) {}
}