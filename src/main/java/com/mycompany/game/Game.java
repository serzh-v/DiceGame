package com.mycompany.game;

/**
 * Объект Game (Игра)
 * обеспечивает основную логику игры
 */
public class Game {
    public Player[] players;
    public Dices dices;

    // вспомогательная переменная, хранящая игрока-победителя 
    // после очередеого хода
    private int winner;
    //вспомогательная переменная, хранящая номер игрока, который делает ход
    //первым
    private int firstRoller;
       
    public Game (int dicesNumber, String ... names){
        dices = new Dices(dicesNumber);
        players = new Player[names.length];
        for (int i = 0; i < names.length; i++){
            players[i] = new Player(names[i]);
        }
    }
    
    /**
     * метод описывающий структуру одетльного броска для конкретного игрока и 
     * определяющий является ли на данный момент его резултат лучшим
     */
    private void move(int playerNum){
        System.out.println("    играет " + players[playerNum].name);
        dices.roll();
        System.out.println("    " + dices.getDices());
        players[playerNum].lastRollValue = dices.getSumm();
        if (players[playerNum].lastRollValue > players[winner].lastRollValue){
            winner = playerNum;
        }
    }
    
    /**
     * метод, который обнуляет значений последнего броска игроков перед каждым 
     * ходом
     */
    private void initRound() {
        winner = 0;
        for (int i = 0; i < players.length; i++) {
            players[i].lastRollValue = 0;
        }
    }
    
    /**
     * метод, который определяет победителя в отдельно взятом круге, выводит
     * имя победителя на экран и определяет кто ходит в следующем круге первым
     */
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
    
    /**
     * метод, определяющий победителя всей игры и выводящий его имя на экран
     */
    public void play(){
        System.out.println("Игра в кости");
        do {
            round();
        } while (players[winner].winsNumber < 7);
        System.out.println("Игра завершена, победидель - " + players[winner].name);
    }
}
