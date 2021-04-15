package com.mycompany.game;

import java.util.Random;
/**
 *объект кости описывает логику действий, происходящих во время броска
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
    
    /**
     * во время броска создается массив длиной равной количеству костей
     * со значениями от 1 до 6
     */
    public void roll(){
        for (int i = 0; i < dices.length; i++){
            dices[i] = random.nextInt(6) + 1;
        }
    }
    
    
    public int[] getResult(){
        return dices;
    }
    
    /**
     * метод возвращает значение суммы цифр выпавших на всех кубиках
     */
    public int getSumm(){
        int s = 0;
        for (int d: dices){
            s = s + d;           
        }
        return s;
    }
    
    /**
     * метод в котором создается объект типа String, в который записываются
     * все значения, выпавшие на кубиках и общая сумма броска
     */
    public String getDices(){
        String s = "";
        for (int d: dices){
            s += "[" + d + "] ";
        }
        return s + getSumm();
    }
}
