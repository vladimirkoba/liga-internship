package ru.liga.fromuml;

import ru.liga.fromuml.Realization.BathRoom;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        BathRoom room = new BathRoom(1d,5d);

        System.out.print(String.valueOf(room.getWidth()));
    }
}
