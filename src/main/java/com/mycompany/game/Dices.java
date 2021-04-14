/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.game;

import java.util.Random;
/**
 *
 * @author Dell
 */
public class Dices {
    private final int dicesNumber;
    private final int dices[];
    private Random random;
    
    public Dices(int dicesNumber){
        this.dicesNumber = dicesNumber;
        dices = new int [dicesNumber];
        random = new Random();
    }
    
    public void roll(){
        for (int i = 0; i < dices.length; i++){
            dices[i] = random.nextInt(6) + 1;
        }
    }
    
    public int[] getResult(){
        return dices;
    }
    
    public int getSumm(){
        int s = 0;
        for (int d: dices){
            s = s + d;           
        }
        return s;
    }
    
    public String getDices(){
        String s = "";
        for (int d: dices){
            s += "[" + d + "] ";
        }
        return s + getSumm();
    }
}
