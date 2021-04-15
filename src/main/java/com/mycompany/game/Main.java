package com.mycompany.game;

/**
 * класс, в котором можно ввести параметры игры
 */
public class Main {
    
    public static void main(String [] args) {
        Game myGame = new Game(4,"Сергей", "Андрей", "Computer");
        myGame.play();
    }
}
