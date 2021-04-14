/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.game;

/**
 *
 * @author Dell
 */
public class Game {
    public Player[] players;
    public Dices dices;
    
    public Game (int dicesNumber, String ... names){
        dices = new Dices(dicesNumber);
        players = new Player[names.length];
        for (int i = 0; i < names.length; i++){
            players[i] = new Player(names[1]);
        }
    }
}
