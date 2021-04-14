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
public class Player {
    public final String name;
    public int winsNumber;
    
    public int lastRollValue;
    
    public Player(String name){
        this.name = name;
        winsNumber = 0;
        lastRollValue = 0;
    } 
}
