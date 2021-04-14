/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.game;

/**
 * Объект Game (Игра)
 * обеспечивает основную логику игры
 * @author Dell
 */
public class Game {
    public Player[] players;
    public Dices dices;

    // вспомогательная переменная, хранящая игрока-победителя 
    // после очередеого хода
    private int winner;
    private int firstRoller;
       
    public Game (int dicesNumber, String ... names){
        dices = new Dices(dicesNumber);
        players = new Player[names.length];
        for (int i = 0; i < names.length; i++){
            players[i] = new Player(names[i]);
        }
    }
    
    private void move(int playerNum){
        System.out.println("    играет " + players[playerNum].name);
        dices.roll();
        System.out.println("    " + dices.getDices());
        players[playerNum].lastRollValue = dices.getSumm();
        if (players[playerNum].lastRollValue > players[winner].lastRollValue){
            winner = playerNum;
        }
    }
    
    private void initRound() {
        winner = 0;
        for (int i = 0; i < players.length; i++) {
            players[i].lastRollValue = 0;
        }
    }
    
    private void round(){
        System.out.println("  Круг");
        initRound();
        int currentPlayer = firstRoller;
        for (int i = 0; i < players.length; i++){
            move(currentPlayer);

            currentPlayer++;
            if (currentPlayer >= players.length) {
                currentPlayer = 0;
            }
        }
        players[winner].winsNumber++;
        System.out.println(
                "   Выиграл " + 
                players[winner].name + 
                " - " + 
                players[winner].winsNumber + 
                " побед");
        firstRoller = winner;
    }
    
    public void play(){
        System.out.println("Игра в кости");
        do {
            round();
        } while (players[winner].winsNumber < 7);
        System.out.println("Игра завершена, победидель - " + players[winner].name);
    }
}
